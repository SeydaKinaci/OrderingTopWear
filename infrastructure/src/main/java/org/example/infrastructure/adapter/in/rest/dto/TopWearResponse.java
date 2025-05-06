package org.example.infrastructure.adapter.in.rest.dto;

import se.iths.Color;
import se.iths.Size;
import se.iths.SleeveType;
import se.iths.TopWear;

public record TopWearResponse(SleeveType sleeveType, Color color, Size size) {
    public static TopWearResponse fromDomain(TopWear topWear) {
        return new TopWearResponse(
                topWear.sleeveType(),
                topWear.color(),
                topWear.size()
        );
    }

    public TopWear toDomain() {
        return new TopWear(sleeveType, color, size);
    }
}

