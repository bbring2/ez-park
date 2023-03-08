package com.bbringworld.ezparkapi.domain.admin.application.provider;

import com.bbringworld.ezparkapi.domain.admin.adaptor.in.AdminUpdate;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminProvider {

    boolean existAdminByNickname(String nickname);

    Optional<Admin> findById(String nickname);

    Admin getById(long id);

    boolean existAdminByMobile(String mobile, boolean verified);

    void updateAdminProfile(long id, AdminUpdate update);

}
