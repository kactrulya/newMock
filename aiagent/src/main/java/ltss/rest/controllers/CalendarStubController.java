package ltss.rest.controllers;

import jakarta.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

@RestController
@RequestMapping("/calendar/api/v1")
public class CalendarStubController {


    @PostConstruct
    public void init() {
        System.out.println(">>> CalendarStubController LOADED");
    }
    // 1) Получение таймзоны сотрудника
    @GetMapping("/employee/{employeeNumber}/timezone")
    public Map<String, String> getTimezone(@PathVariable String employeeNumber) {
        // employeeNumber пока не используем — просто принимаем, чтобы путь работал
        return Map.of("timezone", "UTC +3");
    }


    // 2) Похожая встреча
    @PostMapping(value = "/activities/similar/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchSimilar(@RequestBody String body) {
        // Здесь body уже гарантированно не null — Spring вернёт 400 Bad Request автоматически,
        // если тело запроса отсутствует или невалидно

        // Далее — можно проверить содержимое (например, employeeNumber)
        if (!body.contains("employeeNumber") || body.contains("\"employeeNumber\":null")) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of(
                            "error", Map.of(
                                    "code", "VALIDATION_ERROR",
                                    "message", "Обязательное поле employeeNumber отсутствует или имеет значение null"
                            )
                    ));
        }

        // Успешный JSON-ответ
        String json = """
    {
      "id": "19de01ff-8bc9-4158-9945-1c93f98a5914",
      "version": "1",
      "type": "INT_MEETING",
      "planDateTime": {
        "start": "2025-01-01T17:00:00+03:00",
        "end": "2025-01-01T17:00:00+03:00"
      },
      "description": "Обсудить проценты по вкладам и накопительным счетам",
      "themes": [
        "DEPOSITS",
        "SAVINGS_ACCOUNT"
      ]
    }
    """;
        return ResponseEntity.ok(json);
    }

    /*@PostMapping(value = "/activities/similar/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchSimilar(@RequestBody(required = false) String body) {
        return """
    {
      "id": "19de01ff-8bc9-4158-9945-1c93f98a5914",
      "version": "1",
      "type": "INT_MEETING",
      "planDateTime": {
        "start": "2025-01-01T17:00:00+03:00",
        "end": "2025-01-01T17:00:00+03:00"
      },
      "description": "Обсудить проценты по вкладам и накопительным счетам",
      "themes": [
        "DEPOSITS",
        "SAVINGS_ACCOUNT"
      ]
    }
    """;
    }*/

    // 3) Свободные слоты + конфликт
    @PostMapping(value = "/slots/search", produces = "application.properties/json")
    public String searchSlots(@RequestBody(required = false) String body) {
        return """
    [
      {
        "date": "2025-01-01",
        "isWorkDay": true,
        "slots": [
          {
            "startTime": "2025-01-01T15:00:00+03:00",
            "endTime": "2025-01-01T15:30:00+03:00"
          },
          {
            "startTime": "2025-01-01T15:00:00+03:00",
            "endTime": "2025-01-01T15:30:00+03:00"
          }
        ]
      },
      {
        "date": "2025-01-02",
        "isWorkDay": true,
        "slots": [
          {
            "startTime": "2025-01-02T15:00:00+03:00",
            "endTime": "2025-01-02T15:30:00+03:00"
          },
          {
            "startTime": "2025-01-02T15:00:00+03:00",
            "endTime": "2025-01-02T15:30:00+03:00"
          }
        ]
      },
      {
        "date": "2025-01-03",
        "isWorkDay": false
      }
    ]
    """;
    }

    // 4) Создание активностей /calendar/api/v1/activities
    @PostMapping(value = "/activities", produces = "application.properties/json")
    public String createActivity(@RequestBody(required = false) String body) {
        return """
    {
      "id": "19de01ff-8bc9-4158-9945-1c93f98a5914"
    }
    """;
    }

    // 5) Обновление активности (PUT)
    @PutMapping(value = "/activities/{activityId}", produces = "application.properties/json")
    public String updateActivityPut(@PathVariable String activityId,
                                    @RequestBody(required = false) String body) {
        // activityId можно вернуть в ответе, чтобы было “по-настоящему”
        return """
    {
      "id": "%s"
    }
    """.formatted(activityId);
    }

    // 6) Обновление активности (PATCH)
    @PatchMapping(value = "/activities/{activityId}", produces = "application.properties/json")
    public String updateActivityPatch(@PathVariable String activityId,
                                      @RequestBody(required = false) String body) {
        return """
    {
      "id": "%s"
    }
    """.formatted(activityId);
    }
}