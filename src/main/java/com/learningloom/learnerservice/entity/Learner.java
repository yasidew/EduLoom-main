package com.learningloom.learnerservice.entity;


//import com.learningloom.learnerservice.service.CourseClient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "learners")
public class Learner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

//    @ElementCollection  // to create a separate table for the list of enrolled courses
//    private List<Long> enrolledCourseIds;

    @ElementCollection
    private Map<Long, String> enrolledCourses = new HashMap<>();


    @ElementCollection
    private Map<Long, String> completedCourses = new HashMap<>();

    @ElementCollection
    private Map<Long, String> inProgressCourses = new HashMap<>();

//    transient private List<Course> completedCourses;
//
//    transient private List<Course> inProgressCourses;




//    @ManyToMany
//    @JoinTable(
//            name = "course",
//            joinColumns = @JoinColumn(name = "learner_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id")
//    )
//
//    private List<Course> enrolledCourses;
//
//    @ManyToMany
//    @JoinTable(
//            name = "completed_course",
//            joinColumns = @JoinColumn(name = "learner_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id")
//    )
//    private List<Course> completedCourses;
//
//    @ManyToMany
//    @JoinTable(
//            name = "in_progress_course",
//            joinColumns = @JoinColumn(name = "learner_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id")
//    )
//    private List<Course> inProgressCourses;



}
