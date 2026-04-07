package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Trainer;
import com.examly.springapp.model.TrainerResponseDto;

@Service
public interface TrainerService {

    TrainerResponseDto addTrainer(Trainer trainer);

    Optional<TrainerResponseDto> getTrainerById(Long trainerId);

    List<TrainerResponseDto> getAllTrainers();

    TrainerResponseDto updateTrainer(Long trainerId,Trainer trainer);

    TrainerResponseDto deleteTrainer(Long trainerId);

    //pagination

    Page<TrainerResponseDto> getTrainersByPage(int page,int size);

    void addBulkTrainers(List<Trainer> trainers);



}
