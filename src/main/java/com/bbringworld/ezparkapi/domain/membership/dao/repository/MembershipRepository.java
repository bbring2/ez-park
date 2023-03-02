package com.bbringworld.ezparkapi.domain.membership.dao.repository;

import com.bbringworld.ezparkapi.domain.membership.dao.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembershipRepository extends JpaRepository<Membership, Long> {

    boolean existsByMobileAndCarNumberAndStatusTrue(String mobile, String carNumber);

    Optional<Membership> findByMobileAndCarNumber(String mobile, String carNumber);


}
