package com.ihm.timetablemanagement.repositories;

import com.ihm.timetablemanagement.models.Week;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WeekRepositoryInterface extends JpaRepository<Week, UUID> {
    @Meta(comment = "Query to select a registration by name")
    @Query(
            value = "SELECT new com.ihm.timetablemanagement.models.Week(w.weekId, w.weekday) " +
                    "FROM Week w WHERE w.weekday LIKE %:weekday%"
    )
    Week findByDayName(@Param("weekday") String weekday);
}
