package com.bbringworld.ezparkapi.domain.admin.dao.repository;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByNickname(String nickname);

    List<Admin> findAllByStatusTrue();

}
