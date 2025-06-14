package day45_19_05_2025;
/*
Arjun wants to build some homes in a land of size R*C.
He wanted to construct homes in rectangular shape.
The place which is remained will be used for gradening.
Accordingly he has prepared the plan and given as
an 2d array plan[][], where 1 indicates home, and 0 indicates garden area.

A home is set of cells with value 1 in rectangular shape.
He wants to findout all the homes in the plan and store their co-ordinates in 
the following order, coords[i] = [x1,y1,x2,y2], where (x1,y1) is the starting
co-ordinate (top left corner), and (x2,y2) is the ending co-ordinate 
(bottom right corner) of i-th home.

Your task is to help Arjun to find all the homes and return the coords[][] of 
all the homes from top left corner to bottom right corner.

NOTE: No two homes are adjacent to each other in 4 directions,
(left, right, top, bottom).

Input Format:
-------------
Line-1: Two integers R and C, size of the land.
Next R lines: C space separated integers, either 0 or 1
0- represents garden area land and 1- represents the home.

Output Format:
--------------
Print 2d array, the co-ordinates of all homes.


Sample Input-1:
---------------
2 3
1 0 0
0 1 1
 
Sample Output-1:
----------------
[0, 0, 0, 0][1, 1, 1, 2]


Sample Input-2:
---------------
4 4
1 1 0 1
0 0 0 0
1 1 0 1
1 1 0 1
 
Sample Output-2:
----------------
[0, 0, 0, 1][0, 3, 0, 3][2, 0, 3, 1][2, 3, 3, 3]

*/

import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int a[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        sc.close();
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==1 && (i==0 || a[i-1][j]!=1) && (j==0 || a[i][j-1]!=1)){
                    List<Integer> l1=new ArrayList<>();
                    l1.add(i);
                    l1.add(j);
                    int k=i,p=j;
                    while(k+1<m && a[k+1][j]==1) k++;
                    while(p+1<n && a[i][p+1]==1) p++;
                    l1.add(k);
                    l1.add(p);
                    l.add(l1);
                }
            }
        }
        for(List<Integer> l1:l){
            System.out.print(l1+"");
        }
    }
}