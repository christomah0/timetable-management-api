package com.ihm.timetablemanagement.services.implementations;

import com.ihm.timetablemanagement.models.Course;
import com.ihm.timetablemanagement.models.CourseFiltered;
import com.ihm.timetablemanagement.repositories.CourseRepositoryInterface;
import com.ihm.timetablemanagement.services.CourseBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseBusinessService implements CourseBusinessServiceInterface {
    private final CourseRepositoryInterface courseRepositoryInterface;

    @Autowired
    public CourseBusinessService(CourseRepositoryInterface courseRepositoryInterface) {
        this.courseRepositoryInterface = courseRepositoryInterface;
    }

    @Override
    public boolean existsById(UUID uuid) {
        return courseRepositoryInterface.existsById(uuid);
    }

    @Override
    public List<CourseFiltered> getCoursesByEstablishment(String establishmentName) {
        return courseRepositoryInterface.findCoursesByEstablishment(establishmentName);
    }

    @Override
    public List<Course> findAll() {
        return courseRepositoryInterface.findAll();
    }

    @Override
    public void save(Course object) {
        courseRepositoryInterface.save(object);
    }

    @Override
    public Course findById(UUID object) {
        return courseRepositoryInterface.findById(object).orElse(null);
    }

    @Override
    public void deleteById(UUID object) {
        courseRepositoryInterface.deleteById(object);
    }
}
