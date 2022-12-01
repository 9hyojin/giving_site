package com.giving_site.repository;

import com.giving_site.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<TeacherEntity,Long> {
    // select * from talgiv where userEMail = ?  -> db 테이블에서 email 가져오기
    // 보통 pk를 가져오는데 email은 pk가 아님. 사용목적에 따라 추가
    //리턴타입: teacherEntity        method 만들기, abstract 추상메소드
    //매개변수: userEMail(String)

    Optional<TeacherEntity> findByUserEMail(String userEMail);



}
