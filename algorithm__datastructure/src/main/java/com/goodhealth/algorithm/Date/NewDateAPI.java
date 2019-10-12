package com.goodhealth.algorithm.Date;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class NewDateAPI {

    public static void main(String[] args){
        Instant start = Instant.now();
        System.out.println(start);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.getSeconds());
        System.out.println(LocalDate.now());

    }
}
