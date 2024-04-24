package com.ihm.timetablemanagement.controllers;

import com.ihm.timetablemanagement.models.Establishment;
import com.ihm.timetablemanagement.services.implementations.EstablishmentBusinessService;
import com.ihm.timetablemanagement.utils.ServerMessage;
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
    public ResponseEntity<List<Establishment>> readAllInstances() {
        return ResponseEntity.ok(establishmentBusinessService.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<Establishment> readSingleInstance(@RequestParam(value = "id", defaultValue = "") UUID uuid) {
        return ResponseEntity.ok(establishmentBusinessService.findById(uuid));
    }

    @PostMapping("/")
    public ResponseEntity<ServerMessage> createSingleInstance(
            @RequestBody Establishment establishment
    ) {
        // Prepare to send back a message to the client
        ServerMessage msg = new ServerMessage();
        msg.setMessage("message", "Establishment added successfully.");

        // Save new establishment
        establishmentBusinessService.save(establishment);

        return ResponseEntity.ok(msg);
    }

    @PutMapping("/update")
    public ResponseEntity<ServerMessage> updateSingleInstance(
            @RequestParam(value = "id", defaultValue = "")UUID uuid,
            @RequestBody Establishment establishment
    ) {
        ServerMessage msg = new ServerMessage();

        // Evaluates the existence of instance
        if (!establishmentBusinessService.exists(uuid)) {
            msg.setMessage("message", "No establishment found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }

        msg.setMessage("message", "Establishment updated successfully.");
        establishment.setEstablishmentId(uuid);
        establishmentBusinessService.save(establishment);
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ServerMessage> deleteSingleInstance(
            @RequestParam(value = "id", defaultValue = "")UUID uuid
    ) {
        ServerMessage msg = new ServerMessage();

        if (!establishmentBusinessService.exists(uuid)) {
            msg.setMessage("message", "No establishment found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }

        msg.setMessage("message", "Establishment deleted successfully.");
        establishmentBusinessService.deleteById(uuid);
        return ResponseEntity.ok(msg);
    }
}
