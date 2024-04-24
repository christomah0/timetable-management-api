package com.ihm.timetablemanagement.controllers;

import com.ihm.timetablemanagement.models.Level;
import com.ihm.timetablemanagement.services.implementations.LevelBusinessService;
import com.ihm.timetablemanagement.utils.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResponseEntity<List<Level>> readAllInstances() {
        return ResponseEntity.ok(levelBusinessService.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<Level> readSingleInstance(@RequestParam(value = "id", defaultValue = "")UUID uuid) {
        return ResponseEntity.ok(levelBusinessService.findById(uuid));
    }

    @PostMapping("/")
    public ResponseEntity<ServerMessage> createSingleInstance(@RequestBody Level level) {
        // Prepare message to send back to the client
        ServerMessage msg = new ServerMessage();
        msg.setMessage("message", "Level added successfully.");

        // Save new level
        levelBusinessService.save(level);

        return ResponseEntity.ok(msg);
    }

    @PutMapping("/update")
    public ResponseEntity<ServerMessage> updateSingleInstance(
            @RequestParam(value = "id", defaultValue = "") UUID uuid,
            @RequestBody Level level
    ) {
        ServerMessage msg = new ServerMessage();

        // Evaluates the existence of instance
        if (!levelBusinessService.exists(uuid)) {
            msg.setMessage("message", "No level found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }

        msg.setMessage("message", "Level updated successfully.");
        level.setLevelId(uuid);
        levelBusinessService.save(level);
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ServerMessage> deleteSingleInstance(@RequestParam(value = "id", defaultValue = "") UUID uuid) {
        ServerMessage message = new ServerMessage();

        if (!levelBusinessService.exists(uuid)) {
            message.setMessage("message", "No level found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        message.setMessage("message", "Level deleted successfully.");
        levelBusinessService.deleteById(uuid);
        return ResponseEntity.ok(message);
    }
}
