package com.bbringworld.ezparkapi.domain.spot.application.service;

import com.bbringworld.ezparkapi.domain.spot.application.provider.SpotProvider;
import com.bbringworld.ezparkapi.domain.spot.dao.entity.Spot;
import com.bbringworld.ezparkapi.domain.spot.dao.repository.SpotRepository;
import com.bbringworld.ezparkapi.domain.spot.exception.SpotNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpotService implements SpotProvider {

    private final SpotRepository repository;

    public Spot getById(Long id) {
        return repository.findById(id)
                .orElseThrow(SpotNotFoundException::new);
    }

    public Spot save(Spot spot) {
        return repository.save(spot);
    }

    @Override
    public void create(String name) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update() {

    }

}
