package Other_codes_Drives.copart_programs;
/*
 Question 2 – LCS With Palindrome

Sam loves palindromes. One day, his father comes and gives him two strings. Sam is interested in finding the length of the longest common palindrome subsequence and wants your help with it.

Input Specification:
-------------------
 input1: First string which is given by his father
 input2: Second string which is given by his father

Output Specification:

 Return the length of the longest common palindrome subsequence.

Example 1:
----------
input1: adfa  
input2: aagh

Output: 2  


Explanation: 
------------
The only common palindrome subsequence is aa so length is 2.

Example 2:
----------
input1: acbda  
input2: fgaba  
Output: 3  


Explanation: The longest common palindrome subsequence is aba so length is 3.

 */

/* Tejas first code */

/* 

import java.util.*;

class Solution {
    private static int check(String s1, String s2, int index1, int index2, int[][] dp) {
        if (index1 == 0 || index2 == 0)
            return 0;
        if (dp[index1][index2] != -1)
            return dp[index1][index2];

        if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
            return dp[index1][index2] = 1 + check(s1, s2, index1 - 1, index2 - 1, dp);

        return dp[index1][index2] = Math.max(check(s1, s2, index1 - 1, index2, dp),
                check(s1, s2, index1, index2 - 1, dp));

    }

    private static int checkPalindrome(String c) {
        char[] s = c.toCharArray();
        int n = s.length;
        String ans = "";
        int a = 0;
        int maxLen = -1;
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n) {
                if (s[l] == s[r]) {
                    l--;
                    r++;
                } else
                    break;
            }

            a = r - l;
            ans = c.substring(l + 1, r);
            maxLen = Math.max(a - 1, maxLen);

            l = i;
            r = i + 1;
            while (l >= 0 && r < n) {
                if (s[l] == s[r]) {
                    l--;
                    r++;
                } else
                    break;
            }

            a = r - l;
            ans = c.substring(l + 1, r);

            maxLen = Math.max(a - 1, maxLen);

        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int res = check(s1, s2, s1.length(), s2.length(), dp);
        // System.out.println("res=" + res);
        if (dp[s1.length()][s2.length()] <= 1) {
            System.out.println(dp[s1.length()][s2.length()]);
            return;
        }

        // for (int[] row : dp)
        //     System.out.println(Arrays.toString(row));

        StringBuilder sb = new StringBuilder();
        int i = s1.length();
        int j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }
        sb.reverse();

        // System.out.println("Longest Common Subsequence: " + sb.toString());
        // System.out.println(checkPalindrome(sb.toString()).length());
        System.out.println(checkPalindrome(sb.toString()));
    }
}
*/

/* Worst code Backtracking , will not get submitted */
/* 
import java.util.*;
class program1{
    static int max=0;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        sc.close();
        backtrack(s1,s2,0,0,new StringBuilder());
        System.out.println(max);
    }
    public static void backtrack(String s1,String s2,int i,int j,StringBuilder sb){
        if(i==s1.length() || j==s2.length()){
            if(palindrome(sb)){
                max=Math.max(max,sb.length());
            }
            return;
        }
        if(s1.charAt(i)==s2.charAt(j)){
            sb.append(s1.charAt(i));
            backtrack(s1,s2,i+1,j+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        backtrack(s1,s2,i+1,j,sb);
        backtrack(s1,s2,i,j+1,sb);
    }
    public static boolean palindrome(StringBuilder sb){
        StringBuilder s=new StringBuilder(sb.toString());
        return s.toString().equals(sb.reverse().toString());
    }
}
*/


import java.util.*;

public class program2 {

  // Function to compute the LCS DP table
  private static int[][] computeLCS(String s1, String s2) {
    int n = s1.length(), m = s2.length();
    int[][] dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp;
  }

  // Function to reconstruct the LCS string from the DP table
  private static String getLCSString(String s1, String s2, int[][] dp) {
    StringBuilder lcs = new StringBuilder();
    int i = s1.length(), j = s2.length();

    while (i > 0 && j > 0) {
      if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        lcs.append(s1.charAt(i - 1));
        i--;
        j--;
      } else if (dp[i - 1][j] >= dp[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }
    return lcs.reverse().toString();
  }

  // Your preferred method: Find the longest palindromic substring using center expansion
  public static String longestPalindrome(String input) {
    char[] chars = input.toCharArray();
    int length = chars.length;
    String longestPalindromicSubstring = "";
    int maxLength = 0;

    for (int center = 0; center < length; center++) {
      // Odd length palindrome
      int left = center, right = center;
      while (left >= 0 && right < length && chars[left] == chars[right]) {
        left--;
        right++;
      }
      if (right - left - 1 > maxLength) {
        maxLength = right - left - 1;
        longestPalindromicSubstring = input.substring(left + 1, right);
      }

      // Even length palindrome
      left = center;
      right = center + 1;
      while (left >= 0 && right < length && chars[left] == chars[right]) {
        left--;
        right++;
      }
      if (right - left - 1 > maxLength) {
        maxLength = right - left - 1;
        longestPalindromicSubstring = input.substring(left + 1, right);
      }
    }

    return longestPalindromicSubstring;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1 = sc.next();
    String s2 = sc.next();
    sc.close();
    int[][] dp = computeLCS(s1, s2);
    String lcs = getLCSString(s1, s2, dp);

    if (lcs.length() <= 1) {
      System.out.println(lcs.length());
    } else {
      String palindrome = longestPalindrome(lcs);
      System.out.println(palindrome.length());
    }
  }
}
/*
Function to find the longest palindromic subsequence length After finding the LCS
private static int longestPalindromicSubsequence(String str) {
  int n = str.length();
  int[][] dp = new int[n][n];

  for (int i = n - 1; i >= 0; i--) {
      dp[i][i] = 1;
      for (int j = i + 1; j < n; j++) {
          if (str.charAt(i) == str.charAt(j)) {
              dp[i][j] = 2 + dp[i + 1][j - 1];
          } else {
              dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
          }
      }
  }

  return dp[0][n - 1];
}  */


