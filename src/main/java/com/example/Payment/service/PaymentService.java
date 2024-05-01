package com.example.Payment.service;

import com.example.Payment.entity.Completed_Payments;
import com.example.Payment.entity.CourseInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface PaymentService {

    Map<Long, CourseInfo> getLearnerCourses(Long learnerId);
    void saveLearnerCourses(Long learnerId, Map<Long, CourseInfo> courses);

}
