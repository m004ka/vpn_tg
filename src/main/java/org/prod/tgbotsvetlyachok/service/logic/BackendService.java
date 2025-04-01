package org.prod.tgbotsvetlyachok.service.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prod.tgbotsvetlyachok.client.BackendClient;
import org.prod.tgbotsvetlyachok.dto.CreatePaymentDTO;
import org.prod.tgbotsvetlyachok.dto.TelegramUserDTO;
import org.prod.tgbotsvetlyachok.model.PaymentResponse;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BackendService {
    private final BackendClient backendClient;

    public TelegramUserDTO getUser(Long id){
        log.info("В бэкенд сервайс делаем запрос");

        TelegramUserDTO telegramUserDTO =  backendClient.getUser(id);
        return telegramUserDTO;
    }

    public TelegramUserDTO createUser(TelegramUserDTO telegramUserDTO){
        return  backendClient.createUser(telegramUserDTO);
    }

    public PaymentResponse createPayment(CreatePaymentDTO createPaymentDTO){
        return backendClient.createPayment(createPaymentDTO);
    }

    public List<Long> getTime(Long id){
        return backendClient.getTime(id);
    }

    public void get(){
        backendClient.get();
    }
}
