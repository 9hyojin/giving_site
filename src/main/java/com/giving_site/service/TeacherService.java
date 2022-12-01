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

    public Long save(TeacherDTO teacherDTO) {
//  DTO를 Entity로 바꿈
//      TeacherEntity teacherEntity = teacherRepository.save(TeacherEntity.toSaveEntity(teacherDTO));
        TeacherEntity teacherEntity = TeacherEntity.toSaveEntity(teacherDTO);
        Long savedId = teacherRepository.save(teacherEntity).getId();
        return savedId;
    }


    public TeacherDTO login(TeacherDTO teacherDTO) {
        /* login.html 에서 이메일, 비번을 받아오고
        db로부터 해당 이메일의 정보를 가져와서
        입력받은 비번과 db에서 조회한 비번의 일치여부를 판단,
        일치하면 로그인 성공, 불일치 로그인실패 처리
         */
        Optional<TeacherEntity> optionalTeacherEntity = teacherRepository.findByUserEMail(teacherDTO.getUserEMail());
        if (optionalTeacherEntity.isPresent()){
            TeacherEntity loginEntity = optionalTeacherEntity.get();
            if (loginEntity.getUserPassword().equals(teacherDTO.getUserPassword())){
                return TeacherDTO.toTeacherDTO((loginEntity));
            }else{
                return null;
            }
        }else {
            return null;
        }
    }
}
