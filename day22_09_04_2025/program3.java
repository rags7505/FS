package day22_09_04_2025;

/*
There is a switch-board made by an electrician,
If you turn on any two adjacent switches, it will cause short-circuit
and damage the switch-board.

You are given N integers(only 0's and 1's), Indiactes current status of 
the switch board with N switches, where 1 indiactes switch is ON and 0 indiactes
switch is OFF. And an integer K, more number of switches to be turned ON.

Return true if and only if you can turn ON all the K switches, without causing 
any damage to switch-board. Otherwise return fasle.

Input Format:
-------------
Line-1: Two integers N and K, number of switches, and more number of switches to be ON
Line-2: N space separated integers, only 0's and 1's.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
5 1
1 0 0 0 1

Sample Output-1:
----------------
true

Sample Input-2:
---------------
5 2	
1 0 0 0 1

Sample Output-2:
----------------
flase

*/

import java.util.*;
class program3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++)
          a[i] = sc.nextInt();
        sc.close();
        if(n==1){
            if(a[0]==0 && k<=1 || k==0){
                System.out.print("true");
                return;
            }
            System.out.println(false);
            return;
        }
        int cnt=0;
        if(n!=1 && a[0]==0 && a[1]==0){
            a[0]=1;
            cnt++;
        }
        for(int i=1;i<n-1;i++){
            if(a[i]==0 && a[i-1]==0 && a[i+1]==0){
                a[i]=1;
                cnt++;
            }
        }
        if(n!=1 && a[n-1]==0 && a[n-2]==0) cnt++;
        System.out.println(cnt>=k);
    }   
}
