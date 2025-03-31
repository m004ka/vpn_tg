package org.prod.tgbotsvetlyachok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TgBotSvetlyachokApplication {

    public static void main(String[] args) {
        SpringApplication.run(TgBotSvetlyachokApplication.class, args);
    }

}
