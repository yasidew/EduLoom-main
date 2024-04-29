package com.coursemanagement.dto;

import lombok.Data;

@Data
public class LearnerProgressDto {

    private Long learnerId;
    private Long contentId;
    private Long courseId;
}
