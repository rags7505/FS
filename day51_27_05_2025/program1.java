package day51_27_05_2025;
/*
You are a stealthy archaeologist exploring a circular ring of ancient tombs located deep within a jungle. Each tomb holds a certain number of precious artifacts. However, these tombs are protected by an ancient magical curse: if you disturb two adjacent tombs during the same night, the entire ring activates a trap that seals you in forever.

The tombs are arranged in a perfect circle, meaning the first tomb is adjacent to the last. You must plan your artifact retrieval carefully to maximize the number of artifacts collected in a single night without triggering the curse.

Given an integer array  artifacts  representing the number of artifacts in each tomb, return the   maximum   number of artifacts you can collect without disturbing any two adjacent tombs on the same night.

Example 1:  
Input:
2 4 3
Output:  
4   

Explanation:   You cannot loot tomb 1 (artifacts = 2) and tomb 3 (artifacts = 3), as they are adjacent in a circular setup.

Example 2:  
Input:
1 2 3 1
Output:  
4

Explanation:   You can loot tomb 1 (1 artifact) and tomb 3 (3 artifacts) without breaking the ancient rule.  
Total = 1 + 3 = 4 artifacts.

Example 3:  
Input:
1 2 3
Output:  
3 

Constraints:  
-  1 <= artifacts.length <= 100 
-  0 <= artifacts[i] <= 1000 
*/

import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        sc.close();
        int n=s.length;
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(s[i]);
        }
        int dp1[]=new int[n];
        int dp2[]=new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        System.out.println(Math.max(check(0,a,n-2,dp1),check(1,a,n-1,dp2)));
    }
    public static int check(int i,int []a,int n,int dp[]){
        if(i>n) return 0;
        if(dp[i]!=-1) return dp[i];
        int ans1=check(i+1,a,n,dp);
        int ans2=a[i]+check(i+2,a,n,dp);
        return dp[i]=Math.max(ans1,ans2);
    }
}