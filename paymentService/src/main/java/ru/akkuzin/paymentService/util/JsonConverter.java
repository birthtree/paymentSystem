package ru.akkuzin.paymentService.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.akkuzin.paymentService.model.dto.CreatePaymentTransactionRequest;
import ru.akkuzin.paymentService.service.handler.CreatePaymentTransactionCommandHandler;

@Component
@Slf4j
@RequiredArgsConstructor
public class JsonConverter {
    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T toObject(String json, Class<T> clazz) {

       try {
           return mapper.readValue(json, clazz);
       }
        catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public String toJson(Object obj) {
        try{
            return mapper.writeValueAsString(obj);
        }
        catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
