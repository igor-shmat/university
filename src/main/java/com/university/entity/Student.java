package com.university.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fio;

    @ManyToMany
    private Set<Timetable> timetables;

    public Student(String fio) {
        this.fio = fio;
    }

    public Student(String fio, Set<Timetable> timetables) {
        this.fio = fio;
        this.timetables = timetables;
    }
}
