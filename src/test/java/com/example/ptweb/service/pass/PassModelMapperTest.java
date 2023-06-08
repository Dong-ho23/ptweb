package com.example.ptweb.service.pass;

import com.example.ptweb.repository.course.CourseEntity;
import com.example.ptweb.repository.pass.PassEntity;
import com.example.ptweb.repository.pass.PassStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassModelMapperTest {
    @Test
    public void test_toPasses() {
        // when
        final LocalDateTime now = LocalDateTime.now();

        final CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseSeq(1);
        courseEntity.setCourseName("패키지1");
        courseEntity.setCount(10);
        courseEntity.setPeriod(30);

        final PassEntity passEntity = new PassEntity();
        passEntity.setPassSeq(1);
        passEntity.setStatus(PassStatus.READY);
        passEntity.setRemainingCount(10);
        passEntity.setStartedAt(now.plusDays(1));
        passEntity.setEndedAt(passEntity.getStartedAt().plusDays(30));
        passEntity.setCourseSeq(1);
        passEntity.setCourseEntity(courseEntity);

        // given
        final List<Pass> passes = PassModelMapper.INSTANCE.map(List.of(passEntity));

        // then
        assertEquals(1, passes.size());
        final Pass pass = passes.get(0);

    }

}