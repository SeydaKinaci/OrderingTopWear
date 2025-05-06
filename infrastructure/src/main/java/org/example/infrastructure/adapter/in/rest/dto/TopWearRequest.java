package org.example.infrastructure.adapter.in.rest.dto;

import se.iths.TopWear;
import se.iths.SleeveType;
import se.iths.Color;
import se.iths.Size;

public record TopWearRequest(SleeveType sleeveType, Color color, Size size) {

    public TopWear toDomain() {
        return new TopWear(sleeveType, color, size);
    }

    public static TopWearRequest fromDomain(TopWear topWear) {
        return new TopWearRequest(
                topWear.sleeveType(),
                topWear.color(),
                topWear.size()
        );
    }
}

