package org.prod.tgbotsvetlyachok.controller;

import lombok.RequiredArgsConstructor;
import org.prod.tgbotsvetlyachok.dto.PaymentDTO;
import org.prod.tgbotsvetlyachok.service.front.messages.BuyMessages;
import org.prod.tgbotsvetlyachok.service.front.text.BuyTextMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/telegram")
@RequiredArgsConstructor
public class BackendController {
    private final BuyMessages buyMessages;

    @PostMapping("/updatePayment")
    public HttpStatus updatePayment(@RequestBody PaymentDTO paymentDTO){
        buyMessages.successfulPaymentMessage(paymentDTO);
        return HttpStatus.OK;
    }
}
