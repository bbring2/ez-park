package com.bbringworld.ezparkapi.domain.admin.application.provider;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.admin.dao.repository.AdminRepository;
import com.bbringworld.ezparkapi.domain.admin.exception.AdminNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdminProvider {

    private final AdminRepository repository;

    @Autowired
    public AdminProvider(AdminRepository repository) {
        this.repository = repository;
    }

    public Optional<Admin> findOne(String nickname) {
        return repository.findByNickname(nickname);
    }

    public Optional<Admin> findById(Long id) {
        return repository.findById(id);
    }

    public Admin getById(Long id) {
        return findById(id).orElseThrow(AdminNotFoundException::new);
    }

}
