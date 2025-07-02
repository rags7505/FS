package day72_02_07_2025;
/*
The bomb grid is filled with danger values, with both positive and negative integers.
positive means you will lose power of grid[i][j], 
negative means you will gain power of grid[i][j].

Naresh wants to cross the bridge, with the minimum loss of power.
He can cross the grid in the following way:
	- He can start at any bomb cell in the first row.
	- He can step on the next bomb cell in the next row that 
	  is either directly below of the current cell or diagonally left/right. 
	- Specifically, the next bomb cell from position grid(i, j) will be grid(i+1,j-1),
	(i + 1, j) , or (i + 1, j + 1) .

Can you help Naresh to lose the minimum power after crossing the bomb grid.

Input Format:
-------------
Line-1: An integer N, size of N*N grid 
Next N lines: N space separated  integers, values in the grid.

Output Format:
--------------
Print an integer, minimum sum of TopDown path.


Sample Input-1:
---------------
3
1 3 2
5 4 6
9 8 7

Sample Output-1:
----------------
12

Explanation:
-------------
Minimum lose of power is as follows:
start from bomb cell	1 -> 4 -> 7
Total lose is 12.


Sample Input-2:
---------------
3
32 10 23
-15 14 -16
19 -18 17

Sample Output-2:
----------------
-24

Explanation:
-------------
Minimum lose of power is as follows:
start from bomb cell	10 -> -16 -> -18
Total lose is -24.
 */
import java.util.*;
class program2{
    static int min=Integer.MAX_VALUE;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        sc.close();
        for(int j=0;j<n;j++){
            dfs(1,j,n,a,a[0][j]);
            dfs(1,j-1,n,a,a[0][j]);
            dfs(1,j+1,n,a,a[0][j]);
        }
        System.out.println(min);
    }
    public static void dfs(int i,int j,int n,int [][]a,int val){
        // System.out.println(i+" "+j+" "+val+" "+min);
        if(i==n){
            min=Math.min(min,val);
            return;
        }
        if( j==n || j<0) return ;
        dfs(i+1,j,n,a,val+a[i][j]);
        dfs(i+1,j-1,n,a,val+a[i][j]);
        dfs(i+1,j+1,n,a,val+a[i][j]);
    }
}
/* Tejas code 3D DP */
/*
 import java.util.*;

class Solution {
    static int n;

    private static int check(int r, int c, int start, int[][] arr, Integer[][][] dp) {
        if (r < 0 || c < 0 || r >= n || c >= n) {
            return 999999;
        }

        if (r == n - 1) {
            return arr[r][c]; // Return the value at the bottom row
        }

        if (dp[r][c][start] != null)
            return dp[r][c][start];

        int down = arr[r][c] + check(r + 1, c, start, arr, dp);
        int dia1 = arr[r][c] + check(r + 1, c + 1, start, arr, dp);
        int dia2 = arr[r][c] + check(r + 1, c - 1, start, arr, dp);
        return dp[r][c][start] = Math.min(down, Math.min(dia1, dia2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Integer[][][] dp = new Integer[n][n][n];

        int result = Integer.MAX_VALUE;
        for (int cols = 0; cols < n; cols++) {
            result = Math.min(result, check(0, cols, cols, arr, dp));
        }

        System.out.println(result);
    }
}
 */
/*simmu code 2D DP */
/*
import java.util.*;

public class DSAprogram2 {
    private static int sol(int[][] inp) {
        int n = inp.length;
        int[][] dp = new int[n][n];
        dp[0] = inp[0];

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if(j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
                }

                dp[i][j] += inp[i][j];
            }
        }

        int min = dp[n - 1][0];
        for(int i: dp[n - 1]) min = Math.min(min, i);

        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] inp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                inp[i][j] = sc.nextInt();
            }
        }

        System.out.println(sol(inp));
    }
}
 */