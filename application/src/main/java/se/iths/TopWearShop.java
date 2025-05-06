package se.iths;

import se.iths.ports.api.OrderingTopWear;
import se.iths.ports.spi.Orders;

import java.util.UUID;

@UseCase
public class TopWearShop implements OrderingTopWear {

    private final Orders orders;

     public TopWearShop(Orders orders) {
        this.orders = orders;
    }

    @Override
    public Order createOrder(Order order) {
            return orders.save(order);
    }

    @Override
    public void cancelOrder(UUID id) {
        var order = orders.findOrderById(id);

        if(order.isPaid()){
            throw new IllegalStateException("Can't cancel paid order");
        }
        orders.deleteById(id);
    }


}

