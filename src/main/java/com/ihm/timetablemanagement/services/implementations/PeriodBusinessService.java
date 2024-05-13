package com.ihm.timetablemanagement.services.implementations;

import com.ihm.timetablemanagement.models.Period;
import com.ihm.timetablemanagement.repositories.PeriodRepositoryInterface;
import com.ihm.timetablemanagement.services.PeriodBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PeriodBusinessService implements PeriodBusinessServiceInterface {
    private final PeriodRepositoryInterface periodRepositoryInterface;

    @Autowired
    public PeriodBusinessService(PeriodRepositoryInterface periodRepositoryInterface) {
        this.periodRepositoryInterface = periodRepositoryInterface;
    }

    @Override
    public List<Period> findAll() {
        return periodRepositoryInterface.findAll();
    }

    @Override
    public void save(Period object) {
        periodRepositoryInterface.save(object);
    }

    @Override
    public Period findById(UUID object) {
        return periodRepositoryInterface.findById(object).orElse(null);
    }

    @Override
    public void deleteById(UUID object) {
        periodRepositoryInterface.deleteById(object);
    }

    @Override
    public boolean existsByDayPeriod(String dayPeriod) {
        return !(periodRepositoryInterface.findByDayPeriod(dayPeriod) == null);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return periodRepositoryInterface.existsById(uuid);
    }
}
