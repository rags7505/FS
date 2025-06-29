package day40_12_05_2025;
/*
Pranav has a puzzle board filled with square boxes in the form of a grid.
Some cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

Pranav wants to find out the number of empty spaces which are completely 
surrounded by the square boxes (left, right, top, bottom) in the board.

You are given the board in the form of a grid M*N, filled wth 0's and 1's.
Your task is to help Pranav to find the number of empty groups surrounded by
the boxes in the puzzle board.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the board.
Next M lines: contains N space-separated either 0 or 1.

Output Format:
--------------
Print an integer, the number of empty spaces in the puzzle board.


Sample Input-1:
---------------
6 7
1 1 1 1 0 0 1
1 0 0 0 1 1 0
1 0 0 0 1 1 0
0 1 1 1 0 1 0
1 1 1 0 0 1 1
1 1 1 1 1 1 1

Sample Output-1:
----------------
2

Explanation:
------------
The 2 empty groups are as follows:
1st group starts at cell(1,1), 2nd group starts at cell(3,4).
The groups which are starts at cell(0,4), cell(1,6) and cell(3,0)
are not valid empty groups, because they are not completely surrounded by boxes.


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
1

Explanation:
------------
The only empty group starts at cell(1,1) is surrounded by boxes.


*/

/* My code */
import java.util.*;
class program1{
    static boolean surrounded=false;
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
        int ans=0;
        boolean b[][]=new boolean[m][n];
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(!b[i][j] && a[i][j]==0){
                    surrounded=true;
                    dfs(a,m,n,i,j,b);
                    if(surrounded) ans++;
                }
            }
        }
        System.out.println(ans);
    }
    public static void dfs(int a[][],int m,int n,int i,int j,boolean [][]b){
        if(i<0 || i>=m || j<0 || j>=n || a[i][j]==1 || b[i][j]) return;
        if(i==0 || i==m-1 || j==0 || j==n-1){
            surrounded=false;
            return;
        }
        b[i][j]=true;
        dfs(a,m,n,i+1,j,b);
        dfs(a,m,n,i-1,j,b);
        dfs(a,m,n,i,j+1,b);
        dfs(a,m,n,i,j-1,b);
    }
}
/* Claude ai, correct version of my code (claude says) */
/*
 package day40_12_05_2025;

import java.util.*;

class program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int a[][] = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        int ans = 0;
        boolean visited[][] = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && a[i][j] == 0) {
                    List<int[]> component = new ArrayList<>();
                    dfs(a, m, n, i, j, visited, component);
                    
                    // Check if this component is surrounded
                    boolean isSurrounded = true;
                    for(int[] cell : component) {
                        int x = cell[0], y = cell[1];
                        if(x == 0 || x == m-1 || y == 0 || y == n-1) {
                            isSurrounded = false;
                            break;
                        }
                    }
                    
                    if(isSurrounded) {
                        ans++;
                    }
                }
            }
        }
        
        System.out.println(ans);
    }
    
    public static void dfs(int a[][], int m, int n, int i, int j, 
                          boolean visited[][], List<int[]> component) {
        if(i < 0 || i >= m || j < 0 || j >= n || a[i][j] == 1 || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        component.add(new int[]{i, j});
        
        // Explore all 4 directions
        dfs(a, m, n, i+1, j, visited, component);
        dfs(a, m, n, i-1, j, visited, component);
        dfs(a, m, n, i, j+1, visited, component);
        dfs(a, m, n, i, j-1, visited, component);
    }
}
 */
/* More optimal code (claude) */
/*
 package day40_12_05_2025;

import java.util.*;

class OptimalSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        boolean[][] visited = new boolean[m][n];
        
        // First, mark all boundary-connected empty cells
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if((i == 0 || i == m-1 || j == 0 || j == n-1) && 
                   grid[i][j] == 0 && !visited[i][j]) {
                    markBoundaryConnected(grid, visited, i, j, m, n);
                }
            }
        }
        
        // Now count remaining unvisited empty regions
        int surroundedRegions = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && !visited[i][j]) {
                    markRegion(grid, visited, i, j, m, n);
                    surroundedRegions++;
                }
            }
        }
        
        System.out.println(surroundedRegions);
    }
    
    private static void markBoundaryConnected(int[][] grid, boolean[][] visited, 
                                            int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 1) {
            return;
        }
        
        visited[i][j] = true;
        
        markBoundaryConnected(grid, visited, i+1, j, m, n);
        markBoundaryConnected(grid, visited, i-1, j, m, n);
        markBoundaryConnected(grid, visited, i, j+1, m, n);
        markBoundaryConnected(grid, visited, i, j-1, m, n);
    }
    
    private static void markRegion(int[][] grid, boolean[][] visited, 
                                 int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 1) {
            return;
        }
        
        visited[i][j] = true;
        
        markRegion(grid, visited, i+1, j, m, n);
        markRegion(grid, visited, i-1, j, m, n);
        markRegion(grid, visited, i, j+1, m, n);
        markRegion(grid, visited, i, j-1, m, n);
    }
}
 */