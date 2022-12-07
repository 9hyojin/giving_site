package com.giving_site.entity;


import com.giving_site.dto.TeacherDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="teacher")
public class TeacherEntity {
    @Id //pk지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment 지정
    private Long id;

    @Column
    private String userId;

    @Column
    private String userPassword;

    @Column
    private String userPassword2;

    @Column
    private String userName;

    @Column
    private String userAddress;

    @Column
    private Integer userPhoneNumber;

    @Column
    private String userEmail;




    //dto -> entity 변환
    public  static TeacherEntity toTeacherEntity(TeacherDTO teacherDTO){
        TeacherEntity teacherEntity = new TeacherEntity();

        teacherEntity.setId(teacherDTO.getId());
        teacherEntity.setUserId(teacherDTO.getUserId());
        teacherEntity.setUserPassword(teacherDTO.getUserPassword());
        teacherEntity.setUserPassword2(teacherDTO.getUserPassword2());
        teacherEntity.setUserName(teacherDTO.getUserName());
        teacherEntity.setUserAddress(teacherDTO.getUserAddress());
        teacherEntity.setUserPhoneNumber(teacherDTO.getUserPhoneNumber());
        teacherEntity.setUserEmail(teacherDTO.getUserEmail());


        return teacherEntity;
    }


}
