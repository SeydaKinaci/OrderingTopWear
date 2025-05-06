package org.example.infrastructure.adapter.in.rest.dto;

import se.iths.LineItem;

public record LineItemRequest(TopWearRequest topWear, int quantity) {
    public LineItem toDomain() {
        return new LineItem(topWear.toDomain(), quantity);
    }

    public static LineItemRequest fromDomain(LineItem lineItem) {
        return new LineItemRequest(
                TopWearRequest.fromDomain(lineItem.topWear()),
                lineItem.quantity()
        );
    }
}
