package com.ihm.timetablemanagement.controllers;

import com.ihm.timetablemanagement.models.Level;
import com.ihm.timetablemanagement.services.implementations.LevelBusinessService;
import com.ihm.timetablemanagement.utils.ServerResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/level")
public class LevelController {
    private final LevelBusinessService levelBusinessService;

    @Autowired
    public LevelController(LevelBusinessService levelBusinessService) {
        this.levelBusinessService = levelBusinessService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Level>> readAll() {
        return ResponseEntity.ok(levelBusinessService.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<Level> readOne(@RequestParam(value = "id", defaultValue = "")UUID uuid) {
        return ResponseEntity.ok(levelBusinessService.findById(uuid));
    }

    @PostMapping("/")
    public ResponseEntity<ServerResponses> createOne(@RequestBody Level level) {
        // Prepare message to send back to the client
        ServerResponses msg = new ServerResponses();
        msg.setResponse("message", "Level added successfully.");

        // Save new level
        levelBusinessService.save(level);

        msg.setResponse("id", String.valueOf(level.getLevelId()));
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/update")
    public ResponseEntity<ServerResponses> updateOne(
            @RequestParam(value = "id", defaultValue = "") UUID uuid,
            @RequestBody Level level
    ) {
        ServerResponses msg = new ServerResponses();

        // Evaluates the existence of instance
        if (!levelBusinessService.exists(uuid)) {
            msg.setResponse("message", "No level found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }

        msg.setResponse("message", "Level updated successfully.");
        level.setLevelId(uuid);
        levelBusinessService.save(level);
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ServerResponses> deleteOne(@RequestParam(value = "id", defaultValue = "") UUID uuid) {
        ServerResponses message = new ServerResponses();

        if (!levelBusinessService.exists(uuid)) {
            message.setResponse("message", "No level found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        message.setResponse("message", "Level deleted successfully.");
        levelBusinessService.deleteById(uuid);
        return ResponseEntity.ok(message);
    }
}
