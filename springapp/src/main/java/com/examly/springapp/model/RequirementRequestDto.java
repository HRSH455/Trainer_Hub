package com.examly.springapp.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequirementRequestDto {

    private long requirementId;
    private String title;
    private String description;
    private String department;
    private LocalDate postedDate;
    private String status;
    private String duration;
    private String mode;
    private String location;
    private String skillLevel;
    private double budget;
    private String priority;

    private long trainerId;


}
