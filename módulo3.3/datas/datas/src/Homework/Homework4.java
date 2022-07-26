package Homework;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Homework4 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.UK);
        ZoneId zoneId = ZoneId.of("Europe/London");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
        LocalDateTime localDateTime = LocalDateTime.now(zoneId);

//        ChronoZonedDateTime.from(localDateTime);
        localDateTime = LocalDateTime.parse("14/09/2024 18:30", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        LocalDateTime showTime = localDateTime
                .minusYears(zonedDateTime.getYear())
                .minusMonths(zonedDateTime.getMonthValue())
                .minusDays(zonedDateTime.getDayOfMonth())
                .minusHours(zonedDateTime.getHour())
                .minusMinutes(zonedDateTime.getMinute());

        System.out.printf("Tempo ate o evento %d anos , %d meses , %d dias, %d horas e %d minutos\n ",showTime.getYear(),
                showTime.getMonthValue()
                ,showTime.getDayOfMonth()
                ,showTime.getHour()
                ,showTime.getMinute());

        System.out.println("--------------------------------------");
        System.out.println(zonedDateTime);

    }
}
