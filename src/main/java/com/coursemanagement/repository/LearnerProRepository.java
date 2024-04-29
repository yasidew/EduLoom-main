package com.coursemanagement.repository;

import com.coursemanagement.entity.LearnerProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LearnerProRepository extends JpaRepository<LearnerProgress, Long> {
    LearnerProgress findByLearnerIdAndContentId(Long learnerId, Long contentId);

    List<LearnerProgress> findByLearnerId(Long learnerId);

}
