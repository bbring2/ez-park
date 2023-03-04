package com.bbringworld.ezparkapi.domain.spot.adaptor.in;

import com.bbringworld.ezparkapi.domain.code.Floor;
import com.bbringworld.ezparkapi.domain.spot.dao.entity.Spot;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SpotRegistry (
        @NotNull long adminId,
        @NotBlank String name,
        @NotBlank String floor,
        @NotNull boolean status
) {
    public static Spot toEntity(SpotRegistry registry) {
        return Spot.builder()
                .name(registry.name)
                .floor(Floor.valueOf(registry.floor))
                .status(registry.status)
                .build();
    }
}
