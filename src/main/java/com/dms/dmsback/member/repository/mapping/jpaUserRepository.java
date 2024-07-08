package com.dms.dmsback.member.repository.mapping;

import com.dms.dmsback.member.entity.pk.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface jpaUserRepository extends JpaRepository<User, String> {
}
