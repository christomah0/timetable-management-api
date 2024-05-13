package com.ihm.timetablemanagement.controllers;

import com.ihm.timetablemanagement.models.Establishment;
import com.ihm.timetablemanagement.services.implementations.EstablishmentBusinessService;
import com.ihm.timetablemanagement.utils.ServerResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/establishment")
public class EstablishmentController {
    private final EstablishmentBusinessService establishmentBusinessService;

    @Autowired
    public EstablishmentController(EstablishmentBusinessService establishmentBusinessService) {
        this.establishmentBusinessService = establishmentBusinessService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Establishment>> readAll() {
        return ResponseEntity.ok(establishmentBusinessService.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<Establishment> readOne(@RequestParam(value = "id", defaultValue = "") UUID uuid) {
        return ResponseEntity.ok(establishmentBusinessService.findById(uuid));
    }

    @PostMapping("/")
    public ResponseEntity<ServerResponses> createOne(
            @RequestBody Establishment establishment
    ) {
        // Prepare to send back a message to the client
        ServerResponses msg = new ServerResponses();
        msg.setResponse("message", "Establishment added successfully.");

        // Save new establishment
        establishmentBusinessService.save(establishment);
        msg.setResponse("id", String.valueOf(establishment.getEstablishmentId()));

        return ResponseEntity.ok(msg);
    }

    @PutMapping("/update")
    public ResponseEntity<ServerResponses> updateOne(
            @RequestParam(value = "id", defaultValue = "")UUID uuid,
            @RequestBody Establishment establishment
    ) {
        ServerResponses msg = new ServerResponses();

        // Evaluates the existence of instance
        if (!establishmentBusinessService.exists(uuid)) {
            msg.setResponse("message", "No establishment found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }

        msg.setResponse("message", "Establishment updated successfully.");
        establishment.setEstablishmentId(uuid);
        establishmentBusinessService.save(establishment);
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ServerResponses> deleteOne(
            @RequestParam(value = "id", defaultValue = "")UUID uuid
    ) {
        ServerResponses msg = new ServerResponses();

        if (!establishmentBusinessService.exists(uuid)) {
            msg.setResponse("message", "No establishment found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }

        msg.setResponse("message", "Establishment deleted successfully.");
        establishmentBusinessService.deleteById(uuid);
        return ResponseEntity.ok(msg);
    }
}
