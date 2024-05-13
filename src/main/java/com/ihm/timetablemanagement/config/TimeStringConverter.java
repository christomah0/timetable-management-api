package com.ihm.timetablemanagement.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeStringConverter implements Converter<String, LocalTime> {

    @Override
    public LocalTime convert(String source) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(source, dateTimeFormatter);
    }
}
