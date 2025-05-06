package se.iths.ports.spi.stub;

import se.iths.Order;
import se.iths.Stub;
import se.iths.exceptions.OrderNotFound;
import se.iths.ports.spi.Orders;

import java.util.HashMap;
import java.util.UUID;

@Stub
public class InMemoryOrders implements Orders {
    HashMap<UUID, Order> orders = new HashMap<>();

    @Override
    public Order findOrderById(UUID orderId) throws OrderNotFound {
        if(!orders.containsKey(orderId))
            throw new OrderNotFound();
        return orders.get(orderId);
    }

    @Override
    public Order save(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public void deleteById(UUID orderId) {
        orders.remove(orderId);
    }
}
