package com.giving_site.repository;


import com.giving_site.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<TeacherEntity,Long> {
    // 이메일로 회원정보 조회 (=쿼리: select*from member(table이름) where member_email=?)
    Optional<TeacherEntity> findByUserId(String userId);
}