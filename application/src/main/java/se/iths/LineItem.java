package se.iths;

import java.math.BigDecimal;

public record LineItem(TopWear topWear, int quantity) {

    public BigDecimal getCost() {
        return priceFor(topWear).multiply(BigDecimal.valueOf(quantity));
    }

    private BigDecimal priceFor(TopWear topWear) {
        return switch (topWear.size()) {
            case SMALL -> BigDecimal.valueOf(99.90);
            case MEDIUM -> BigDecimal.valueOf(109.90);
            case LARGE -> BigDecimal.valueOf(119.90);
        };
    }
}