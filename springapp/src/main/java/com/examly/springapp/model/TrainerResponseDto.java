package com.examly.springapp.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerResponseDto {
    private Long trainerId;
    private String name;
    private String email;
    private String phone;
    private String expertise;
    private String experience;
    private String certification;
    private String resume;
    private LocalDate joiningDate;
    private String status;
}