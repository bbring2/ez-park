package com.bbringworld.ezparkapi.domain.spot.adaptor.out;

import com.bbringworld.ezparkapi.domain.spot.dao.entity.Spot;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SpotInfo (
        long id,
        String name,
        String floor,
        boolean status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static SpotInfo of(Spot spot) {
        return SpotInfo.builder()
                .id(spot.getId())
                .name(spot.getName())
                .floor(spot.getFloor())
                .status(spot.isStatus())
                .createdAt(spot.getCreatedAt())
                .updatedAt(spot.getUpdatedAt())
                .build();
    }
}
