package se.iths;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id = UUID.randomUUID();
    private final List<LineItem> items;
    private final Location location;
    private LocalDateTime orderDate = LocalDateTime.now();
    private OrderStatus status = OrderStatus.PAYMENT_EXPECTED;

    public Order(List<LineItem> items, Location location) {
        this.items = items;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public UUID getId() {
        return id;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getCost() {
        return items.stream()
                .map(LineItem::getCost)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public boolean isPaid() {
        return status != OrderStatus.PAYMENT_EXPECTED;
    }


}
