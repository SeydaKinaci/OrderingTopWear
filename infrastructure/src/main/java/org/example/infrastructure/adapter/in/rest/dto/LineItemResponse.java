package org.example.infrastructure.adapter.in.rest.dto;

import se.iths.LineItem;

public record LineItemResponse(TopWearResponse topWear, int quantity) {
    public static LineItemResponse fromDomain(LineItem lineItem) {
        return new LineItemResponse(
                TopWearResponse.fromDomain(lineItem.topWear()),
                lineItem.quantity());
    }
}
