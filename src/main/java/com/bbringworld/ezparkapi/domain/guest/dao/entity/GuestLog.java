package com.bbringworld.ezparkapi.domain.guest.dao.entity;

import com.bbringworld.ezparkapi.domain.code.Status;
import com.bbringworld.ezparkapi.domain.spot.dao.entity.Spot;
import com.bbringworld.ezparkapi.global.domain.dao.Registration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@AllArgsConstructor
@Table(name = "guest_log")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GuestLog extends Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spot_id")
    private Spot spot;

    @Column
    private String status;


}
