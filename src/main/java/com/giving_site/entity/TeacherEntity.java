package com.giving_site.entity;

import com.giving_site.dto.TeacherDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "talgiv", schema = "talgiv")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50 , unique = true)
    private String userId;

    @Column(length = 20)
    private String userPassword;
    @Column(length = 20)
    private String userPassword2;
    @Column(length = 20)
    private String userName;
    @Column(length = 50)
    private String userAddress;
    @Column(length = 20)
    private int userPhoneNumber;
    @Column(length = 50)
    private String userEMail;
    @Column(length = 20)
    private int userBirth;

    public static TeacherEntity toSaveEntity(TeacherDTO teacherDTO){
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(teacherDTO.getUserId());
        teacherEntity.setUserPassword((teacherDTO.getUserPassword()));
        teacherEntity.setUserPassword2(teacherDTO.getUserPassword2());
        teacherEntity.setUserName(teacherDTO.getUserName());
        teacherEntity.setUserAddress(teacherDTO.getUserAddress());
        teacherEntity.setUserEMail(teacherDTO.getUserEMail());
        teacherEntity.setUserPhoneNumber(teacherDTO.getUserPhoneNumber());
        teacherEntity.setUserBirth(teacherDTO.getUserBirth());

        return teacherEntity;
    }

}
