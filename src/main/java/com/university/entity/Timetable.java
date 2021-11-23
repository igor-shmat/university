package com.university.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Course> courses;

    private LocalDate timetableDate;

    public Timetable(List<Course> courses, LocalDate timetableDate) {
        this.courses = courses;
        this.timetableDate = timetableDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return Objects.equals(id, timetable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
