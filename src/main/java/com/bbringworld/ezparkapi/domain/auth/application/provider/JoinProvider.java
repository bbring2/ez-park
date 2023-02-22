package com.bbringworld.ezparkapi.domain.auth.application.provider;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;

import java.util.Optional;

public interface JoinProvider {

    public void registerAdmin(Admin admin);

    public Optional<Admin> findAdminByNickname(String nickname);

    public Optional<Admin> findAdminById(long id);

}
