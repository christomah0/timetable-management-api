package com.ihm.timetablemanagement.controllers;

import com.ihm.timetablemanagement.models.Course;
import com.ihm.timetablemanagement.models.CourseFiltered;
import com.ihm.timetablemanagement.services.implementations.CourseBusinessService;
import com.ihm.timetablemanagement.utils.ServerResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/course")
@CrossOrigin(
        origins = "http://192.168.133.224:5174",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}
)
public class CourseController {
    private final CourseBusinessService courseBusinessService;

    @Autowired
    public CourseController(CourseBusinessService courseBusinessService) {
        this.courseBusinessService = courseBusinessService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Course>> readAll() {
        return ResponseEntity.ok(courseBusinessService.findAll());
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<CourseFiltered>> readAllByEstablishment(
            @RequestParam(value = "establishment", defaultValue = "") String name
    ) {
        return ResponseEntity.ok(courseBusinessService.getCoursesByEstablishment(name));
    }

    @PostMapping("/")
    public ResponseEntity<ServerResponses> createOne(@RequestBody Course course) {
        // Prepare responses to send back
        ServerResponses message = new ServerResponses();
        message.setResponse("message", "Course added successfully.");

        // Save new mention
        courseBusinessService.save(course);
        message.setResponse("id", String.valueOf(course.getCourseId()));

        return ResponseEntity.ok(message);
    }

    @PutMapping("/update")
    public ResponseEntity<ServerResponses> updateOne(
            @RequestParam(value = "id", defaultValue = "")UUID uuid, @RequestBody Course course
    ) {
        // Prepare response to send back
        ServerResponses responses = new ServerResponses();

        // Evaluates the existence of course before saving
        if (!courseBusinessService.existsById(uuid)) {
            responses.setResponse("message", "No course found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responses);
        }

        // Update the pointed course with fresh data
        course.setCourseId(uuid);
        courseBusinessService.save(course);

        responses.setResponse("message", "Course updated successfully.");
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ServerResponses> deleteOne(@RequestParam(value = "id", defaultValue = "") UUID uuid) {
        ServerResponses responses = new ServerResponses();

        if (!courseBusinessService.existsById(uuid)) {
            responses.setResponse("message", "No course found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responses);
        }

        courseBusinessService.deleteById(uuid);
        responses.setResponse("message", "Course deleted successfully.");
        return ResponseEntity.ok(responses);
    }
}
