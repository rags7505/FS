package day67_23_06_2025;
/*
There is a crowd attended for a political meeting with different groups and each
group had unique colored dresses wearing.We asked n people in the crowd that
"How many are attended from your group excluding yourself?" and collected the 
answers in an integer array answers where group[i] is the answer of the ith group.

Given the array groups, return the minimum possible attendance that could be 
there in the meeting.

Constraints:
------------
    1 <= n <= 1000
    0 <= group[i] < 1000

Input Format:
-------------
Line-1: An integer n, represents the people answered.
Line-2: n space seperated integers represents the answers.

Output Format:
--------------
return an integer represents mimimum possible attendance.

Sample Input-1:
---------------
1,2,1,2,1

Sample Output-1:
----------------
7

Explanation:
------------
Out of the three groups that answered "1", there could be two groups wearing to 
the same color, say white and the other group wearing some other color, say 'pink'
The two groups that answered "2" could both be wearing the same color, say 'yellow'.
The minimum possible number of attendance in the meeting is 7.

    
Sample Input-2:
---------------
3,2,1,6,4

Sample Output-2:
----------------
21
*/
/* Chatgpt */

import java.util.*;

public class program2 {
    public static int minimumAttendance(int[] group) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int g : group) {
            freq.put(g, freq.getOrDefault(g, 0) + 1);
        }
        // Calculate the minimum attendance based on the frequency of each group size
        // For each group size x, we need at least (count + (x + 1) - 1) / (x + 1) groups
        // to cover all members, where count is the frequency of that group size.
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int x = entry.getKey();
            int count = entry.getValue();
            int groupSize = x + 1;
            int numGroups = (count + groupSize - 1) / groupSize; // ceil(count / (x+1))
            total += numGroups * groupSize;
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(",");
        sc.close();
        int[] group = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            group[i] = Integer.parseInt(tokens[i].trim());
        }
        System.out.println(minimumAttendance(group));
    }
}
