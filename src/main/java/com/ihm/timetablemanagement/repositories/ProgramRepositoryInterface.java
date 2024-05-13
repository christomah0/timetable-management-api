package com.ihm.timetablemanagement.repositories;

import com.ihm.timetablemanagement.models.Program;
import com.ihm.timetablemanagement.models.ProgramFiltered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProgramRepositoryInterface extends JpaRepository<Program, UUID> {
    @Meta(comment = "Select all programs between range of date provided.")
    @Query(
            value = "SELECT new com.ihm.timetablemanagement.models.ProgramFiltered(" +
                    "p.programId, p.date, p.startTime, p.endTime, p.week.weekday, p.moduleName, p.course.courseName, p.course.level.rankLevel) " +
                    "FROM Program p WHERE p.course.courseId=:courseId AND (p.date BETWEEN :startDate AND :endDate)"
    )
    List<ProgramFiltered> findProgramsByStartDateAndEndDate(
            @Param("courseId") UUID courseId, @Param("startDate") LocalDate startDate, @Param("endDate")LocalDate endDate
    );
}
