package com.bbringworld.ezparkapi.domain.spot.application.service;

import com.bbringworld.ezparkapi.domain.admin.application.service.AdminService;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.spot.adaptor.in.SpotRegistry;
import com.bbringworld.ezparkapi.domain.spot.adaptor.in.SpotUpdate;
import com.bbringworld.ezparkapi.domain.spot.adaptor.out.SpotInfo;
import com.bbringworld.ezparkapi.domain.spot.application.provider.SpotProvider;
import com.bbringworld.ezparkapi.domain.spot.dao.entity.Spot;
import com.bbringworld.ezparkapi.domain.spot.dao.repository.SpotRepository;
import com.bbringworld.ezparkapi.domain.spot.exception.SpotNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpotService implements SpotProvider {

    private final SpotRepository repository;

    private final AdminService adminService;

    public Spot getById(Long id) {
        return repository.findById(id)
                .orElseThrow(SpotNotFoundException::new);
    }

    public Spot save(Spot spot) {
        return repository.save(spot);
    }

    @Override
    public void create(Spot spot) {
        checkDuplication(spot);
        save(spot);
    }

    public void register(SpotRegistry registry) {
        Admin admin = adminService.getById(registry.adminId());

        Spot spot = SpotRegistry.toEntity(registry);

        create(spot);
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update() {

    }

    public SpotInfo update(long id, SpotUpdate update) {
        return null;
    }

    @Override
    public List<SpotInfo> fetch() {
        return null;
    }

    @Override
    public SpotInfo search(long id) {
        return null;
    }

    @Override
    public SpotInfo update(Spot spot) {
        return null;
    }

    public void checkDuplication(Spot spot) {

    }

    public SpotInfo use(Long id) {
        return null;
    }

}
