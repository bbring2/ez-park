package com.bbringworld.ezparkapi.domain.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {

    MALE("male"),
    FEMALE("female"),
    NA("not answer");

    private final String displayName;
}
