package com.bbringworld.ezparkapi.domain.spot.application.service;

import com.bbringworld.ezparkapi.domain.admin.application.service.AdminService;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.spot.adaptor.in.SpotRegistry;
import com.bbringworld.ezparkapi.domain.spot.adaptor.in.SpotUpdate;
import com.bbringworld.ezparkapi.domain.spot.adaptor.out.SpotInfo;
import com.bbringworld.ezparkapi.domain.spot.application.provider.SpotProvider;
import com.bbringworld.ezparkapi.domain.spot.dao.entity.Spot;
import com.bbringworld.ezparkapi.domain.spot.dao.repository.SpotRepositorySupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpotService implements SpotProvider {

    private final SpotRepositorySupport repositorySupport;

    private final AdminService adminService;

    @Override
    public void create(Spot spot) {
        checkDuplication(spot);
        repositorySupport.save(spot);
    }

    public void register(SpotRegistry registry) {
        Admin admin = adminService.getById(registry.adminId());

        Spot spot = SpotRegistry.toEntity(registry);

        create(spot);
    }

    @Override
    public void delete(long id) {
        Spot spot = repositorySupport.getById(id);

        spot.unavailable();

        repositorySupport.save(spot);
    }

    @Override
    public void update() {

    }

    public SpotInfo update(long id, SpotUpdate update) {
        return null;
    }

    public List<SpotInfo> fetch() {
        return repositorySupport.findAll()
                .stream()
                .map(SpotInfo::of)
                .collect(Collectors.toList());
    }

    public List<SpotInfo> fetchByFloor(String floor) {
        return repositorySupport.findAllByFloor(floor)
                .stream()
                .map(SpotInfo::of)
                .collect(Collectors.toList());
    }

    @Override
    public SpotInfo search(long id) {
        return SpotInfo.of(repositorySupport.getById(id));
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
