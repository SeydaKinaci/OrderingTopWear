package org.example.infrastructure.adapter.out.persistence;

import org.example.infrastructure.adapter.out.persistence.entity.OrderEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import se.iths.Order;
import se.iths.exceptions.OrderNotFound;
import se.iths.ports.spi.Orders;

import java.util.UUID;

@Component
public class OrdersJDBCAdapter implements Orders {

    private final OrderRepository orderRepository;

    public OrdersJDBCAdapter(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findOrderById(UUID orderId) throws OrderNotFound {
        var order = orderRepository.findByUuid(orderId);
        if (order == null) {
            throw new OrderNotFound();
        }
        return order.toDomain();
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(OrderEntity.fromDomain(order)).toDomain();
    }

    @Override
    public void deleteById(UUID orderId) {
        var order = orderRepository.findByUuid(orderId);
        orderRepository.deleteById(order.getId());
    }
}
