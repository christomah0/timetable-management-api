package com.ihm.timetablemanagement.repositories;

import com.ihm.timetablemanagement.models.Course;
import com.ihm.timetablemanagement.models.CourseFiltered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseRepositoryInterface extends JpaRepository<Course, UUID> {
    @Meta(comment = "Select all courses with filtered items")
    @Query(
            value = "SELECT new com.ihm.timetablemanagement.models.CourseFiltered(" +
                    "c.courseId, c.courseName, c.level.rankLevel) " +
                    "FROM Course c WHERE c.establishment.name LIKE %:establishment%"
    )
    List<CourseFiltered> findCoursesByEstablishment(@Param("establishment") String establishment);
}
