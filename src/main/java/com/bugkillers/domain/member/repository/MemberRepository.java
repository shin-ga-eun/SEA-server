package com.bugkillers.domain.member.repository;

import com.bugkillers.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
    boolean existsByEmail(String email);

}
