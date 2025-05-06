package org.example.infrastructure.adapter.in.rest.dto;

import se.iths.Location;
import se.iths.Order;

import java.util.List;
import java.util.UUID;

public record OrderRequest(Location location, List<LineItemRequest> items) {

    public Order toDomain(){
        return new Order(items.stream().map(LineItemRequest::toDomain).toList(), location);
    }

}
