package org.prod.tgbotsvetlyachok.service;

import lombok.RequiredArgsConstructor;
import org.prod.tgbotsvetlyachok.dto.PaymentDTO;
import org.prod.tgbotsvetlyachok.model.TelegramUser;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class RequestToBackendServiceImpl implements RequestToBackendService{


    @Override
    public boolean checkUser(Update update) {
        return false;
    }

    @Override
    public boolean createUser(Update update) {
        return false;
    }

    @Override
    public TelegramUser takeUserById(Long id) {
        return new  TelegramUser();
    }

    @Override
    public String getPaymentUrl(PaymentDTO paymentDTO) {
        return null;
    }


}
