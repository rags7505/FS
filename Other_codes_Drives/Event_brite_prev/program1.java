package Other_codes_Drives.Event_brite_prev;
/* 1. Movie Ratings
Alexa loves movies and maintains a list of negative and/or positive integer ratings for the movies in her collection. She's getting ready for a film festival and wants to choose some subsequence of movies from her collection to bring such that the following conditions are satisfied:

The collective sum of their ratings is maximal.

She must go through her list in order and cannot skip more than one movie in a row.

In other words, she cannot skip over two or more consecutive movies. For example, if
ratings = [1, -3, -2], she must include either the second number or the first and third numbers to get a maximal rating sum of -3.

Example
If ratings = [-3, 2, 4, -1, -2, -5],
Her maximal choices are [2, 4, -2] for a sum of 4.

Function Description
Complete the function maximizeRatings in the editor below. The function must return an integer denoting the maximum possible rating sum for Alexa's chosen subsequence of movies without reordering them.

maximizeRatings has the following parameter(s):
ratings(ratings[0],....ratings[n-1]): an array of integers

Constraints:
1 ≤ n ≤ 10⁵
-1000 ≤ ratings[i] ≤ 1000, where 0 ≤ i < n

Input
ratings: a list of integers of size n (1 ≤ n ≤ 10⁵)
Each ratings[i] (where 0 ≤ i < n) is in the range -1000 to 1000

Sample Case 0
Input
5  
9  
-1  
-3  
4  
5  

Output
17

Explanation
Alexa picks the bolded items in ratings = [9, -1, -3, 4, 5] to get maximum rating:
9 + 4 + 5 = 17.
Thus, the answer is 17.
 */
import java.util.*;

class Result {
    public static int maximizeRatings(List<Integer> ratings) {
        int n = ratings.size();
        
        // Handle base cases
        if (n == 0) return 0;
        if (n == 1) return Math.max(0, ratings.get(0));
        
        // dp[i][0] = max sum ending at i, having skipped i
        // dp[i][1] = max sum ending at i, having included i
        int[][] dp = new int[n][2];
        
        // Initialize for the first movie
        dp[0][0] = 0;  // Skip first movie
        dp[0][1] = ratings.get(0);  // Include first movie
        
        // Initialize for the second movie
        if (n > 1) {
            dp[1][0] = dp[0][1];  // Skip second movie, must include first
            dp[1][1] = ratings.get(1);  // Include second movie, must skip first
        }
        
        // Fill the dp table
        for (int i = 2; i < n; i++) {
            // If we skip movie i, we must have included movie i-1
            dp[i][0] = dp[i-1][1];
            
            // If we include movie i, we can either:
            // 1. Skip movie i-1 and include movie i-2
            // 2. Include movie i-1 and skip movie i-2
            dp[i][1] = Math.max(dp[i-1][0], dp[i-2][1]) + ratings.get(i);
        }
        
        // Return the maximum sum ending at the last movie
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}

public class program1{
    public static void main(String[] args) {
        // Example 1
        List<Integer> ratings1 = Arrays.asList(-3, 2, 4, -1, -2, -5);
        System.out.println(Result.maximizeRatings(ratings1)); // Expected: 4
        
        // Example 2
        List<Integer> ratings2 = Arrays.asList(9, -1, -3, 4, 5);
        System.out.println(Result.maximizeRatings(ratings2)); // Expected: 17
    }
}