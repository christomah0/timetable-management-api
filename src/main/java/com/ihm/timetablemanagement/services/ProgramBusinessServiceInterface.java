package com.ihm.timetablemanagement.services;

import com.ihm.timetablemanagement.models.Program;
import com.ihm.timetablemanagement.models.ProgramFiltered;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProgramBusinessServiceInterface extends BusinessServiceInterface<Program, UUID> {
    // Verify the existence of any program by id
    boolean existsById(UUID uuid);

    // Save several programs at once
    void saveAll(List<Program> programList);

    // Filter programs between date time given as parameters
    List<ProgramFiltered> getProgramsBetweenStartDateAndEndDate(
            UUID courseId, LocalDate startDate, LocalDate endDate
    );
}
