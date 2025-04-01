package org.prod.tgbotsvetlyachok.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.prod.tgbotsvetlyachok.dto.CreatePaymentDTO;
import org.prod.tgbotsvetlyachok.dto.TelegramUserDTO;
import org.prod.tgbotsvetlyachok.model.PaymentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BackendClient {

    private final BackendFeignClient backendFeignClient;

    public TelegramUserDTO getUser(Long id) {
        log.info("Запрос с бэк-клиента юзера с ID {}", id);
        try {
            TelegramUserDTO user = backendFeignClient.getUser(id); // Теперь Feign сам парсит объект
            log.info("Получен пользователь: {}", user);
            return user;
        } catch (Exception e) {
            log.error("Ошибка при запросе пользователя с ID {}: {}", id, e.getMessage());
            return TelegramUserDTO.builder().build();
        }
    }



    public TelegramUserDTO createUser(TelegramUserDTO userDTO) {
        System.out.println(userDTO);
        log.info("Создание нового пользователя");
        try {
            TelegramUserDTO user = backendFeignClient.createUser(userDTO);
            return user;

//            if (.getStatusCode().is2xxSuccessful()) {
//                return response.getBody();
//            } else {
//                throw new RuntimeException("Ошибка при получении пользователя: " + response.getStatusCode());
//            }
        } catch (Exception e) {
            log.error("Ошибка при создании пользователя: {}", e.getMessage());
            throw new RuntimeException("Ошибка при создании пользователя");
        }
    }

    public PaymentResponse createPayment(CreatePaymentDTO createPaymentDTO) {
        log.info("Создание платежа");
        try {
            PaymentResponse response = backendFeignClient.createPayment(createPaymentDTO);

//            if (response.getStatusCode().is2xxSuccessful()) {
//                return response.getBody();
//            } else {
//                throw new RuntimeException("Ошибка при получении платежных данных: " + response.getStatusCode());
//            }
            return response;
        } catch (Exception e) {
            log.error("Ошибка при создании запроса: {}", e.getMessage());
            throw new RuntimeException("Ошибка при создании запроса");
        }
    }

    public List<Long> getTime(Long id) {
        log.info("Получение времени истечения подписки для пользователя с ID {}", id);
        try {
            List<Long> response = backendFeignClient.getTime(id);
            return response;

//            if (response.getStatusCode().is2xxSuccessful()) {
//                return response.getBody();
//            } else {
//                throw new RuntimeException("Ошибка при получении времени истечения подписки: " + response.getStatusCode());
//            }
        } catch (Exception e) {
            log.error("Ошибка при запросе времени истечения подписки: {}", e.getMessage());
            throw new RuntimeException("Ошибка при запросе времени истечения подписки");
        }
    }

    public HttpStatus get(){
        System.out.println(backendFeignClient.get());
        return backendFeignClient.get();
    }
}
