package com.university.controller;

import com.university.dto.StudentDto;
import com.university.dto.TimetableSearch;
import com.university.entity.Student;
import com.university.service.StudentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public Student searchTimetable(@RequestBody TimetableSearch search){
       return service.search(search);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addStudent(@RequestBody StudentDto studentDto){
        service.addStudent(studentDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addTimetable")
    public void addTimetable(@RequestBody StudentDto studentDto){
        service.addTimetable(studentDto);
    }
}
