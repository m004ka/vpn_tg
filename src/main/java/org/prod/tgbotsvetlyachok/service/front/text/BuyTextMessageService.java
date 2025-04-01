package org.prod.tgbotsvetlyachok.service.front.text;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prod.tgbotsvetlyachok.enums.Period;
import org.prod.tgbotsvetlyachok.client.BackendClient;
import org.prod.tgbotsvetlyachok.dto.CreatePaymentDTO;
import org.prod.tgbotsvetlyachok.dto.PaymentDTO;
import org.prod.tgbotsvetlyachok.model.PaymentResponse;
import org.prod.tgbotsvetlyachok.service.front.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class BuyTextMessageService {
    private final BackendClient backendClient;
    private final MessageService messageService;

    @Value("${payment.defaultMail}")
    String defaultMail;


    public String priceMessageText(Long id){
        List<Long> time = backendClient.getTime(id);
        return "У тебя осталось <b>" + time.get(0) + " дней " + "доступа </b>\n\n" + "<b>Продли дни доступа выгодно</b>\uD83D\uDC47";
    }

    public String startBuyMessageText(){
        return "Нужен ли вам чек?";
    }

    public String getMailMessageText(){
        return "Напиши правильно свой email и отправь.\n" +
                "Чек вышлем после оплаты.\n" +
                "\n" +
                "Внимание, мы гарантируем получение чека только в случае, если ты корректно отправил свой email!";
    }

    public String paymentMessageText(Update update, Period period, Boolean check, String mail){
        Long id = messageService.getChatId(update);
        if(!check){
            mail = defaultMail;
        }

        CreatePaymentDTO paymentDTO = CreatePaymentDTO.builder()
                .id(id)
                .mail(mail)
                .receipt(check)
                .value(period.getMoney())
                .order_id(UUID.randomUUID().toString())
                .build();

        log.error("Дто платежки:  " + paymentDTO);
        PaymentResponse paymentResponse = backendClient.createPayment(paymentDTO);
        if(paymentResponse.getConfirmation().getConfirmation_url() == null){
            return "Что-то пошло не так, попробуйте запросить ссылку на оплату заново \uD83D\uDE41";
        }else{
            return "Оплачивая счет, вы соглашаетесь c условиями подписки (https://maviks.store/oferta/oferta.docx)\n" +
                    "\n" +
                    "<b>Ссылка на оплату:</b>\n" + paymentResponse.getConfirmation().getConfirmation_url();
        }

    }

    public String successfulPaymentText(PaymentDTO paymentDTO){
        return "Заказ на сумму: " + paymentDTO.getValue() + " был успешно оплачен" + "\n Ваша подписка продлена";
    }
}
