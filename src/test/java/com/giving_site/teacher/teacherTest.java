package com.giving_site.teacher;

import com.giving_site.dto.TeacherDTO;
import com.giving_site.service.TeacherService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
public class teacherTest {
    @Autowired
    private TeacherService teacherService;

    public TeacherDTO newTeacher(){
        TeacherDTO teacher = new TeacherDTO("테스트용비밀번호","테스트용비밀번호2","테스트용이름","테스트용주소",0000,"테스트용이메일",1205);
        return teacher;
    }

    @Test
    @Transactional
    @Rollback(value = true)
    @DisplayName("선생님 회원가입 테스트")
    public void teacherSaveTest(){
        Long saveId = teacherService.save(newTeacher());
    }
}
