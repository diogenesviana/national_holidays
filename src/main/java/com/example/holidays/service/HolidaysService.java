package com.example.holidays.service;

import de.jollyday.Holiday;
import de.jollyday.HolidayCalendar;
import de.jollyday.HolidayManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class HolidaysService {

    public List<LocalDate> getHolidays(int year) {
        List<LocalDate> holidays = new ArrayList<>();

        holidays.add(LocalDate.of(year, 1, 1)); // Ano Novo
        holidays.add(LocalDate.of(year, 4, 21)); // Tiradentes
        holidays.add(LocalDate.of(year, 5, 1)); // Dia do Trabalho
        holidays.add(LocalDate.of(year, 9, 7)); // Independência do Brasil
        holidays.add(LocalDate.of(year, 10, 12)); // Nossa Senhora Aparecida
        holidays.add(LocalDate.of(year, 11, 2)); // Dia de Finados
        holidays.add(LocalDate.of(year, 11, 15)); // Proclamação da República
        holidays.add(LocalDate.of(year, 12, 25)); // Natal

        // Carnaval
        LocalDate easterSunday = calculateEasterSunday(year);
        holidays.add(easterSunday.minusDays(47)); // Carnaval (2 dias antes da quarta-feira de cinzas)

        // Sexta-feira Santa (1 dia antes da Páscoa)
        holidays.add(easterSunday.minusDays(2));

        // Corpus Christi (60 dias após a Páscoa)
        holidays.add(easterSunday.plusDays(60));

        return holidays;
    }

    private LocalDate calculateEasterSunday(int year) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b - (b / 4) - 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int month = (h + l - 7 * m + 114) / 31;
        int day = ((h + l - 7 * m + 114) % 31) + 1;
        return LocalDate.of(year, month, day);
    }
}
