package com.university.service;

import com.university.dao.CourseRepository;
import com.university.dto.CourseDto;
import com.university.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public void add(CourseDto courseDto) {
        repository.save(new Course(courseDto.getName(), courseDto.getCabinet()));
    }

    public List<Course> getAll() {
        return repository.findAll();
    }

    public List<Course>findByIdIn(List<Long>ids){
        return repository.findByIdIn(ids);
    }
}
