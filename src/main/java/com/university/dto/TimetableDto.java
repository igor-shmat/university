package com.university.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TimetableDto {
    private List<CourseDto> courseDtos;
    private LocalDate timetableDate;
}
