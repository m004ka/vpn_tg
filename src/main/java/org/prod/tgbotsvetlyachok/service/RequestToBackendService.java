package org.prod.tgbotsvetlyachok.service;

import org.prod.tgbotsvetlyachok.dto.PaymentDTO;
import org.prod.tgbotsvetlyachok.model.TelegramUser;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface RequestToBackendService {
    public boolean checkUser(Update update);

    public boolean createUser(Update update);

    public TelegramUser takeUserById(Long id);

    public String getPaymentUrl(PaymentDTO paymentDTO);
}
