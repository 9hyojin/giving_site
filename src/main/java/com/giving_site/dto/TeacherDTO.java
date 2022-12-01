package com.giving_site.dto;

import com.giving_site.entity.TeacherEntity;
import lombok.Data;

@Data
public class TeacherDTO {
    private Long userId;
    private String userPassword;
    private String userPassword2;
    private String userName;
    private String userAddress;
    private int userPhoneNumber;
    private String userEMail;
    private int userBirth;


    public static TeacherDTO toTeacherDTO(TeacherEntity teacherEntity){
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setUserId(teacherEntity.getId());
        teacherDTO.setUserPassword(teacherEntity.getUserPassword());
        teacherDTO.setUserPassword2(teacherEntity.getUserPassword2());
        teacherDTO.setUserName(teacherEntity.getUserName());
        teacherDTO.setUserAddress(teacherEntity.getUserAddress());
        teacherDTO.setUserEMail(teacherEntity.getUserEMail());
        teacherDTO.setUserPhoneNumber(teacherEntity.getUserPhoneNumber());
        teacherDTO.setUserBirth(teacherEntity.getUserBirth());
        return teacherDTO;
    }

}
