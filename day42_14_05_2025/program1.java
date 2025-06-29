package day42_14_05_2025;
/*
 You are given two strings 'Org' and 'Sub' where Sub is a subsequence of Org. 
You aer given a list of R indices[] (Unique indices), and you need to delete 
P letters from the given string 'Org', with the following conditions:
    - You need to delete the first P letters from strin 'Org'in the given order
      of indices[] only.
    - After deleting P letters, the string 'Sub' should be subsequence of 'Org'.
      Where, 0 <= i < P and P < R.
     
Your task is to maximixe the value of P such that 'Sub' is still a subsequence 
of 'Org' after the deletion of letters, and return P.

Input Format:
-------------
Line-1: Two space seperated strings, Original and Sub
Line-2: An integer, R, number of indices.
Line-3: R space separated integers, indices[].

Output Format:
--------------
Print an integer, the maximum value of P.


Sample Input-1:
---------------
pqrprq pr
3
3 1 0

Sample Output-1:
----------------
2

Explanation:
------------
After deleting 2 letters at indices 3 and 1, "pqrprq" becomes "prrq".
"pq" is a subsequence of "prrq".
If you delete 3 letters at indices 3, 1, and 0, "pqrprq" becomes "rrq", 
and "pq" is not a subsequence of "rrq".
Hence, the maximum P is 2.

Sample Input-2:
---------------
pqrqssss pqrs
6
3 2 1 4 5 6

Sample Output-2:
----------------
1

Explanation: 
------------
After deleting 1 letter at index 3, "pqrqssss" becomes "pqrssss".
"pqrs" is a subsequence of "pqrssss".

 */

/* chatgpt */
/*
import java.util.*;
class program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        String org = str[0];
        String sub = str[1];
        int r = sc.nextInt();
        int[] indices = new int[r];
        for (int i = 0; i < r; i++) {
          indices[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(maximumP(org, sub, indices));
    }
    public static int maximumP(String org, String sub, int[] indices) {
        int n = org.length();
        int m = sub.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (org.charAt(i - 1) == sub.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int p = 0;
        for (int i = 0; i < indices.length; i++) {
            if (dp[n - indices[i]][m]) {
                p++;
            } else {
                break;
            }
        }
        return p;
    }
}
*/
/* Binary Search optimal */
/*
 import java.util.*;
public class MaxDeletionsSubsequence {
    
    // Check if 'sub' is a subsequence of 'org'
    static boolean isSubsequence(String org,boolean[] deleted String sub) {
        int i = 0, j = 0;
        while (i < org.length() && j < sub.length()) {
            if (!deleted[i] && org.charAt(i) == sub.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == sub.length();
    }
    public static int maxDeletions(String org, String sub, int[] indices) {
        int n = org.length();
        int left = 0, right = indices.length;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            // Mark deleted positions
            boolean[] deleted = new boolean[n];
            for (int i = 0; i < mid; i++) {
                deleted[indices[i]] = true;
            }
            // Build the filtered string after deletions
            if (isSubsequence(org,deleted, sub)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String org = sc.next();
        String sub = sc.next();
        int r = sc.nextInt();
        int[] indices = new int[r];
        for (int i = 0; i < r; i++) {
            indices[i] = sc.nextInt();
        }
        
        System.out.println(maxDeletions(org, sub, indices));
    }
}
 */
