package com.university.init;

import com.university.dao.CourseRepository;
import com.university.dao.TimetableRepository;
import com.university.entity.Course;
import com.university.entity.Timetable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Order(2)
@Component
public class TimetableInit implements CommandLineRunner {
    private final TimetableRepository repository;
    private final CourseRepository courseRepository;

    public TimetableInit(TimetableRepository repository,
                         CourseRepository courseRepository) {
        this.repository = repository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args){
        if (repository.count() > 0) return;

        List<Course> courseList = courseRepository.findAll();
        Timetable timetableDateNow = new Timetable(this.getRandom(courseList), LocalDate.now());
        Timetable timetableDateTomorrow = new Timetable(this.getRandom(courseList), LocalDate.now().plusDays(1));
        Timetable timetableDateAfterTomorrow = new Timetable(this.getRandom(courseList), LocalDate.now().plusDays(2));
        repository.saveAll(List.of(timetableDateNow, timetableDateTomorrow, timetableDateAfterTomorrow));
    }

    private List<Course> getRandom(List<Course> courseList) {
        List<Course> courseRandom = new ArrayList<>();
        Course random = null;
        Random randomizer = new Random();
        for (int i = 0; i < 7; i++) {
            random = courseList.get(randomizer.nextInt(courseList.size()));
            courseRandom.add(random);
        }
        return courseRandom;
    }
}
