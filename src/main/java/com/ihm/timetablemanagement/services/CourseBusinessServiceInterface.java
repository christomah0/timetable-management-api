package com.ihm.timetablemanagement.services;

import com.ihm.timetablemanagement.models.Course;
import com.ihm.timetablemanagement.models.CourseFiltered;

import java.util.List;
import java.util.UUID;

public interface CourseBusinessServiceInterface extends BusinessServiceInterface<Course, UUID> {
    // Verify the existence of any period by id
    boolean existsById(UUID uuid);

    // Get all courses by establishment name given
    List<CourseFiltered> getCoursesByEstablishment(String establishmentName);
}
