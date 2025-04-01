package org.prod.tgbotsvetlyachok.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDTO {

    private Long telegramUserId;

    private String username;

    private String mail;

    private Double value;

    private Boolean receipt;

    private String order_id;

}