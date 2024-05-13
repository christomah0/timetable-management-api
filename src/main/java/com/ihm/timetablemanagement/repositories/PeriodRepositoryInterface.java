package com.ihm.timetablemanagement.repositories;

import com.ihm.timetablemanagement.models.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PeriodRepositoryInterface extends JpaRepository<Period, UUID> {
    @Meta(comment = "Fetch any period depending on day period")
    @Query(
            value = "SELECT new com.ihm.timetablemanagement.models.Period(p.periodId, p.dayPeriod) " +
                    "FROM Period p WHERE p.dayPeriod LIKE %:dayPeriod%"
    )
    Period findByDayPeriod(@Param("dayPeriod") String dayPeriod);
}
