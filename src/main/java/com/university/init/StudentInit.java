package com.university.init;

import com.university.dao.StudentRepository;
import com.university.dao.TimetableRepository;
import com.university.entity.Student;
import com.university.entity.Timetable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.*;

@Order(3)
@Component
public class StudentInit implements CommandLineRunner {

    private final StudentRepository repository;
    private final TimetableRepository timetableRepository;

    public StudentInit(StudentRepository repository, TimetableRepository timetableRepository) {
        this.repository = repository;
        this.timetableRepository = timetableRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Timetable> timetableList = timetableRepository.findAll();
        if (repository.count() > 0) {
            return;
        }
        Student ivan1 = new Student("Ivan1 Ivanovich", getRandom(timetableList));
        Student ivan2 = new Student("Ivan2 Ivanovich", getRandom(timetableList));
        Student ivan3 = new Student("Ivan3 Ivanovich", getRandom(timetableList));
        Student ivan4 = new Student("Ivan4 Ivanovich", getRandom(timetableList));
        Student ivan5 = new Student("Ivan5 Ivanovich", getRandom(timetableList));

        repository.saveAll(List.of(ivan1,ivan2,ivan3,ivan4,ivan5));
    }

    private Set<Timetable> getRandom(List<Timetable> timetableList) {
        Set<Timetable> timetableRandom = new HashSet<>();
        Random randomizer = new Random();
        Timetable random = null;
        for (int i = 0; i < 4; i++) {
            random = timetableList.get(randomizer.nextInt(timetableList.size()));
            timetableRandom.add(random);
        }
        return timetableRandom;
    }
}
