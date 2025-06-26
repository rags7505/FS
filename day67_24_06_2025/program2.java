package day67_24_06_2025;
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
/* Chatgpt */
/*
 import java.util.*;

public class program2 {
    static List<String> result = new ArrayList<>();
    static int totalTickets;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        sc.close();

        // Build adjacency list
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String ticket : s) {
            String[] parts = ticket.trim().split(" ");
            graph.putIfAbsent(parts[0], new PriorityQueue<>());
            graph.get(parts[0]).offer(parts[1]);
        }

        totalTickets = s.length;
        result.add("BZA");
        if (dfs("BZA", graph)) {
            System.out.println(result);
        } else {
            System.out.println("No valid itinerary found.");
        }
    }

    static boolean dfs(String from, Map<String, PriorityQueue<String>> graph) {
        if (result.size() == totalTickets + 1) return true;

        if (!graph.containsKey(from) || graph.get(from).isEmpty()) return false;

        PriorityQueue<String> destinations = graph.get(from);
        List<String> tempList = new ArrayList<>();

        while (!destinations.isEmpty()) {
            String to = destinations.poll();
            tempList.add(to);
            result.add(to);
            if (dfs(to, graph)) return true;
            result.remove(result.size() - 1);
        }

        // Restore the removed destinations for backtracking
        destinations.addAll(tempList);
        Collections.sort((List<String>) destinations); // Restore order

        return false;
    }
 */
/* My code, small changes by chatgpt */
import java.util.*;
public class program2{
    static int n=0;
    static List<String> ans=new ArrayList<>();
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(",");
        sc.close();
        Map<String,LinkedList<String>> m=new HashMap<>();
        for(String i:s){
            String k[]=i.split(" ");
            m.putIfAbsent(k[0],new LinkedList<>());
            m.get(k[0]).add(k[1]);
        }
        for(LinkedList<String> l:m.values()){
            Collections.sort(l);
        }
        n=s.length;
        ans.add("BZA");
        dfs("BZA",m);
        System.out.println(ans);
    }
    public static boolean dfs(String from,Map<String,LinkedList<String>> m){
        if(ans.size()==n+1) return true;
        if(!m.containsKey(from)) return false;
        LinkedList<String> q=m.get(from);
        for(int i=0;i<q.size();i++){
            String to=q.remove(i);
            ans.add(to);
            if(dfs(to,m)) return true;
            ans.remove(ans.size()-1);
            q.add(i,to);
        }
        return false;
    }
}