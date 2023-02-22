package com.bbringworld.ezparkapi.domain.spot.dao.entity;

import com.bbringworld.ezparkapi.global.domain.dao.Registration;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "spot")
public class Spot extends Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean status;

}
