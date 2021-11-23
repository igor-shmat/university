package com.university.controller;


import com.university.dto.TimetableDto;
import com.university.entity.Timetable;
import com.university.service.TimetableService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/timetable")
public class TimetableController {
    private final TimetableService service;

    public TimetableController(TimetableService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public Timetable add(@RequestBody TimetableDto timetableDto){
        return service.add(timetableDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public List<Timetable> getAll(){
       return service.getAll();
    }
}
