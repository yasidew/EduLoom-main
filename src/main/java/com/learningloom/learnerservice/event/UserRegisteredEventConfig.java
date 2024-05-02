//package com.learningloom.learnerservice.event;
//import com.learningloom.learnerservice.entity.Learner;
//import com.learningloom.learnerservice.repository.LearnerRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.function.Consumer;
//
//@Configuration
//public class UserRegisteredEventConfig {
//
//
//    private final LearnerRepository learnerRepository;
//
//    public UserRegisteredEventConfig(LearnerRepository learnerRepository) {
//        this.learnerRepository = learnerRepository;
//    }
//
//    @Bean
//    public Consumer<UserRegisteredEvent> userRegisteredEventConsumer() {
//        return event -> {
//            // Create a new Learner
//            Learner learner = new Learner();
//            learner.setName(event.getName());
//            learner.setEmail(event.getEmail());
////            learner.setPassword(event.getPassword());
//
//            // Initialize the maps
//            learner.setEnrolledCourses(new HashMap<>());
//            learner.setCompletedCourses(new HashMap<>());
//            learner.setInProgressCourses(new HashMap<>());
//
//            // Save the Learner
//            learnerRepository.save(learner);
//        };
//    }
//}
