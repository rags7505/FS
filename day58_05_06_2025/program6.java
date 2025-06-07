package day58_05_06_2025;

/*
Write a java program, for given a birthdate in yyyy-MM-dd format, calculate the person’s current age in years, months, and days.

Input:
------
1990-05-25

Output:
-------
Age: 34 years, 0 months, 10 days
*/
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
class program6{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dt = LocalDate.parse(s, dtf);
        System.out.println(dt);
        Period p = Period.between(dt, LocalDate.now());
        System.out.println(String.format("Age: %d years, %d months, %d days", p.getYears(), p.getMonths(), p.getDays()));
    }
}