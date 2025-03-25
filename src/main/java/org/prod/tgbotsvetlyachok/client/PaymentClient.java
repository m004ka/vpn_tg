package org.prod.tgbotsvetlyachok.client;

import org.prod.tgbotsvetlyachok.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PaymentClient {
    @Value("${payment.host}")
    private String baseUrl;

    private final WebClient webClient = WebClient.create(baseUrl);

    public Mono<String> createPayment(PaymentDTO paymentDTO){
        return webClient.post()
                .uri("/createPayment")
                .bodyValue(paymentDTO)
                .retrieve()
                .bodyToMono(String.class);
    }



}
