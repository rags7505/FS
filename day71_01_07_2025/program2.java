package day71_01_07_2025;
/*
A merchant has two types of idols, gold and silver.
He has arranged the idols in the form of m*n grid, 
	- the gold idols are represented as 1's 
	- the silver idols are represented as 0's.

Your task is to find the longest consecutive arrangement of gold idols, 
The arrangement can be either horizontal, vertical, diagonal or 
antidiagonal, but not the combination of these.


Input Format:
-------------
Line-1: Two space separated integers m and n, grid size.
Next m lines : n space separated integers, arrangement of idols.

Output Format:
--------------
Print an integer, longest arrangement of gold idols.


Sample Input:
------------
4 5
1 0 1 1 1
0 1 0 1 0
1 0 1 0 1
1 1 0 1 1

Sample Output:
-------------
4

Sample Input:
-------------
5 7
1 1 1 1 0 1 0
0 1 1 1 0 0 0
0 1 1 1 0 1 1
1 1 0 0 1 1 1
1 0 0 0 0 1 1

Sample Output
-------------
5

NOTE:
Solve this program using DP approach only.

*/
/* Not mine */
import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt(),n=sc.nextInt();
        int a[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        sc.close();
        int max=0;
        int dp[][][]=new int[m][n][4];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==1){
                    dp[i][j][0]=1;//down
                    dp[i][j][1]=1;//side
                    dp[i][j][2]=1;//diagonal
                    dp[i][j][3]=1;//antidiagonal
                    if(i>0){
                        dp[i][j][0]=Math.max(dp[i-1][j][0]+1,dp[i][j][0]);
                    }
                    if(j>0){
                        dp[i][j][1]=Math.max(dp[i][j-1][1]+1,dp[i][j][1]);
                    }
                    if(i>0 && j>0){
                        dp[i][j][2]=Math.max(dp[i-1][j-1][2]+1,dp[i][j][2]);
                    }
                    if(i>0 && j<n-1){
                        dp[i][j][3]=Math.max(dp[i-1][j+1][3]+1,dp[i][j][3]);
                    }
                    max=Math.max(max,dp[i][j][0]);
                    max=Math.max(max,dp[i][j][1]);
                    max=Math.max(max,dp[i][j][2]);
                    max=Math.max(max,dp[i][j][3]);
                }
            }
        }
        System.out.println(max);
    }
}