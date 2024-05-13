package com.ihm.timetablemanagement.services.implementations;

import com.ihm.timetablemanagement.models.Program;
import com.ihm.timetablemanagement.models.ProgramFiltered;
import com.ihm.timetablemanagement.repositories.ProgramRepositoryInterface;
import com.ihm.timetablemanagement.services.ProgramBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ProgramBusinessService implements ProgramBusinessServiceInterface {
    private final ProgramRepositoryInterface programRepositoryInterface;

    @Autowired
    public ProgramBusinessService(ProgramRepositoryInterface programRepositoryInterface) {
        this.programRepositoryInterface = programRepositoryInterface;
    }

    @Override
    public boolean existsById(UUID uuid) {
        return programRepositoryInterface.existsById(uuid);
    }

    @Override
    public void saveAll(List<Program> programList) {
        programRepositoryInterface.saveAll(programList);
    }

    @Override
    public List<ProgramFiltered> getProgramsBetweenStartDateAndEndDate(UUID courseId, LocalDate startDate, LocalDate endDate) {
        return programRepositoryInterface.findProgramsByStartDateAndEndDate(courseId, startDate, endDate);
    }

    @Override
    public List<Program> findAll() {
        return programRepositoryInterface.findAll();
    }

    @Override
    public void save(Program object) {
        programRepositoryInterface.save(object);
    }

    @Override
    public Program findById(UUID object) {
        return programRepositoryInterface.findById(object).orElse(null);
    }

    @Override
    public void deleteById(UUID object) {
        programRepositoryInterface.deleteById(object);
    }
}
