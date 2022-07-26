package Homework;

import java.time.LocalDateTime;

public class Homework3 {
    public static void main(String[] args) {
        LocalDateTime minhaData = LocalDateTime.now();
        minhaData.plusDays(15).plusHours(10);
        System.out.println(minhaData.getDayOfWeek());
        System.out.println(minhaData.getDayOfYear());

    }
}
