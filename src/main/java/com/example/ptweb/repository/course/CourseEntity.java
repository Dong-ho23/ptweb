package com.example.ptweb.repository.course;// package는 reserved word로 사용할 수 없어서 pack을 사용합니다.

import com.example.ptweb.repository.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "course")
public class CourseEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 DB에 위임합니다. (AUTO_INCREMENT)
    private Integer courseSeq;

    private String courseName;
    private Integer count;
    private Integer period;

}