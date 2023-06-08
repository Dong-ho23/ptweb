package com.example.ptweb.service.course;


import com.example.ptweb.repository.course.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseModelMapper {
    CourseModelMapper INSTANCE = Mappers.getMapper(CourseModelMapper.class);

    List<Course> map(List<CourseEntity> courseEntities);

}