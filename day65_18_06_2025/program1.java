package day65_18_06_2025;
/*
Gopal would like to go on Tour, and planned a schedule.
Airport authority has created a new way of issuing tickets.
Gopal purchased a set of airline tickets, 
each ticket contains the 'departure from' and 'arrival to'.

Redesign the Gopal's tour schedule in an order.
Gopal intially must begin his tour from BZA.
Hence the tour schedule's start point should begin with BZA. 

You are given a list of flight tickets which Gopal has purchased.
Your task is to find out and return the tour schedule that has the least 
lexical order. Gopal must use all the tickets once and only once.

Note:
------
If there are multiple valid schedules, you should return the schedule 
that has the smallest lexical order when read as a single string. 
For example, the schedule ["BZA", "LGA"] has a smaller lexical order 
than ["BZA", "LGB"].

All airports are represented by three capital letters.
You may assume all tickets form at least one valid schedule.

Input Format:
-------------
Single Line of tickets separated by comma, and each ticket separated by space, 
Gopal's flight tickets.

Output Format:
--------------
Print the schedule, which is smallest lexical order of tour schedule.


Sample Input-1:
----------------
DEL HYD,BZA DEL,BLR MAA,HYD BLR

Sample Output-1:
--------------------
[BZA, DEL, HYD, BLR, MAA]


Sample Input-2:
------------------
BZA BLR,BZA CCU,BLR CCU,CCU BZA,CCU BLR

Sample Output-2:
------------------
[BZA, BLR, CCU, BZA, CCU, BLR]
 */
/* chatgpt */
import java.util.*;

public class program1 {
    static Map<String, LinkedList<String>> graph = new HashMap<>();
    static LinkedList<String> result = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        sc.close();

        String[] ticketPairs = input.split(",");

         // Build graph with sorted adjacency list (reversed)
        for (String pair : ticketPairs) {
            String[] ticket = pair.trim().split(" ");
            String from = ticket[0], to = ticket[1];
            graph.putIfAbsent(from, new LinkedList<>());
            graph.get(from).add(to);
        }

         // Sort each adjacency list in reverse lex order (for stack-like behavior)
        for (List<String> destList : graph.values()) {
            Collections.sort(destList, Collections.reverseOrder());
        }

        dfs("BZA");

        System.out.println(result);
    }

    static void dfs(String airport) {
        LinkedList<String> dests = graph.get(airport);
        while (dests != null && !dests.isEmpty()) {
            String next = dests.removeLast(); // get lex smallest (because we reversed)
            dfs(next);
        }
        result.addFirst(airport); // build path in reverse
    }
}