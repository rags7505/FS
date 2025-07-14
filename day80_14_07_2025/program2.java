package day80_14_07_2025;
/*
A wall clock is a complete whole circle and cover 360°.
You are given the time as HH:MM.
Your task is to return the angle between the Hours hand and Minutes hand
of the clock and the angle should not be reflex angle.

Input Format:
-------------
A string time, HH:MM

Output Format:
--------------
Print a double result, within 10^-5 of the original value.


Sample Input-1:
---------------
04:30

Sample Output-1:
----------------
45.00000


Sample Input-2:
---------------
06:15

Sample Output-2:
----------------
97.50000
*/
/* chatgpt */
import java.util.*;

public class program2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String time = sc.nextLine();
    sc.close();

    String[] parts = time.split(":");
    int hours = Integer.parseInt(parts[0]);
    int minutes = Integer.parseInt(parts[1]);

    double angle = calculateAngle(hours, minutes);
    System.out.printf("%.5f\n", angle);
  }
  public static double calculateAngle(int hours, int minutes) {
    // Normalize hours to 12-hour format
    if (hours >= 12) {
      hours -= 12;
    }

    // Calculate the angles of the hour and minute hands
    double hourAngle = (hours * 30) + (minutes * 0.5); // 30 degrees per hour + 0.5 degrees per minute
    double minuteAngle = minutes * 6; // 6 degrees per minute

    // Calculate the absolute difference between the two angles
    double angle = Math.abs(hourAngle - minuteAngle);

    // Ensure the angle is not a reflex angle
    if (angle > 180) {
      angle = 360 - angle;
    }

    return angle;
  }
}