package day58_05_06_2025;

/*
Write a java program that reads two timestamps (yyyy-MM-dd HH:mm:ss format) and
display the time elapsed between them in minutes and seconds.

Input: 
------
2025-06-04 10:30:00
2025-06-04 11:15:40

Output: 
-------
Elapsed: 45 minutes 40 seconds
*/
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
class program5{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String st=sc.nextLine();
        String end=sc.nextLine();
        sc.close();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dt1 = LocalDateTime.parse(st, dtf);
        LocalDateTime dt2 = LocalDateTime.parse(end, dtf);
        Duration dur = Duration.between(dt1, dt2).abs();
        long min = dur.toMinutes();
        long sec = dur.toSeconds() % 60;
        System.out.println(String.format("Elapsed: %s minutes %s seconds", min, sec));
    }
}
