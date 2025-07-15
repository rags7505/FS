package day81_15_07_2025;
/*
Jadav Payeng, "The Forest Man of India", 
started planting the seeds in a M*N grid land.
Each cell in the grid land is planted with a seed.
After few days, some seeds grow into saplings indicates with '1',
and the rest are dead seeds indicates with '0'.

One or more saplings are connected either horizontally, vertically or diagonally 
with each other, form a sapling-group. 
There may be zero more sapling-groups in the grid land.

Jadav Payeng wants to know the biggest sapling-group in that grid land.

You are given the M * N grid, filled with 0's and 1's.
You are task is to help Jadav Payeng to find the number of saplings in 
the largest sapling-group.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers .

Output Format:
--------------
Print an integer, the number of saplings in the 
largest sapling-group in the given grid-land.

Sample Input-1:
---------------
5 4
0 0 1 1
0 0 1 0
0 1 1 0
0 1 0 0
1 1 0 0

Sample Output-1:
----------------
8


Sample Input-2:
---------------
5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0

Sample Output-2:
----------------
5
*/
import java.util.*;
class program2{
    static int count=0;
    static int[][] DIRS = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
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
        int max=0;
        boolean b[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==1 && !b[i][j]){
                    dfs(a,i,j,m,n,b);
                    max=Math.max(max,count);
                    count=0;
                }
            }
        }
        System.out.println(max);
    }
    public static void dfs(int a[][],int i,int j,int m,int n,boolean b[][]){
        if(i<0 || i>=m || j<0 || j>=n || b[i][j] || a[i][j]==0) return ;
        count++;
        b[i][j]=true;
        for (int[] dir : DIRS) {
            dfs(a, i + dir[0], j + dir[1],m,n,b);
        }
    }
}
/* All chatgpt codes */
/*
package day81_15_07_2025;

import java.util.*;
 //Optimal Solution 1: DFS with In-place Modification
 //Time Complexity: O(M * N)
 // Space Complexity: O(min(M, N)) - recursion stack depth

public class OptimalSolution1_DFS {
    private static final int[][] DIRS = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] grid = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        System.out.println(maxSaplingGroup(grid));
    }
    
    private static int maxSaplingGroup(int[][] grid) {
        int maxSize = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxSize = Math.max(maxSize, dfs(grid, i, j));
                }
            }
        }
        return maxSize;
    }
    
    private static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = -1; // Mark as visited
        int count = 1;
        
        for (int[] dir : DIRS) {
            count += dfs(grid, i + dir[0], j + dir[1]);
        }
        
        return count;
    }
}
 */
/*
package day81_15_07_2025;

import java.util.*;
 // Optimal Solution 2: Iterative BFS (No recursion stack overhead)
 //Time Complexity: O(M * N)
 //Space Complexity: O(min(M, N)) - queue size
 
public class OptimalSolution2_BFS {
    private static final int[][] DIRS = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] grid = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        System.out.println(maxSaplingGroup(grid));
    }
    
    private static int maxSaplingGroup(int[][] grid) {
        int maxSize = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxSize = Math.max(maxSize, bfs(grid, i, j));
                }
            }
        }
        return maxSize;
    }
    
    private static int bfs(int[][] grid, int startI, int startJ) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startI, startJ});
        grid[startI][startJ] = 0; // Mark as visited
        int count = 1;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1];
            
            for (int[] dir : DIRS) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 1) {
                    grid[ni][nj] = 0; // Mark as visited
                    queue.offer(new int[]{ni, nj});
                    count++;
                }
            }
        }
        
        return count;
    }
}

 */
/* DSU */
/*
package day81_15_07_2025;

import java.util.*;

// Optimal Solution 3: Union-Find (Disjoint Set Union)
 //Time Complexity: O(M * N * α(M*N)) where α is inverse Ackermann function
 //Space Complexity: O(M * N)
 // Best for multiple queries or when you need to track all components
public class OptimalSolution3_UnionFind {
    private static final int[][] DIRS = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    
    static class UnionFind {
        int[] parent, size;
        int maxSize = 0;
        
        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        
        void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return;
            
            if (size[px] < size[py]) { int temp = px; px = py; py = temp; }
            parent[py] = px;
            size[px] += size[py];
            maxSize = Math.max(maxSize, size[px]);
        }
        
        void activate(int x) {
            maxSize = Math.max(maxSize, size[find(x)]);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] grid = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        System.out.println(maxSaplingGroup(grid, m, n));
    }
    
    private static int maxSaplingGroup(int[][] grid, int m, int n) {
        UnionFind uf = new UnionFind(m * n);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int curr = i * n + j;
                    
                    // Check all 8 directions
                    for (int[] dir : DIRS) {
                        int ni = i + dir[0], nj = j + dir[1];
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                            int neighbor = ni * n + nj;
                            uf.union(curr, neighbor);
                        }
                    }
                    uf.activate(curr);
                }
            }
        }
        
        return uf.maxSize;
    }
}
*/