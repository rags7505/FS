package day23_10_04_2025;

/*
MotorSport Ltd hosting a Racing Championship. 
Ajith is participating in car races. Each race start and end in perticular time intervals.

You are given an array of racing time intervals consisting of
start and end times [[s1,e1],[s2,e2],...] (s < e ) of N races, in which Ajith has to participate.
Your task is to determine whether Ajith can participate in all the races or not.

NOTE: If a race starts at time 'a' ends at time 'b', 
another race can start at 'b'.

Input Format:
-------------
Line-1: An integer N, number of races Ajith has to participate.
Next N lines: Two space separated integers, start and end time of each race.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
3
0 30
5 10
15 20

Sample Output-1:
----------------
false

Sample Input-2:
---------------
3
0 10
15 25
30 35

Sample Output-2:
----------------
true

*/

import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[][]=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
        }
        sc.close();
        Arrays.sort(a,(b,c)->b[0]-c[0]);
        boolean overlap=false;
        int prev=a[0][1];
        for(int i=1;i<n;i++){
            if(prev>a[i][0]){
                overlap=true;
                break;
            }
            prev=a[i][1];
        }
        System.out.print(!overlap);
    }
}
