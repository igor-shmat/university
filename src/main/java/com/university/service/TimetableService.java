package com.university.service;

import com.university.dao.TimetableRepository;
import com.university.dto.CourseDto;
import com.university.dto.TimetableDto;
import com.university.entity.Course;
import com.university.entity.Timetable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimetableService {
    private final TimetableRepository repository;
    private final CourseService courseService;

    public TimetableService(TimetableRepository repository, CourseService courseService) {
        this.repository = repository;
        this.courseService = courseService;
    }

    public Timetable getById(Long id){
       return repository.getById(id);
    }

    public List<Timetable> getAll() {
        return repository.findAll();
    }

    public Timetable add(TimetableDto timetableDto) {
        List<Long> ids = timetableDto.getCourseDtos().stream().map(CourseDto::getId).collect(Collectors.toList());
        List<Course> courses = courseService.findByIdIn(ids);
        return repository.save(new Timetable (courses, timetableDto.getTimetableDate()));
    }
}
