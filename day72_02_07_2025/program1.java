package day72_02_07_2025;
/*
Aziz is given a set of integers SOI[], consists of both +ve and -ve integers.

Aziz wants to find the maximum sum of contiguous subset of the SOI, with a twist.

You have to perform the following operation before finding the maximum sum:
- You are allowed to replace exactly one integer X, with its square value (X*X).

Can you please help Aziz to find out the maximum sum of contiguous subset.


Input Format:
-------------
Single line of space separated integers, values of the array.

Output Format:
--------------
Print an integer value as result.


Sample Input-1:
---------------
-5 -3 1 2 -3 4 -4 3

Sample Output-1:
----------------
26

Explanation:
------------
max sum is: (-5)^2 + (-3) + 1 + 2 + (-3) + 4 = 26


Sample Input-2:
---------------
2 -2 2 2 -2 -2 2

Sample Output-2:
----------------
10

Explanation:
------------
max sum is: 2 +(-2)^2 + 2 + 2 = 10
*/

/* Optimized DP Solution (Simmu code) */

import java.util.*;

public class program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sc.close();
        int sum = 0, max = 0, sumSq = 0;
        for(int n: inp) {
            sumSq = Math.max(sum + n * n, sumSq + n);
            sum = Math.max(0, sum + n);
            max = Math.max(max, Math.max(sum, sumSq));

            // System.out.println(n + " - " + sum + " - " + sumSq + " - " + max);
        }

        System.out.println(max);
    }
}
/* Pradeep code (Brute force) */
/*
 import java.util.*;
class test{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int n=s.length;
        int []a=new int[n];
        for(int i=0;i<n;i++) a[i]=Integer.parseInt(s[i]);
        int []ans=new int[1];
        for(int i=0;i<n;i++)
        dfs(a,ans,i,0,n,0);
        System.out.println(ans[0]);
    }
    public static void dfs(int []a,int []ans,int i,int sum,int n,int ch){
        ans[0]=Math.max(ans[0],sum);
        if(i>=n) return;
        if(ch==0)dfs(a,ans,i+1,sum+(a[i]*a[i]),n,ch+1);
        dfs(a,ans,i+1,sum+a[i],n,ch);
    }
}
 */
/* Chatgpt Brute force */
/*
import java.util.*;

public class program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
          arr[i] = Integer.parseInt(input[i]);
        }
        sc.close();
        // Call the function to find the maximum sum with one square replacement
        System.out.println(maxSumWithOneSquare(arr));
    }

    public static int maxSumWithOneSquare(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        // Calculate the maximum subarray sum without any modifications
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        // Try replacing each element with its square and calculate the new max sum
        for (int i = 0; i < n; i++) {
            int original = arr[i];
            arr[i] = original * original;

            currentSum = 0;
            for (int j = 0; j < n; j++) {
                currentSum += arr[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
                if (currentSum < 0) {
                    currentSum = 0;
                }
            }

            // Restore the original value
            arr[i] = original;
        }

        return maxSum;
    }
} */
/* Simmu code i copied */
/*
 import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int a[]=new int[s.length];
        for(int i=0;i<s.length;i++){
            a[i]=Integer.parseInt(s[i]);
        }
        sc.close();
        int max=0,sum=0,sumsq=0;
        for(int n:a){
            sumsq=Math.max(sum+n*n,sumsq+n);
            sum=Math.max(0,sum+n);
            max=Math.max(max,Math.max(sum,sumsq));
        }
        System.out.println(max);
    }
}
 */