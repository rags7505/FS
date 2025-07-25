package day87_25_07_2025;
/*
Xavier working on bitwise operations on integer elements.
He is trying to find the maximum XOR value of two elements.
You will be given a list of integers elements list[],
Your task is to findout the maximum XOR value of two elements 
from the given list.

Input Format:
-------------
Line-1: An integer N, number of elements
Line-2: N space separated integers, Arrays of elements.

Output Format:
--------------
Print an integer, max value of XOR value of two elements.


Sample Input-1:
---------------
3
5 9 14

Sample Output-1:
----------------
12

Explanation:
------------
XOR of 5 and 9


Sample Input-2:
---------------
5
34 23 62 73 35

Sample Output-2:
----------------
119


Sample Input-3:
---------------
6
12 23 31 65 76 43

Sample Output-3:
----------------
106
*/
import java.util.*;
public class program3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        sc.close();
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                max=Math.max(max,a[i]^a[j]);
            }
        }
        System.out.println(max);
    }
}