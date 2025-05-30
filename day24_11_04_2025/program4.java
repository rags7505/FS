package day24_11_04_2025;

/* 
Two brothers want to play a game, 
The rules of the game are: one player gives two sorted lists of 
numerical elements and a number (sum). 
The opponent has to find the closest pair of elements 
to the given sum.
-> pair consists of elements from each list

Please help those brothers to develop a program, that takes 
two sorted lists as input and return a pair as output.

Input Format:
-------------
size of list_1
list_1 values
size of list_2
list_2 values
closest number

Output Format:
--------------
comma-separated pair

Sample Input-1:
---------------
4
1 4 5 7
4
10 20 30 40
32
Sample Output-1
---------------
1,30

Sample Input-2
---------------
3
2 4 6
4
5 7 11 13
15
sample output-2
---------------
2,13


*/


import java.util.*;
class program4{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int a[]=new int[n1];
        for(int i=0;i<n1;i++) a[i]=sc.nextInt();
        int n2=sc.nextInt();
        int b[]=new int[n2];
        for(int i=0;i<n2;i++) b[i]=sc.nextInt();
        int closet_sum=sc.nextInt();
        sc.close();
        int diff=Integer.MAX_VALUE;
        int ans[]=new int[2];
        int i=0,j=n2-1;
        while(i<n1 && j>=0){
            int sum=a[i]+b[j];
            if(Math.abs(closet_sum-sum)<diff){
                ans[0]=a[i];
                ans[1]=b[j];
                diff=Math.abs(closet_sum-sum);
                j--;
            }
            else{
                i++;
            }
        }
        System.out.print(ans[0]+","+ans[1]);
    }
}
