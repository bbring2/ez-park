package com.bbringworld.ezparkapi.domain.admin.dao.repository;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.QAdmin;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.bbringworld.ezparkapi.domain.admin.dao.entity.QAdmin.admin;

@Repository
public class AdminRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    private final AdminRepository repository;

    public AdminRepositorySupport(JPAQueryFactory queryFactory, AdminRepository repository) {
        super(Admin.class);
        this.queryFactory = queryFactory;
        this.repository = repository;
    }

    public Optional<Admin> findAdminByNickName(String nickname) {
        return repository.findByNickname(nickname);
    }

    public Optional<Admin> findById(long id) {
        return repository.findById(id);
    }

    public boolean existsByNicknameAndStatusFalse(String nickname) {
        int size = queryFactory.selectFrom(admin)
                .where(admin.nickname.eq(nickname).and(admin.status.eq(true)))
                .fetch()
                .size();

        return size > 0;
    }
}
