package com.ihm.timetablemanagement.controllers;

import com.ihm.timetablemanagement.models.Period;
import com.ihm.timetablemanagement.services.implementations.PeriodBusinessService;
import com.ihm.timetablemanagement.utils.ServerResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/period")
public class PeriodController {
    private final PeriodBusinessService periodBusinessService;

    @Autowired
    public PeriodController(PeriodBusinessService periodBusinessService) {
        this.periodBusinessService = periodBusinessService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Period>> readAll() {
        return ResponseEntity.ok(periodBusinessService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<ServerResponses> createOne(@RequestBody Period period) {
        ServerResponses message = new ServerResponses();

        if (periodBusinessService.existsByDayPeriod(period.getDayPeriod())) {
            message.setResponse("message", "Day period already existed.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }

        // Save new period
        periodBusinessService.save(period);

        message.setResponse("message", "Period saved successfully.");
        message.setResponse("id", String.valueOf(period.getPeriodId()));
        return ResponseEntity.ok(message);
    }

    @PutMapping("/update")
    public ResponseEntity<ServerResponses> updateOne(
            @RequestParam(value = "id", defaultValue = "")UUID uuid,
            @RequestBody Period period
    ) {
        ServerResponses message = new ServerResponses();

        if (!periodBusinessService.existsById(uuid)) {
            message.setResponse("message", "No period found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        message.setResponse("message", "Period updated successfully.");
        period.setPeriodId(uuid);
        periodBusinessService.save(period);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ServerResponses> deleteOne(@RequestParam(value = "id", defaultValue = "") UUID uuid) {
        ServerResponses message = new ServerResponses();

        if (!periodBusinessService.existsById(uuid)) {
            message.setResponse("message", "No period found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        message.setResponse("message", "Period deleted successfully.");
        periodBusinessService.deleteById(uuid);
        return ResponseEntity.ok(message);
    }
}
