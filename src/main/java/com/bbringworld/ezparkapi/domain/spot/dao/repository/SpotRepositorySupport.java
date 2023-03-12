package com.bbringworld.ezparkapi.domain.spot.dao.repository;

import com.bbringworld.ezparkapi.domain.code.Floor;
import com.bbringworld.ezparkapi.domain.spot.dao.entity.Spot;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.bbringworld.ezparkapi.domain.spot.dao.entity.QSpot.spot;

@Repository
@RequiredArgsConstructor
public class SpotRepositorySupport {

    private final JPAQueryFactory queryFactory;

    private final SpotRepository repository;

    public Optional<Spot> findById(long id) {
        return repository.findById(id);
    }

    public Spot getById(long id) {
        return queryFactory
                .selectFrom(spot)
                .where(spot.id.eq(id)
                        .and(spot.status.eq(true)))
                .fetchOne();
    }

    public Spot save(Spot spot) {
        return repository.save(spot);
    }

    public List<Spot> findAllByFloor(String floor) {
        return queryFactory
                .selectFrom(spot)
                .where(spot.floor.eq(Floor.valueOf(floor))
                        .and(spot.status.eq(true)))
                .fetch();
    }

    public List<Spot> findAll() {
        return repository.findAll();
    }

}
