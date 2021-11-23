package com.university.init;

import com.university.dao.CourseRepository;
import com.university.entity.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(1)
@Component
public class CourseInit implements CommandLineRunner {
    private final CourseRepository repository;

    public CourseInit(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = repository.count();
        if (count > 0) return;
        Course maths = new Course("maths", 256);
        Course history = new Course("history", 325);
        Course physics = new Course("physics", 24);
        Course english = new Course("english", 56);
        Course programming = new Course("programming", 78);
        Course philosophy = new Course("philosophy", 89);
        Course economicTheory = new Course("economicTheory", 32);
        Course psychology = new Course("psychology", 41);
        List<Course> courses = List.of(maths, history, physics, english, programming, philosophy, economicTheory, psychology);
        repository.saveAll(courses);
    }
}
