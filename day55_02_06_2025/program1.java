package day55_02_06_2025;
/*
You are the chief designer for a futuristic garden trail, where there are n
consecutive decorative light posts along a path. Each post can be illuminated 
with one of three distinct colors: Crimson, Azure, or Emerald. The cost to 
illuminate each post with a particular color depends on the post's location and
the energy circuit required.

However, to maintain aesthetic harmony and prevent power circuit overloads, no 
two adjacent posts can have the same light color.

The cost of illuminating each post with each color is provided in a 2D array
costs, where costs[i][0] is the cost of lighting post i with Crimson, 
costs[i][1] with Azure, and costs[i][2] with Emerald.

Your goal is to find the minimum total cost to light up all posts in such a way 
that no two neighboring posts have the same color.

Input Format:
-------------
Line-1: An integer N, number of post.
Next N lines: 3 space separated integers, cost of illuminating the posts.

Output Format:
--------------
Print an integer, minimum total cost to light up all posts.


Sample Input:
---------------
3
17 2 17
16 4 5
14 3 19

Sample Output:
----------------
10

Explanation: 
------------
1st post is with Azure, 2nd post is with Emerald,
3rd post is with Crimson.
Minimum cost: 2 + 5 + 3 = 10.

*/

import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[][]=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                a[i][j]=sc.nextInt();
            }
        }
        sc.close();
        int ans1=check(1,a,0,a[0][0]);
        int ans2=check(1,a,1,a[0][1]);
        int ans3=check(1,a,2,a[0][2]);
        System.out.println(Math.min(ans1,Math.min(ans2,ans3)));
    }
    public static int check(int i,int [][]a,int chose,int ans){
        if(i>=a.length) return ans;
        int ans1=0,ans2=0;
        if(chose==0){
            ans1=check(i+1,a,1,ans+a[i][1]);
            ans2=check(i+1,a,2,ans+a[i][2]);
        }
        else if(chose==1){
            ans1=check(i+1,a,0,ans+a[i][0]);
            ans2=check(i+1,a,2,ans+a[i][2]);
        }
        else{
            ans1=check(i+1,a,0,ans+a[i][0]);
            ans2=check(i+1,a,1,ans+a[i][1]);
        }
        return Math.min(ans1,ans2);
    }
}
/* Tejas code */
/*
 * import java.util.*;
class Solution{
    private static int check(int row, int[][] arr, int lastused, int[][] dp){
        if(row<0){
            return 0;
        }
        if(dp[row][lastused]!=-1) return dp[row][lastused];
        int c1=Integer.MAX_VALUE;
        int c2=Integer.MAX_VALUE;
        int c3=Integer.MAX_VALUE;
        if(lastused!=1) c1=arr[row][0]+check(row-1,arr,1,dp);
        if(lastused!=2) c2=arr[row][1]+check(row-1,arr,2,dp);
        if(lastused!=3) c3=arr[row][2]+check(row-1,arr,3,dp);
        
        
        return dp[row][lastused]=Math.min(Math.min(c1,c2),c3);
        
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++) for(int j=0;j<3;j++) arr[i][j]=sc.nextInt();
        int[][] dp = new int[n][4];
        for(int[] row : dp) Arrays.fill(row,-1);
        System.out.println(check(n-1,arr,0,dp));
    }
}
 */