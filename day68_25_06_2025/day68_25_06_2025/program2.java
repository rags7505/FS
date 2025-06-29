package day68_25_06_2025;
/*
Bunny is playing with binary strings. He wants to break
a binary string B into 3 parts, of length atleast '1',
when we merge the 3 parts will result the string B.

Your task is to find the count the various forms to break 
the Binary String B into 3 parts, where each part should 
contain equal number of 1's.


Input Format:
-------------
A string S.

Output Format:
--------------
Print an integer, count the various forms to break.


Sample Input-1:
---------------
01010010

Sample Output-1:
----------------
6

Explanation:
------------
There are six forms to break S into 3 parts 
where each part contain the equal number of  1's.
01 | 01 | 0010
01 | 010 | 010
01 | 0100 | 10
010 | 1 | 0010
010 | 10 | 010
010 | 100 | 10


Sample Input-2:
---------------
010010

Sample Output-2:
----------------
0
 */
/* Someones code */
import java.util.*;

public class program2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    sc.close();
    int ones = 0;
    for (char i : s.toCharArray()) {
      if (i == '1') {
        ones++;
      }
    }
    if (ones == 0) {
      System.out.println((s.length() - 1) * (s.length() - 2) / 2);
      return;
    }
    if (ones % 3 != 0) {
      System.out.println(0);
      return;
    }
    int k = ones / 3;
    int x = 0;
    int y = 0;
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        count++;
      }
      if (count == k) {
        x++;
      } else if (count == 2 * k) {
        y++;
      }
    }
    System.out.println(x * y);
  }
}
/* claude */
/*
 import java.util.*;

public class BinaryStringSplit {
    
    public static int countWaysToSplit(String s) {
        int n = s.length();
        
        // Count total number of 1's
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }
        
        // Special case: If no 1's, we can place 2 dividers anywhere
        // We need at least 1 character in each part
        if (totalOnes == 0) {
            // Choose 2 positions out of (n-1) possible divider positions
            // This gives us (n-1) * (n-2) / 2 ways
            return (n - 1) * (n - 2) / 2;
        }
        
        // If total 1's is not divisible by 3, impossible to split equally
        if (totalOnes % 3 != 0) {
            return 0;
        }
        
        int onesPerPart = totalOnes / 3;
        
        // Find positions where we can end the first part and second part
        
        int onesCount = 0;
        int waysToEndFirst = 0;   // Number of ways to end first part
        int waysToEndSecond = 0;  // Number of ways to end second part
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                onesCount++;
            }
            
            // Count positions where first part can end (after k 1's)
            if (onesCount == onesPerPart) {
                waysToEndFirst++;
            }
            // Count positions where second part can end (after 2k 1's)
            else if (onesCount == 2 * onesPerPart) {
                waysToEndSecond++;
            }
        }
        
        return waysToEndFirst * waysToEndSecond;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        
        System.out.println(countWaysToSplit(s));
        sc.close();
    }
}
 */
