package org.prod.tgbotsvetlyachok.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePaymentDTO {

    private Long id;

    private  String mail;

    private Boolean receipt;

    private Double value;

    private String order_id;
}