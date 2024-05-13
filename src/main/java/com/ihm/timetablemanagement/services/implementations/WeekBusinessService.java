package com.ihm.timetablemanagement.services.implementations;

import com.ihm.timetablemanagement.models.Week;
import com.ihm.timetablemanagement.repositories.WeekRepositoryInterface;
import com.ihm.timetablemanagement.services.WeekBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WeekBusinessService implements WeekBusinessServiceInterface {
    private final WeekRepositoryInterface weekRepositoryInterface;

    @Autowired
    public WeekBusinessService(WeekRepositoryInterface weekRepositoryInterface) {
        this.weekRepositoryInterface = weekRepositoryInterface;
    }

    @Override
    public boolean exists(UUID uuid) {
        return weekRepositoryInterface.existsById(uuid);
    }

    @Override
    public boolean existsByName(String weekday) {
        Week week = weekRepositoryInterface.findByDayName(weekday);
        return !(week == null);
    }

    @Override
    public List<Week> findAll() {
        return weekRepositoryInterface.findAll();
    }

    @Override
    public void save(Week object) {
        weekRepositoryInterface.save(object);
    }

    @Override
    public Week findById(UUID object) {
        return weekRepositoryInterface.findById(object).orElse(null);
    }

    @Override
    public void deleteById(UUID object) {
        weekRepositoryInterface.deleteById(object);
    }
}
