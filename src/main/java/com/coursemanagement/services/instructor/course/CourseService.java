package com.coursemanagement.services.instructor.course;

import com.coursemanagement.dto.ContentDto;
import com.coursemanagement.dto.CourseDto;
import com.coursemanagement.entity.Content;
import com.coursemanagement.entity.Course;

import java.io.IOException;
import java.util.List;

public interface CourseService {

    Course createcourse(CourseDto categoryDto);
    List<Course> getAllCourses();

    List<ContentDto> getAllContentsByCourseId(Long courseId);

    Course getOneCourse(Long courseId);

    Course updateCourse(CourseDto courseDto, Long courseId);

    void deleteCourse(Long courseId);
}
