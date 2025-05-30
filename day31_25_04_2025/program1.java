package day31_25_04_2025;
/*
Pranav has a puzzle board filled with square boxes in the form of a grid. Some 
cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

The puzzle board has some patterns formed with boxes in it, 
the patterns may be repeated. The patterns are formed with boxes (1's) only, 
that are connected horizontally and vertically but not diagonally.

Pranav wants to find out the number of unique patterns in the board.

You are given the board in the form of a grid M*N, filled wth 0's and 1's.
Your task is to help Pranav to find the number of unique patterns in 
the puzzle board.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers [0, 1].

Output Format:
--------------
Print an integer, the number of unique patterns in the puzzle board.


Sample Input-1:
---------------
5 5
0 1 0 1 1
1 1 1 0 1
0 1 0 1 0
1 0 1 1 1
1 1 0 1 0

Sample Output-1:
----------------
3

Explanation-1:
------------
The unique patterns are as follows:
  1			1 1	    1 
1 1 1		  1 ,	1 1
  1	   ,	
   
   
Sample Input-2:
---------------
6 6
1 1 0 0 1 1
1 0 1 1 0 1
0 1 0 1 0 0
1 1 0 0 0 1
0 0 1 0 1 1
1 1 0 1 0 0

Sample Output-2:
----------------
5

Explanation-2:
------------
The unique patterns are as follows:
1 1		1 1		    1		1 1	,	1
1   ,     1 ,	    1 1 ,		
*/
import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int a[][]=new int[m][n];
        for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
            a[i][j] = sc.nextInt();
          }
        }
        sc.close();
        Set<List<Integer>> s=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              if (a[i][j] == 1) {
                List<Integer> l = new ArrayList<>();
                    fun(a, i, j,i,j ,l, m, n);
                    s.add(l);
                }
            }
        }
        System.out.println(s.size());
    }
    public static void fun(int[][]a,int i,int j,int bi,int bj,List<Integer> l,int m,int n){
        if(i<0 || j<0 || i>=m ||j>=n || a[i][j]==0) return ;
        if(a[i][j]==1){
            l.add(i-bi);
            l.add(j-bj);
        }
        a[i][j]=0;
        fun(a,i,j+1,bi,bj,l,m,n);
        fun(a,i+1,j,bi,bj,l,m,n);
        fun(a,i-1,j,bi,bj,l,m,n);
        fun(a,i,j-1,bi,bj,l,m,n);
    }
}