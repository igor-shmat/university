package com.university.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TimetableSearch {
    private String studentFio;
    private LocalDate date;
    private Long studentId;
}
