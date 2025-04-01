package org.prod.tgbotsvetlyachok.bot;

import lombok.Getter;

@Getter
public enum Period {
    MONTH(1, 199, "months"),
    THREE_MONTH(3, 499, "three_months"),
    SIX_MONTH(6, 799, "six_months"),
    YEAR(12, 1499, "year" );

    private final int months;
    private final double money;
    private final String text;

        Period(int months, double money, String text){
            this.months = months;
            this.money = money;
            this.text = text;

        }

        public static Period getPeriodByString(String per){
            return switch (per) {
                case "months" -> MONTH;
                case "three_months" -> THREE_MONTH;
                case "six_months" -> SIX_MONTH;
                case "year" -> YEAR;
                default -> throw new IllegalStateException("Unexpected value: " + per);
            };
        }
}
