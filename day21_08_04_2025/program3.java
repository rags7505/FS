package day21_08_04_2025;

/*
There are N laddus placed in a row. Each laddu has an ID printed on it.
IDs are printed in ascending order like as follows: S, S+1, S+2,...,E-2, E-1, E, 
where N = E-S+1.

Chota Bheem ate K number of laddus randomly from the row. You are given 
three integers K, S, E, and the IDs of the laddus eaten given as eaten[] array
in ascending order.

Your task is to find the ranges of IDs on the laddus remained in the row,
and print all the ranges as shown in the samples.

For example:
Given the IDs of the laddus eaten: [ 1, 2, 4, 51, 52, 53, 92, 93, 94, 95]
and S=1 E=100. The ranges of IDs of laddus which are remained in the row: 
[3, 5:50, 54:91, 96:100]

Note: The array eaten[] contains no duplicates.

Input Format:
-------------
Line-1: Three space separated integers, K, S and E.
Line-2: K space separated integers in sorted order, eaten[] IDs of laddus eaten.

Output Format:
--------------
Print the list of ID ranges in the row.


Sample Input-1:
---------------
9 0 20
0 1 2 3 4 5 8 9 10

Sample Output-1:
----------------
[6:7, 11:20]


Sample Input-2:
---------------
14 -50 50
-48 -47 -35 -20 -19 0 21 22 23 25 26 39 43 47

Sample Output-2:
----------------
[-50:-49, -46:-36, -34:-21, -18:-1, 1:20, 24, 27:38, 40:42, 44:46, 48:50]

*/

import java.util.*;
class program3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int s=sc.nextInt();
        int e=sc.nextInt();
        int a[]=new int[k];
        for (int i = 0; i < k; i++)
          a[i] = sc.nextInt();
        sc.close();
        List<String> l=new ArrayList<>();
        if(s!=a[0]){
            if(s+1==a[0]) l.add(""+s);
            else l.add(s+":"+(a[0]-1));
        }
        for(int i=1;i<k;i++){
            if(a[i]!=a[i-1]+1){
                if(a[i-1]+1==a[i]-1) l.add(""+(a[i]-1));
                else{
                    l.add((a[i-1]+1)+":"+(a[i]-1));
                }
            }
        }
        if(a[k-1]!=e){
            if(e-1==a[k-1]) l.add(""+e);
            else l.add(a[k-1]+1+":"+e);
        }
        System.out.print(l);
    }
}
