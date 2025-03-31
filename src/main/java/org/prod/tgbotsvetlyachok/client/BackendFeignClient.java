package org.prod.tgbotsvetlyachok.client;

import org.prod.tgbotsvetlyachok.config.FeignConfig;
import org.prod.tgbotsvetlyachok.dto.CreatePaymentDTO;
import org.prod.tgbotsvetlyachok.dto.TelegramUserDTO;
import org.prod.tgbotsvetlyachok.model.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "backendClient", url = "${backend.host}", configuration = FeignConfig.class)
public interface BackendFeignClient {

    @GetMapping("/api/telegram/getUserById")
    TelegramUserDTO getUser(@RequestParam Long id);  // <-- убираем ResponseEntity

    @PostMapping("/api/telegram/create")
    TelegramUserDTO createUser(@RequestBody TelegramUserDTO telegramUserDTO);

    @PostMapping("/api/telegram/payment/create")
    public PaymentResponse createPayment(@RequestBody CreatePaymentDTO createPaymentDTO);

    @GetMapping("/api/telegram/getTime")
    public List<Long> getTime(@RequestParam Long id);

    @GetMapping("/api/telegram/get")
    public HttpStatus get();
}
