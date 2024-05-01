package com.example.Payment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "completed")
public class Completed_Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String learnerId;
    private Double price;
    private Date date;
    private String currency;
    private String method;
    private String intent;
    private String description;
}
