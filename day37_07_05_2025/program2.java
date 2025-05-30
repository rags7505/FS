package day37_07_05_2025;

/*
Mr Manoj is given a special device, which performs either mutliply by 2 
and subtract by 1. He is given an intial value I.
He wants to get a value V using the special device.

Your task is to help Mr Manoj to get the value V from I, in mimimum steps.
The steps are 1). multiply by 2
2). subtract by 1. 

Input Format:
-------------
Two space separated integers, I and V

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
5 8

Sample Output-1:
----------------
2

Explanation:
------------
Perform Substraction, now I = 4
Perform Multiplication, now I = 8


Sample Input-2:
---------------
3 10

Sample Output-2:
----------------
3

Explanation:
------------
Perform Multiplication, now I = 6
Perform Substraction, now I = 5
Perform Multiplication, now I = 10
*/

import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int st=sc.nextInt();
        int t = sc.nextInt();
        sc.close();
        int ans=0;
        while(t>st){
            if(t%2==0){
                t=t/2;
            }
            else t++;
            ans++;
        }
        System.out.println(ans+st-t);
    }
}
