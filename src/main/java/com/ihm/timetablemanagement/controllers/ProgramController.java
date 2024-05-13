package com.ihm.timetablemanagement.controllers;

import com.ihm.timetablemanagement.models.Program;
import com.ihm.timetablemanagement.models.ProgramFiltered;
import com.ihm.timetablemanagement.services.implementations.ProgramBusinessService;
import com.ihm.timetablemanagement.utils.ServerResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/program")
@CrossOrigin(
        origins = "http://192.168.133.224:5174",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}
)
public class ProgramController {
    private final ProgramBusinessService programBusinessService;

    @Autowired
    public ProgramController(ProgramBusinessService programBusinessService) {
        this.programBusinessService = programBusinessService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Program>> readAll() {
        return ResponseEntity.ok(programBusinessService.findAll());
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<ProgramFiltered>> readAllBetweenStartDateAndEndDate(
            @RequestParam(value = "course-id", defaultValue = "")UUID courseId,
            @RequestParam(value = "start-date", defaultValue = "")LocalDate startDate,
            @RequestParam(value = "end-date", defaultValue = "")LocalDate endDate
    ) {
        return ResponseEntity.ok(programBusinessService.getProgramsBetweenStartDateAndEndDate(courseId, startDate, endDate));
    }

    @PostMapping("/")
    public ResponseEntity<ServerResponses> createOne(@RequestBody Program program) {
        ServerResponses responses = new ServerResponses();

        programBusinessService.save(program);
        responses.setResponse("message", "Program saved successfully.");
        responses.setResponse("id", String.valueOf(program.getProgramId()));

        return ResponseEntity.ok(responses);
    }

    @PostMapping("/many/")
    public ResponseEntity<ServerResponses> createMany(@RequestBody List<Program> programList) {
        ServerResponses responses = new ServerResponses();

        programBusinessService.saveAll(programList);
        responses.setResponse("message", "Program list saved successfully.");

        return ResponseEntity.ok(responses);
    }

    @PutMapping("/update")
    public ResponseEntity<ServerResponses> updateOne(
            @RequestParam(value = "id", defaultValue = "")UUID uuid, @RequestBody Program program
    ) {
        ServerResponses responses = new ServerResponses();

        if (!programBusinessService.existsById(uuid)) {
            responses.setResponse("message", "No program found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responses);
        }

        // Update the program data after passed verification
        program.setProgramId(uuid);
        programBusinessService.save(program);
        responses.setResponse("message", "Program updated successfully.");

        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ServerResponses> deleteOne(@RequestParam(value = "id", defaultValue = "") UUID uuid) {
        ServerResponses responses = new ServerResponses();

        if (!programBusinessService.existsById(uuid)) {
            responses.setResponse("message", "No program found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responses);
        }

        // Delete the specified program without history
        programBusinessService.deleteById(uuid);
        responses.setResponse("message", "Program deleted successfully.");

        return ResponseEntity.ok(responses);
    }
}
