package com.example.ptweb.service.course;


import com.example.ptweb.repository.course.CourseEntity;
import com.example.ptweb.repository.course.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        List<CourseEntity> bulkPassEntities = courseRepository.findAllByOrderByCourseName();
        return CourseModelMapper.INSTANCE.map(bulkPassEntities);
    }
}