import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        String org=s[0];
        String sub=s[1];
        int s1=sc.nextInt();
        int a[]=new int[s1];
        for (int i = 0; i < s1; i++)
          a[i] = sc.nextInt();
        sc.close();
        int m=org.length();
        boolean b[]=new boolean[m];
        int ans=0;
        for(int i=0;i<s1;i++){
            if(is(org,sub,b,a[i])) ans++;
            else break;
        }
        System.out.println(ans);
    }
    public static boolean is(String s1,String s2,boolean b[],int k){
        b[k]=true;
        int i=0,j=0;
        while(i<s1.length() && j<s2.length()){
            if(!b[i] && s1.charAt(i)==s2.charAt(j)){
                j++;
            }
            i++;
        }
        return j==s2.length();
    }
}
/* claude response */
/*
 package day42_14_05_2025;

import java.util.*;

// Your approach corrected - Linear Search
class LinearSearchSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String org = s[0];
        String sub = s[1];
        int r = sc.nextInt();
        int[] indices = new int[r];
        for (int i = 0; i < r; i++) {
            indices[i] = sc.nextInt();
        }
        sc.close();
        
        int ans = 0;
        boolean[] deleted = new boolean[org.length()];
        
        for (int i = 0; i < r; i++) {
            // Temporarily mark this position as deleted
            deleted[indices[i]] = true;
            
            // Check if subsequence still exists
            if (isSubsequence(org, sub, deleted)) {
                ans++; // We can delete this many characters
            } else {
                // Can't delete more, so revert and break
                deleted[indices[i]] = false;
                break;
            }
        }
        
        System.out.println(ans);
    }
    
    public static boolean isSubsequence(String org, String sub, boolean[] deleted) {
        int i = 0, j = 0;
        while (i < org.length() && j < sub.length()) {
            if (!deleted[i] && org.charAt(i) == sub.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == sub.length();
    }
}

// Optimal Solution - Binary Search
class BinarySearchSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String org = s[0];
        String sub = s[1];
        int r = sc.nextInt();
        int[] indices = new int[r];
        for (int i = 0; i < r; i++) {
            indices[i] = sc.nextInt();
        }
        sc.close();
        
        System.out.println(maxDeletions(org, sub, indices));
    }
    
    public static int maxDeletions(String org, String sub, int[] indices) {
        int left = 0, right = indices.length;
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Mark first 'mid' deletions
            boolean[] deleted = new boolean[org.length()];
            for (int i = 0; i < mid; i++) {
                deleted[indices[i]] = true;
            }
            
            if (isSubsequence(org, sub, deleted)) {
                ans = mid;
                left = mid + 1; // Try to delete more
            } else {
                right = mid - 1; // Delete fewer
            }
        }
        
        return ans;
    }
    
    public static boolean isSubsequence(String org, String sub, boolean[] deleted) {
        int i = 0, j = 0;
        while (i < org.length() && j < sub.length()) {
            if (!deleted[i] && org.charAt(i) == sub.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == sub.length();
    }
}

// Most Efficient - Greedy with early termination
class GreedySolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String org = s[0];
        String sub = s[1];
        int r = sc.nextInt();
        int[] indices = new int[r];
        for (int i = 0; i < r; i++) {
            indices[i] = sc.nextInt();
        }
        sc.close();
        
        System.out.println(maxDeletionsGreedy(org, sub, indices));
    }
    
    public static int maxDeletionsGreedy(String org, String sub, int[] indices) {
        boolean[] deleted = new boolean[org.length()];
        
        for (int i = 0; i < indices.length; i++) {
            // Temporarily delete this character
            deleted[indices[i]] = true;
            
            // Check if subsequence still exists
            if (!canFormSubsequence(org, sub, deleted)) {
                // If we can't form subsequence, we can delete at most i characters
                return i;
            }
        }
        
        // We can delete all characters and still maintain subsequence
        return indices.length;
    }
    
    private static boolean canFormSubsequence(String org, String sub, boolean[] deleted) {
        int j = 0; // pointer for sub
        
        for (int i = 0; i < org.length() && j < sub.length(); i++) {
            if (!deleted[i] && org.charAt(i) == sub.charAt(j)) {
                j++;
            }
        }
        
        return j == sub.length();
    }
}

// Alternative: Using Set for deleted indices (cleaner but slightly less efficient)
class SetBasedSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String org = s[0];
        String sub = s[1];
        int r = sc.nextInt();
        int[] indices = new int[r];
        for (int i = 0; i < r; i++) {
            indices[i] = sc.nextInt();
        }
        sc.close();
        
        System.out.println(maxDeletionsWithSet(org, sub, indices));
    }
    
    public static int maxDeletionsWithSet(String org, String sub, int[] indices) {
        Set<Integer> deletedIndices = new HashSet<>();
        
        for (int i = 0; i < indices.length; i++) {
            deletedIndices.add(indices[i]);
            
            if (!isSubsequenceWithSet(org, sub, deletedIndices)) {
                return i; // Can delete at most i characters
            }
        }
        
        return indices.length;
    }
    
    private static boolean isSubsequenceWithSet(String org, String sub, Set<Integer> deleted) {
        int j = 0;
        
        for (int i = 0; i < org.length() && j < sub.length(); i++) {
            if (!deleted.contains(i) && org.charAt(i) == sub.charAt(j)) {
                j++;
            }
        }
        
        return j == sub.length();
    }
}
 */