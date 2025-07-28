package day88_28_07_2025;
/*
The laser show at the Lumbini Park is something not to be missed.
But, as per govt rule they have to follow COVID-19 restrictions.
The management planning to guide the audience to sit in the seats
that maximizes the distance to the closest person, in order to
practice the social distance in the auditorium.

Please help usher to guide the audience to sit in a seat by following few rules:

- There are N seats in a single row, seats are numbered from 0 to N-1.
- Maximize the distance from person to the closest person.
- If there are multiple seats with similar distance, they sit in the seat with the lowest number.
- First person always sit in seat number 0.
- If a person leaves the auditorium from a seat, please consider that the seat is vacant

Create a class Auditorium and two functions in it.
1. int seat(): represent the seat number of audience to sit.
2. void leave(int s): person leaves the auditorium from a seat number 's'.

Input Format:
----------------
Line-1 -> two integers N and P, Number of seats N, Number of Operations P
P lines of input -> each line contains funtion number and parameter list (if required).

Output Format:
------------------
Print the alloted seat numbers in one line as output.


Sample Input-1:
-------------------
10 6
1
1
1
1
2 4
1

Sample Output-1:
---------------------
0 9 4 2 5

NOTE:
-----
In the sample input:
    - option 1 indicates, calling "int seat()" method.
    - option 2 indicates, calling "void leave(seat_num)" method.
*/
/* chatgpt */
import java.util.*;

class Auditorium {
    private TreeSet<Integer> occupied;
    private int N;

    public Auditorium(int N) {
        this.N = N;
        occupied = new TreeSet<>();
    }

    public int seat() {
        // First person
        if (occupied.size() == 0) {
            occupied.add(0);
            return 0;
        }

        int maxDist = 0;
        int seatToSit = 0;
        int prev = -1;

        for (int seat : occupied) {
            if (prev == -1) {
                // Check distance from 0 to first occupied seat
                if (seat > 0) {
                    maxDist = seat;
                    seatToSit = 0;
                }
            } else {
                // Check middle between prev and current seat
                int mid = (prev + seat) / 2;
                int dist = (seat - prev) / 2;
                if (dist > maxDist) {
                    maxDist = dist;
                    seatToSit = mid;
                }
            }
            prev = seat;
        }

        // Check distance from last occupied seat to N-1
        if (N - 1 - occupied.last() > maxDist) {
            seatToSit = N - 1;
        }

        occupied.add(seatToSit);
        return seatToSit;
    }

    public void leave(int seatNum) {
        occupied.remove(seatNum);
    }
}


public class program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Number of seats
        int P = sc.nextInt(); // Number of operations
        Auditorium auditorium = new Auditorium(N);
        for (int i = 0; i < P; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                System.out.print(auditorium.seat() + " ");
            } else if (op == 2) {
                int seatNum = sc.nextInt();
                auditorium.leave(seatNum);
            }
        }
        sc.close();
    }
}