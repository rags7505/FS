package day69_25_06_2025;
/*
For Siddarth's Birthday his friends planned cake cutting. On top of the cake
there are two lines of candles, all the candles with different heights. The lines 
are parallel lines, line-P and line-Q .

Siddarth has to blow all the candles in one go. So, he can swap one candle at a 
time, from P and Q and the position of the candles in their line should be same.

At the end of the swaps, The candles in set P and set Q, 
should be in ascending order of their heights.

You will be heights of the candles initially in P and Q, after placing in
parallel lines.

Your task is to find the minimum number of swaps required
to arrange the candles in P and Q in ascending orer.

Note: It is guaranteed that the answer is always possible.

Input Format:
-------------
Line-1: An integer N, num of candles in P and Q.
Line-2: N space separated integers, heights of the candles in Line-P.
Line-3: N space separated integers, heights of the candles in Line-Q.

Output Format:
--------------
Print an integer, minimum number of swaps required.


Sample Input-1:
---------------
4
1 3 5 4 (1,1
1 2 3 7

Sample Output-1:
----------------
1

Explanation:
------------
Swap the 4th candle in P and Q. 
Then the heights of the candles in P = [1, 3, 5, 7],  Q = [1, 2, 3, 4]
Both are in ascending order.


Sample Input-2:
---------------
7
1 3 5 8 14 13 14
2 5 7 6 11 15 16

Sample Output-2:
----------------
2

Explanation:
------------
Swap the 4th, 5th candles in P and Q. 
Then the heights of the candles in 
P = [1, 3, 5, 6, 11, 13, 14],  
Q = [2, 5, 7, 8, 14, 15, 16]
Both are in ascending order.
=================================
*/
/* Someones code */
import java.util.*;

public class program1 {
     public static int minSwapsToSort(int[] P, int[] Q) {
        int n = P.length;
        int[] swap = new int[n];
        int[] noSwap = new int[n];

        Arrays.fill(swap, Integer.MAX_VALUE);
        Arrays.fill(noSwap, Integer.MAX_VALUE);

        swap[0] = 1;
        noSwap[0] = 0; 

        for (int i = 1; i < n; i++) {
            if (P[i] > P[i - 1] && Q[i] > Q[i - 1]) {
                noSwap[i] = noSwap[i - 1];
                swap[i] = swap[i - 1] + 1;
            }

            if (P[i] > Q[i - 1] && Q[i] > P[i - 1]) {
                noSwap[i] = Math.min(noSwap[i], swap[i - 1]);
                swap[i] = Math.min(swap[i], noSwap[i - 1] + 1);
            }
        }

        return Math.min(swap[n - 1], noSwap[n - 1]);
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] P = new int [n];
        int [] Q = new int [n];
        for(int i = 0 ; i < n ; i++){
            P[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
          Q[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(minSwapsToSort(P, Q));
    }
}
/* claude */
/*
 import java.util.*;

public class CandleSwap {
    
    public static int minSwapsToSort(int[] P, int[] Q) {
        int n = P.length;
        
        // dp[i][0] = min swaps to sort first i+1 elements without swapping at position i
        // dp[i][1] = min swaps to sort first i+1 elements with swapping at position i
        int[][] dp = new int[n][2];
        
        // Initialize first position
        dp[0][0] = 0;  // No swap at position 0
        dp[0][1] = 1;  // Swap at position 0
        
        for (int i = 1; i < n; i++) {
            // Initialize with large values
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
            
            // Case 1: Both arrays are naturally sorted at position i
            // P[i] > P[i-1] and Q[i] > Q[i-1]
            if (P[i] > P[i-1] && Q[i] > Q[i-1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i-1][0]);     // Don't swap at i, didn't swap at i-1
                dp[i][1] = Math.min(dp[i][1], dp[i-1][1] + 1); // Swap at i, swapped at i-1
            }
            
            // Case 2: Arrays are sorted if we swap at position i
            // P[i] > Q[i-1] and Q[i] > P[i-1]
            if (P[i] > Q[i-1] && Q[i] > P[i-1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i-1][1]);     // Don't swap at i, swapped at i-1
                dp[i][1] = Math.min(dp[i][1], dp[i-1][0] + 1); // Swap at i, didn't swap at i-1
            }
        }
        
        return Math.min(dp[n-1][0], dp[n-1][1]);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] P = new int[n];
        int[] Q = new int[n];
        
        for (int i = 0; i < n; i++) {
            P[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            Q[i] = sc.nextInt();
        }
        
        System.out.println(minSwapsToSort(P, Q));
        sc.close();
    }
}
 */