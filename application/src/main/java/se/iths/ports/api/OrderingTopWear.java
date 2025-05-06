package se.iths.ports.api;

import se.iths.Order;

import java.util.UUID;

public interface OrderingTopWear {
    Order createOrder(Order order);

    void cancelOrder(UUID id);

}

