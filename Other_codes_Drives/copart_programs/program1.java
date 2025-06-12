package Other_codes_Drives.copart_programs;
/*
  Question 1 – Flower Prints
Emma owns a boutique and decides to design a new gown. She wants to design the gown by printing some flowers over it. 
There are X printing blocks in total, and each block consists of some number of flowers.

your task is to Help Emma find and return the maximum number of flowers that cannot be printed on the gown, using the X printing blocks.

Any block can be used any number of times.

Note: The number of flowers on any two blocks is co-prime.

Input Specification:

 input1: An integer value X, representing the total number of blocks available
 input2: An integer array representing the number of flowers on each printing block

Output Specification:

 Return an integer value representing the maximum number of flowers that cannot be printed on the gown.

Example 1:
----------
input1: 2  
input2: [3, 5]  

Output: 7  

Explanation:
------------
Emma has two blocks: one of 3 flowers, one of 5 flowers. She cannot print 1, 2, 4, and 7 flowers using the given blocks but can print any higher integral.

Since 7 is the maximum number of flowers that cannot be printed, therefore 7 is returned as the output.

Example 2:
----------
input1: 2  
input2: [2, 5]  

Output: 3  

Explanation:
------------
Emma has two blocks:one has 2 flowers and the other has 5 flowers.she cannot print 1 flower and 3 flowers using these blocks but can print any higher integral.
since 3 is the maximum number of flowers that cannot be printed.therefore 3 is returned as output.

 */
/* CHATGPT */

import java.util.*;

public class program1 {
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
