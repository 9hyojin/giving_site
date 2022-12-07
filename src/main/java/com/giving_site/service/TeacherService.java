package com.giving_site.service;


import com.giving_site.dto.TeacherDTO;
import com.giving_site.entity.TeacherEntity;
import com.giving_site.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public void save(TeacherDTO teacherDTO) {

        //1. dto -> entity 변환
        //2. repository의 save메서드 호출(조건: entity객체를 넘겨줘야함)
        TeacherEntity teacherEntity = TeacherEntity.toTeacherEntity(teacherDTO);
        teacherRepository.save(teacherEntity);

    }


    public TeacherDTO login(TeacherDTO teacherDTO){
        //1. 회원이 입력한 아이디를 db에서 조회
        //2. db에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 확인
        Optional<TeacherEntity> byUserId = teacherRepository.findByUserId(teacherDTO.getUserId());
        if(byUserId.isPresent()){
            //조회결과가 있다 (해당 아이디를 가진 회원이 있다)
            TeacherEntity teacherEntity = byUserId.get();
            if(teacherEntity.getUserPassword().equals(teacherDTO.getUserPassword())){
                //비밀번호 일치
                // entity -> dto 로 변환후 controller에 리턴
                TeacherDTO dto = TeacherDTO.toTeacherDTO(teacherEntity);
                return dto;
            }else{
                //비밀번호 불일치
                return null;
            }

        }else{
            //조회결과가 없다 (해당 이메일을 가진 회원이 없다)
            return null;
        }
    }





}    