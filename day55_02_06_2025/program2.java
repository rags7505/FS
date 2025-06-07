package day55_02_06_2025;
/*
You are controlling a battlefield represented by an m x n grid. 
Each cell on this grid can be one of the following:

- A reinforced barrier ('B'), blocking your laser.
- An enemy drone ('D'), your target.
- An open cell ('0'), where you can position your robot to fire.

When your robot fires its powerful laser from an open cell, 
the beam destroys all enemy drones in the same row and column 
until the beam hits a barrier ('B'). The barrier completely stops 
the laser, protecting anything behind it.

Your goal is to identify the best position (open cell) to place 
your robot so that firing the laser destroys the maximum number 
of enemy drones in a single shot. Return this maximum number.

Input format:
-------------
Line 1: Two space separated integers, represents m & n
Next M lines: each row of battlefield


Output format:
--------------
An integer, maximum number of enemy drones destroyed in a single shot.

Example 1:
----------
input=
3 4
0 D 0 0
D 0 B D
0 D 0 0

Output=
3

Explanation: placing robot at battlefield[1][1] destroys 3 enemy drones in a
single shot.

Example 2:
----------
3 3
B B B
0 0 0
D D D

Output=
1


Constraints:
- 1 <= m, n <= 500
- battlefield[i][j] is either 'B', 'D', or '0'.

*/
import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        char a[][]=new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.next().charAt(0);
            }
        }
        sc.close();
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]=='0'){
                    int[] ans1=new int[1];
                    checkRow(i,j,ans1,a);
                    checkCol(i,j,ans1,a);
                    ans=Math.max(ans,ans1[0]);
                }
            }
        }
        System.out.print(ans);
    }
    public static void checkCol(int i,int j,int a1[],char a[][]){
        int row=i-1;
        while(row>=0 && a[row][j]!='B'){
            if(a[row][j]=='D') a1[0]++;
            row--;
        }
        while(i<a.length && a[i][j]!='B'){
            if(a[i][j]=='D') a1[0]++;
            i++;
        }
    }
    public static void checkRow(int i,int j,int a1[],char a[][]){
        int col=j-1;
        while(col>=0 && a[i][col]!='B'){
            if(a[i][col]=='D') a1[0]++;
            col--;
        }
        while(j<a[0].length && a[i][j]!='B'){
            if(a[i][j]=='D') a1[0]++;
            j++;
        }
    }
}