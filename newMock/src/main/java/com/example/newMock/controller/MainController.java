package com.example.newMock.controller;

import com.example.newMock.model.RequestDTO;
import com.example.newMock.model.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Random;

@RestController
public class MainController {

    private Logger log = LoggerFactory.getLogger(MainController.class); //Для логирования заглушки

    ObjectMapper mapper = new ObjectMapper();
    private final Random random = new Random();

    @PostMapping(
            value = "/info/postBalances",
            produces = MediaType.APPLICATION_JSON_VALUE,  // типы данных которые получаем
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Object postBalances(@RequestBody RequestDTO requestDTO) {
        try {
            String clientId = requestDTO.getClientId();
            char firsDigit = clientId.charAt(0);
            BigDecimal maxLimit;
            String currency = "";
            String rqUID = requestDTO.getRqUID();

            if (firsDigit == '8') {
                maxLimit = new BigDecimal(2000);
                currency = new String("US");
            } else if (firsDigit == '9') {
                maxLimit = new BigDecimal(1000);
                currency = new String("EU");
            } else {
                maxLimit = new BigDecimal(10000);
                currency = new String("RUB");
            }

            ResponseDTO responseDTO = new ResponseDTO();

//            ResponseDTO requestDTO1 = new ResponseDTO(
//                    rqUID,
//                    clientId,
//                    responseDTO.getAccount(),
//                    "RUB",
//                    new BigDecimal(777),
//                    maxLimit);
            BigDecimal balance = getRandomBigDecimal(maxLimit);

            responseDTO.setRqUID(rqUID);
            responseDTO.setClientId(clientId);
            responseDTO.setAccount(requestDTO.getAccount());
            responseDTO.setCurrency(currency);
            responseDTO.setBalance(balance);
            responseDTO.setMaxLimit(maxLimit);

            log.error("********** RequestDTO ***********" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestDTO));
            log.error("********** responseDTO ***********" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseDTO));


            return responseDTO;

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    private BigDecimal getRandomBigDecimal(BigDecimal max) {
        double randomDouble = random.nextDouble(); // от 0.0 до 1.0
        return max.multiply(BigDecimal.valueOf(randomDouble)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
