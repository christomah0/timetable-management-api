package com.ihm.timetablemanagement.controllers;

import com.ihm.timetablemanagement.models.Week;
import com.ihm.timetablemanagement.services.implementations.WeekBusinessService;
import com.ihm.timetablemanagement.utils.ServerResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/week")
@CrossOrigin(
        origins = "http://192.168.133.224:5174",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}
)
public class WeekController {
    private final WeekBusinessService weekBusinessService;

    @Autowired
    public WeekController(WeekBusinessService weekBusinessService) {
        this.weekBusinessService = weekBusinessService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Week>> readAll() {
        return ResponseEntity.ok(weekBusinessService.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<Week> readOne(@RequestParam(value = "id", defaultValue = "")UUID uuid) {
        return ResponseEntity.ok(weekBusinessService.findById(uuid));
    }

    @PostMapping("/")
    public ResponseEntity<ServerResponses> createOne(@RequestBody Week week) {
        // Prepare message to send back to the client
        ServerResponses message = new ServerResponses();

        // Verify the existence of weekday
        if (weekBusinessService.existsByName(week.getWeekday())) {
            System.out.println("passed");
            message.setResponse("message", "Weekday already saved.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }

        // Save new weekday
        weekBusinessService.save(week);

        message.setResponse("message", "Weekday added successfully.");
        message.setResponse("id", String.valueOf(week.getWeekId()));
        return ResponseEntity.ok(message);
    }

    @PutMapping("/update")
    public ResponseEntity<ServerResponses> updateOne(
            @RequestParam(value = "id", defaultValue = "") UUID uuid,
            @RequestBody Week week
    ) {
        ServerResponses message = new ServerResponses();

        // Verify the existence of weekday
        if (!weekBusinessService.exists(uuid)) {
            message.setResponse("message", "No weekday found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        message.setResponse("message", "Weekday updated successfully.");
        week.setWeekId(uuid);
        weekBusinessService.save(week);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ServerResponses> deleteOne(@RequestParam(value = "id", defaultValue = "") UUID uuid) {
        ServerResponses message = new ServerResponses();

        // Evaluates the existence of item to delete with its ID
        if (!weekBusinessService.exists(uuid)) {
            message.setResponse("message", "No weekday found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        message.setResponse("message", "Weekday deleted successfully.");
        weekBusinessService.deleteById(uuid);
        return ResponseEntity.ok(message);
    }
}
