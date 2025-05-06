package org.example.infrastructure.adapter.in.rest;

import org.example.infrastructure.adapter.in.rest.dto.OrderRequest;
import org.example.infrastructure.adapter.in.rest.dto.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import se.iths.ports.api.OrderingTopWear;

import java.util.UUID;

import static java.util.UUID.fromString;

@RestController
public class OrderController {

    private final OrderingTopWear orderingTopWear;

    public OrderController(OrderingTopWear orderingTopWear) {
        this.orderingTopWear = orderingTopWear;
    }

    @PostMapping("/orders")
    ResponseEntity<OrderResponse> makeOrder(@RequestBody OrderRequest request, UriComponentsBuilder uriBuilder) {
        var order = orderingTopWear.createOrder(request.toDomain());
        var location = uriBuilder.path("/orders/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(location).body(OrderResponse.fromDomain(order));
    }

    @DeleteMapping("/orders/{id}")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    void cancelOrder(@PathVariable("id") String id){
        orderingTopWear.cancelOrder(fromString(id));
    }


}
