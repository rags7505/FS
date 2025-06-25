package day67_24_06_2025;
/*
Gunith is interested in series and sequence problems in Maths.
Gunith is given an array A of integers, he wants to find out 
a Sequence, which is long and subsequence of given array.

Subsequence AS is the list AS[i], AS[i1], AS[i2], .... AS[ik], from the array, 
where 0 <= i< i1 < i2 < ..<ik < A.length

The sequence S has to follow this rule, S[i+1] - S[i] are all the same value 
(for 0 <= i < S.length - 1 ), and Sequence S can be formed from A

Find out the Max possible length of the Longest Sequence.

Input Format:
-------------
Line-1 -> An integer N, number of array elements
Line-2 -> N space separated integers, elements of the array.

Output Format:
--------------
Print an integer as your result.


Sample Input-1:
---------------
4
2 6 10 14

Sample Output-1:
----------------
4


Sample Input-2:
---------------
7
2 5 6 8 10 11 14

Sample Output-2:
----------------
5

Explanation:
------------
The longest possible arithmetic series is 2 5 8 11 14.
*/

/* Chatgpt */
/*
 import java.util.*;

public class LongestArithmeticSubsequence {
    public static int longestArithmeticSubsequence(int[] A) {
        int n = A.length;
        if (n <= 1) return n;

        int maxLen = 1;
        // Array of HashMaps to track dp[i][diff]
        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                int len = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].put(diff, len);
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println(longestArithmeticSubsequence(A));
    }
}
 */
/* Chatgpt Brute Force */
/*
 import java.util.*;

public class Main {
    public static int bruteForceLongestArithmeticSubsequence(int[] A) {
        int n = A.length;
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = A[j] - A[i];
                int count = 2;
                int last = A[j];

                // Check how many more numbers continue the same diff
                for (int k = j + 1; k < n; k++) {
                    if (A[k] - last == diff) {
                        count++;
                        last = A[k];
                    }
                }

                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println(bruteForceLongestArithmeticSubsequence(A));
    }
}
 */
/* Someones code */
import java.util.*;
class program1{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    sc.close();
    System.out.println(check(a, 0, -1, -1));
  }

  public static int check(int a[], int i, int prev, int diff) {
    if (i >= a.length) {
      return 0;
    }
    int max = 0;
    if (prev == -1) {
      max = 1 + check(a, i + 1, i, -1);
    }
    else {
      int currentDiff = a[i] - a[prev];
      if (diff == -1 || currentDiff == diff) {
        max = 1 + check(a, i + 1, i, currentDiff);
      }
    }
    int skip = check(a, i + 1, prev, diff);
    return Math.max(max, skip);
    }
}