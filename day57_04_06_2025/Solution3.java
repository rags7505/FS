/*
Problem: 
--------
Write a Java code to identify the nth largest number without 
sorting the array


Sample Input:
-------------
4 2
3 1 5 2

Sample Output:
--------------
3

*/

import java.util.*;
class Solution3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++)
          a[i] = sc.nextInt();
        sc.close();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:a){
            pq.add(i);
            if(pq.size()>k) pq.poll();
        }
        System.out.println(pq.peek());
    }
}