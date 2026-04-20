package com.example.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class StubDelayFilter extends OncePerRequestFilter {

    @Value("${stub.delay.enabled:false}")
    private boolean delayEnabled;

    @Value("${stub.delay.ms:0}")
    private long delayMs;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println(">>> StubDelayFilter HIT: " + request.getMethod() + " " + request.getRequestURI()
                + " X-Delay-Enabled=" + request.getHeader("X-Delay-Enabled")
                + " X-Delay-Ms=" + request.getHeader("X-Delay-Ms"));

        // Заголовки (если передали — они главнее настроек)
        String headerEnabled = request.getHeader("X-Delay-Enabled");
        String headerMs = request.getHeader("X-Delay-Ms");

        boolean enabled = (headerEnabled != null)
                ? Boolean.parseBoolean(headerEnabled)
                : delayEnabled;

        long ms = delayMs;
        if (headerMs != null) {
            try {
                ms = Long.parseLong(headerMs);
            } catch (NumberFormatException ignored) {
                // если прислали мусор — просто используем значение по умолчанию
            }
        }

        // Применяем задержку
        if (enabled && ms > 0) {
            try {System.out.println(">>> StubDelayFilter SLEEP " + ms + " ms");
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Пропускаем дальше в контроллер
        filterChain.doFilter(request, response);
    }
}
