package day50_26_05_2025;
/*
Sharath is playing a game where there are N levels. Inorder to win the game he has to reach Nth level.

The rule book explains "In one step you can either cross one level or two levels".

Return the number of distinct possible ways to win the game.

Constraints:

    1 <= N <= 45

Input Format:
-------------
Line-1: An Integer N represents number of levels.
  
Output Format:
--------------
Print an integer.


Sample Input-1:
---------------
2
  
Sample Output-1:
----------------
2

Explanation:
------------
1. 1-level+ 1-level =2
2. 2 levels in one step.
   
Sample Input-2:
---------------
4
  
Sample Output-2:
----------------
5

Explanation:
------------
1. 1-level + 1-level + 1-level + 1-level = 4
2. 1-level + 1-level + 2-levels = 4
3. 1-level + 2-levels + 1-level = 4
4. 2-levels + 1-level + 1-level = 4
5. 2-levels + 2-levels  = 4
*/

import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        System.out.println(count(n));
    }
    public static int count(int n){
        if(n==1 || n==2) return n;
        int a[]=new int[n];
        a[0]=1;
        a[1]=2;
        for(int i=2;i<n;i++){
            a[i]=a[i-1]+a[i-2];
        }
        return a[n-1];
    }
}
/* Tejas code */
/*
 import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(count(n,dp));
    }
    public static int count(int n,int []dp){
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int one=0,two=0;
        one=check(n-1,dp);
        two=check(n-2,dp);
        return dp[n]=one+two;
    }
}
*/
/* Simmu code */
/*
 import java.util.*;

public class DSAprogram1 {
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();
        jpGame(n, 0);
        System.out.println(res);
    }

    private static void jpGame(int n, int i) {
        if(i >= n) {
            if(n == i) res++;
            return;
        }

        jpGame(n, i + 1);
        jpGame(n, i + 2);
    }
}
*/