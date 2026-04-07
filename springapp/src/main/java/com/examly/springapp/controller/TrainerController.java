package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Trainer;
import com.examly.springapp.model.TrainerResponseDto;
import com.examly.springapp.service.TrainerService;

@RestController
@RequestMapping("/api")
public class TrainerController {

    private static final Logger logger = LoggerFactory.getLogger(TrainerController.class);

    private TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping("/trainer")
    public ResponseEntity<TrainerResponseDto> addTrainer(@RequestBody Trainer trainer) {
        logger.info("Received request to add trainer: {}", trainer);
        TrainerResponseDto addedTrainer = trainerService.addTrainer(trainer);
        logger.info("Trainer added successfully: {}", addedTrainer);
        return new ResponseEntity<>(addedTrainer, HttpStatus.CREATED);
    }

    @GetMapping("/trainer/{trainerId}")
    public ResponseEntity<TrainerResponseDto> getTrainerById(@PathVariable Long trainerId) {
        logger.info("Request to get trainer by ID: {}", trainerId);
        Optional<TrainerResponseDto> trainer = trainerService.getTrainerById(trainerId);
        logger.info("Trainer details retrieved: {}", trainer);
        return new ResponseEntity<>(trainer.get(), HttpStatus.OK);
    }

    @GetMapping("/trainer")
    public ResponseEntity<List<TrainerResponseDto>> getAllTrainers() {
        logger.info("Request to get all trainers");
        logger.info("Fetching all trainers from the database");
        List<TrainerResponseDto> trainers = trainerService.getAllTrainers();

        if (trainers.isEmpty()) {
            logger.warn("No trainers found in the database");
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }

        logger.info("Total trainers retrieved: {}", trainers.size());
        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }

    @PutMapping("/trainer/{trainerId}")
    public ResponseEntity<TrainerResponseDto> updateTrainer(@PathVariable Long trainerId, @RequestBody Trainer trainer) {
        logger.info("Request to update trainer with ID: {}", trainerId);
        TrainerResponseDto updatedTrainer = trainerService.updateTrainer(trainerId, trainer);
        logger.info("Trainer updated successfully: {}", updatedTrainer);
        return new ResponseEntity<>(updatedTrainer, HttpStatus.OK);
    }

    @DeleteMapping("/trainer/{trainerId}")
    public ResponseEntity<TrainerResponseDto> deleteTrainer(@PathVariable Long trainerId) {
        logger.info("Request to delete trainer with ID: {}", trainerId);
        TrainerResponseDto deletedTrainer = trainerService.deleteTrainer(trainerId);
        logger.info("Trainer deleted successfully: {}", deletedTrainer);
        return new ResponseEntity<>(deletedTrainer, HttpStatus.OK);
    }

    @GetMapping("/trainers")
    public Page<TrainerResponseDto> getTrainersByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        logger.info("Fetching trainers for page: {} and size: {}", page, size);
        Page<TrainerResponseDto> trainerPage = trainerService.getTrainersByPage(page, size);

        if (trainerPage.isEmpty()) {
            logger.warn("No trainers found for page: {} and size: {}", page, size);
            return Page.empty();
        }

        logger.info("Trainers fetched successfully for page: {} and size: {}", page, size);
        return trainerPage;
    }
}