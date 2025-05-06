package se.iths;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.iths.exceptions.OrderNotFound;
import se.iths.ports.api.OrderingTopWear;
import se.iths.ports.spi.Orders;
import se.iths.ports.spi.stub.InMemoryOrders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderingTopWearTest {

    @Test
    @DisplayName("Place TopWear Order")
    void placeTopWearOrder() {
        //Given
        Orders orders = new InMemoryOrders();
        OrderingTopWear orderingTopWear = new TopWearShop(orders);
        //When
        TopWear topWear = new TopWear(SleeveType.HALF, Color.RED, Size.SMALL);
        LineItem lineItem = new LineItem(topWear, 2);
        Order order = new Order(List.of(lineItem), Location.DELIVERY);

        Order orderResponse = orderingTopWear.createOrder(order);
        //Then
        assertThat(orderResponse).isNotNull();
        assertThat(orderResponse.getItems()).hasSize(1);
        assertThat(orderResponse.getLocation()).isEqualTo(Location.DELIVERY);
    }

    @Test
    @DisplayName("Custom can cancel order before paying")
    void customCanCancelOrderBeforePaying() {
        //Given
        Orders orders = new InMemoryOrders();
        OrderingTopWear orderingTopWear = new TopWearShop(orders);
        //When
        TopWear topWear = new TopWear(SleeveType.HALF, Color.RED, Size.SMALL);
        LineItem lineItem = new LineItem(topWear, 2);
        Order order = new Order(List.of(lineItem), Location.DELIVERY);

        orderingTopWear.cancelOrder(order.getId());
        assertThatThrownBy(()-> orders.findOrderById(order.getId())).isInstanceOf(OrderNotFound.class);


    }
}
