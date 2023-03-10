package com.bbringworld.ezparkapi.domain.admin.application.service;

import com.bbringworld.ezparkapi.domain.admin.adaptor.in.AdminUpdate;
import com.bbringworld.ezparkapi.domain.admin.adaptor.out.AdminInfo;
import com.bbringworld.ezparkapi.domain.admin.application.provider.AdminProvider;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.admin.dao.repository.AdminRepository;
import com.bbringworld.ezparkapi.domain.admin.dao.repository.AdminRepositorySupport;
import com.bbringworld.ezparkapi.domain.admin.exception.AdminNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService implements AdminProvider {

    private final AdminRepository repository;
    private final AdminRepositorySupport repositorySupport;

    @Override
    public boolean existAdminByNickname(String nickname) {
        return repository.existsByNickname(nickname);
    }

    public Optional<Admin> findById(long id) {
        return repositorySupport.findById(id);
    }

    @Override
    public Admin getById(long id) {
        return findById(id)
                .orElseThrow(AdminNotFoundException::new);
    }

    @Override
    public boolean existAdminByMobile(String mobile, boolean verified) {
        return false;
    }

    @Override
    public void updateAdminProfile(long id, AdminUpdate update) {
    }

    public Admin save(Admin admin) {
        return repository.save(admin);
    }

    public Optional<Admin> findByNickname(String nickname) {
        return repositorySupport.findAdminByNickName(nickname);
    }

    public List<AdminInfo> of(List<Admin> adminEntityList) {
        return adminEntityList
                .stream()
                .map(AdminInfo::of)
                .collect(Collectors.toList());
    }
}
