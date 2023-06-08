package com.example.ptweb.service.pass;

import com.example.ptweb.controller.admin.BulkPassRequest;
import com.example.ptweb.repository.course.CourseEntity;
import com.example.ptweb.repository.course.CourseRepository;
import com.example.ptweb.repository.pass.BulkPassEntity;
import com.example.ptweb.repository.pass.BulkPassRepository;
import com.example.ptweb.repository.pass.BulkPassStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulkPassService {
    private final BulkPassRepository bulkPassRepository;

    private final CourseRepository courseRepository;

    public BulkPassService(BulkPassRepository bulkPassRepository, CourseRepository courseRepository) {
        this.bulkPassRepository = bulkPassRepository;
        this.courseRepository = courseRepository;
    }

    public List<BulkPass> getAllBulkPasses() {
        List<BulkPassEntity> bulkPassEntities = bulkPassRepository.findAllOrderByStartedAtDesc();
        return BulkPassModelMapper.INSTANCE.map(bulkPassEntities);
    }

    public void addBulkPass(BulkPassRequest bulkPassRequest) {
        CourseEntity courseEntity = courseRepository.findById(bulkPassRequest.getCourseSeq()).orElseThrow();

        BulkPassEntity bulkPassEntity = BulkPassModelMapper.INSTANCE.map(bulkPassRequest);
        bulkPassEntity.setStatus(BulkPassStatus.READY);
        bulkPassEntity.setCount(courseEntity.getCount());
        bulkPassEntity.setEndedAt(courseEntity.getPeriod());

        bulkPassRepository.save(bulkPassEntity);
    }

}