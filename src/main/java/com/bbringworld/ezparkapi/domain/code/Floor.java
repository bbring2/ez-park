package com.bbringworld.ezparkapi.domain.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Floor {

    BASEMENT("basement", -1),
    FIRST_FLOOR("1st floor", 1),
    SECOND_FLOOR("2nd floor", 2),
    THIRD_FLOOD("3rd floor", 3);

    private final String displayName;

    private final Integer floor;

}
