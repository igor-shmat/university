package com.university.service;

import com.university.dao.StudentRepository;
import com.university.dto.StudentDto;
import com.university.dto.TimetableSearch;
import com.university.entity.Student;
import com.university.entity.Timetable;


import org.assertj.core.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final TimetableService timetableService;

    public StudentService(StudentRepository studentRepository, TimetableService timetableService) {
        this.studentRepository = studentRepository;
        this.timetableService = timetableService;
    }

    public Student search(TimetableSearch search) {
        Student student = null;
        if (!Strings.isNullOrEmpty(search.getStudentFio())) {
            student = studentRepository.findByFio(search.getStudentFio());
        }
        if (search.getStudentId() != null) {
            student = studentRepository.getById(search.getStudentId());
        }
        if (student != null && search.getDate() != null) {
            Set<Timetable> timetables = student.getTimetables().stream().filter(one -> one.getTimetableDate().equals(search.getDate()))
                    .collect(Collectors.toSet());
            student.setTimetables(timetables);
        }

        return student;
    }

    public void addStudent(StudentDto studentDto) {
        studentRepository.save(new Student(studentDto.getFio()));
    }

    public void addTimetable(StudentDto studentDto) {
        Timetable timetable = timetableService.getById(studentDto.getTimetableId());
        Student student = studentRepository.getById(studentDto.getStudentId());
        Set<Timetable> timetables = student.getTimetables();
        timetables.add(timetable);
        student.setTimetables(timetables);
        studentRepository.save(student);
    }
}
