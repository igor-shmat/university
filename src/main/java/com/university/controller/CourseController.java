package com.university.controller;

import com.university.dto.CourseDto;
import com.university.entity.Course;
import com.university.service.CourseService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addCourse(@RequestBody CourseDto courseDto){
        service.add(courseDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public List<Course> getAll(){
        return service.getAll();
    }
}
