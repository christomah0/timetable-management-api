package com.ihm.timetablemanagement.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class CourseFiltered {
    private UUID courseId;
    private String courseName;
    private String rankLevel;

    public CourseFiltered(UUID courseId, String courseName, String rankLevel) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.rankLevel = rankLevel;
    }
}
