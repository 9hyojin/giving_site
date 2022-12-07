package com.giving_site.dto;

import com.giving_site.entity.TeacherEntity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeacherDTO {
    private Long id;
    private String userId;
    private String userPassword;
    private String userPassword2;
    private String userName;
    private String userAddress;
    private Integer userPhoneNumber;
    private String userEmail;



    //entity -> dto변환
    public static TeacherDTO toTeacherDTO(TeacherEntity teacherEntity) {
        TeacherDTO teacherDTO = new TeacherDTO();

        teacherDTO.setId(teacherEntity.getId());
        teacherDTO.setUserId(teacherEntity.getUserId());
        teacherDTO.setUserPassword(teacherEntity.getUserPassword());
        teacherDTO.setUserPassword2(teacherEntity.getUserPassword2());
        teacherDTO.setUserName(teacherEntity.getUserName());
        teacherDTO.setUserAddress(teacherEntity.getUserAddress());
        teacherDTO.setUserPhoneNumber(teacherEntity.getUserPhoneNumber());
        teacherDTO.setUserEmail(teacherEntity.getUserEmail());



        return teacherDTO;
    }

}

