package com.example.holidays.controller;

import com.example.holidays.service.HolidaysService;
import de.jollyday.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
public class HolidaysController {


    @Autowired
    private HolidaysService holidaysService;

    @GetMapping("/holidays/{year}")
    public List<LocalDate> getNationalHolidays(@PathVariable int year) {
        return holidaysService.getHolidays(year);
    }
}
