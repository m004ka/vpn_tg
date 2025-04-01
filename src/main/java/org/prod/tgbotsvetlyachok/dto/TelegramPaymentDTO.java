package org.prod.tgbotsvetlyachok.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.prod.tgbotsvetlyachok.enums.Period;
@Data
@AllArgsConstructor
public class TelegramPaymentDTO {
    Period period;

    Boolean check;
}
