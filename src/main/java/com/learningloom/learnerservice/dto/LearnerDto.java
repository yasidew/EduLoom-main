package com.learningloom.learnerservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LearnerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


}
