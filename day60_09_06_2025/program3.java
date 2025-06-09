package day60_09_06_2025;
/*
Liam is a textile artist creating a patchwork quilt. He has X types of uniquely 
sized fabric patches. Each patch has a specific number of design squares on it. 
Liam wants to create a perfect square pattern on the quilt using these patches. 
He can use any number of patches of each type.

However, there are some square counts that he cannot achieve with these patches. 
Your task is to help Liam figure out the maximum number of design squares that 
cannot be formed using any combination of the available patch types.

Note: The number of design squares on any two different patches is co-prime.

Input Format:
-------------
input1: An integer X representing the number of different patch types available.
input2: An integer array representing the number of design squares each patch type contains.

Output Fromat:
--------------
Return an integer value representing the maximum number of design squares that 
cannot be created on the quilt using the given patch types.

Sample Input:
-------------
2
3 5

Sample Output:
--------------
7

Explanation:
------------
Using patches with 3 and 5 design squares, the largest number of design squares 
that cannot be formed by any combination is 7.


Sample Input:
-------------
4
3 7 17 29

Sample Output:
--------------
11
*/

/* CHATGPT */

import java.util.*;

public class program3 {
    public static int maxUnreachable(int[] patches) {
        int maxCheck = 100000;  // Safe upper bound
        boolean[] dp = new boolean[maxCheck];
        dp[0] = true;

        for (int patch : patches) {
            for (int i = patch; i < maxCheck; i++) {
                if (dp[i - patch]) {
                    dp[i] = true;
                }
            }
        }

        // Find largest false before a long streak of trues
        int consecutive = 0;
        int result = 0;
        for (int i = 1; i < maxCheck; i++) {
            if (!dp[i]) {
                result = i;
                consecutive = 0;
            } else {
                consecutive++;
                if (consecutive >= 100) break; // All numbers beyond this are reachable
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // Number of patch types
        sc.close();
        int[] patches = new int[x];
        for (int i = 0; i < x; i++) {
            patches[i] = sc.nextInt();
        }

        // Special case: only 2 patch types => use Frobenius formula
        if (x == 2) {
            int a = patches[0], b = patches[1];
            System.out.println(a * b - a - b);
        } else {
            System.out.println(maxUnreachable(patches));
        }
    }
}

/* Best to understand */
/*
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i] = sc.nextInt();
        boolean[] dp = new boolean[100];
        dp[0] = true;
        for(int x : a){
            for(int i=0;i<dp.length;i++){
                if(dp[i] && i+x < dp.length) dp[i+x] = true;
            }
        }
        int max = 0;
        for(int i=0;i<dp.length;i++){
            if(!dp[i]) max = i;
        }
        System.out.println(max);
    }
}
*/