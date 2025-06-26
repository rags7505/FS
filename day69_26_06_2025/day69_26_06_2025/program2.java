package day69_26_06_2025;

/*
 BCCI wants to select the group of bowlers for an upcoming test-series, 
you want to choose the group with highest number of wickets, which is 
the sum of wickets taken by all the bowlers in that group.

However, the bowler group is not allowed to have any disputes. A dispute
exists if a younger bowler has strictly highest wickets than an older bowler. 
A dispute does not occur between bowlers of the same age.

You are given information of N bowlers as two lists, wickets and ages, 
where each wickets[i] and ages[i] represents the wickets and age of 
the i-th bowler, respectively, return the highest number of wickets 
of all possible bowler groups.


Input Format:
-------------
Line-1: An integer N, number of bowlers.
Line-2: N space separated integers, wickets[].
Line-3: N space separated integers, ages[].

Output Format:
--------------
An integer, highest number of wickets of all possible bowler groups.


Sample Input-1:
---------------
4
5 3 5 6
3 5 4 2

Sample Output-1:
----------------
10

Explanation:
------------
It is best to choose 2 bowlers of age 3 and 4. 


Sample Input-2:
---------------
5
5 3 5 6 3
2 5 4 2 1

Sample Output-2:
----------------
14

Explanation:
------------
It is best to choose 3 bowlers of age 1 and 2. 
Notice that you are allowed to choose multiple bowlers of the same age.

Sample Input-3:
---------------
5
1 3 5 10 15
1 2 3 4 5

Sample Output-3:
----------------
34

Explanation:
------------
You can choose all the bowlers.

 */
/* Chatgpt */
import java.util.*;

public class program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wickets = new int[n];
        int[] ages = new int[n];

        for (int i = 0; i < n; i++)
            wickets[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            ages[i] = sc.nextInt();
        sc.close();
        // Pair (age, wickets)
        int[][] bowlers = new int[n][2];
        for (int i = 0; i < n; i++) {
            bowlers[i][0] = ages[i];
            bowlers[i][1] = wickets[i];
        }

        // Sort by age asc, if age same then by wickets asc
        Arrays.sort(bowlers, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = bowlers[i][1]; // minimum is selecting current bowler
            for (int j = 0; j < i; j++) {
                if (bowlers[j][1] <= bowlers[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + bowlers[i][1]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
/* Someones code */
/*
 import java.util.*;

public class program2 {
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wickets = new int[n];
        int[] ages = new int[n];

        for (int i = 0; i < n; i++) wickets[i] = sc.nextInt();
        for (int i = 0; i < n; i++) ages[i] = sc.nextInt();
        sc.close();
        // Pair (age, wickets)
        int[][] bowlers = new int[n][2];
        for (int i = 0; i < n; i++) {
            bowlers[i][0] = ages[i];
            bowlers[i][1] = wickets[i];
        }

        // Sort by age asc, if age same then by wickets asc
        Arrays.sort(bowlers, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        backtrack(bowlers,0,-1,0);

        System.out.println(max);
    }
public static void backtrack(int[][] bowlers, int idx, int prev, int sum) {
    if (idx == bowlers.length) {
        max = Math.max(max, sum);
        return;
    }
    if (prev == -1 || bowlers[idx][1] >= bowlers[prev][1]) {
        backtrack(bowlers, idx + 1, idx, sum + bowlers[idx][1]);
    }
    backtrack(bowlers, idx + 1, prev, sum);
}
 */