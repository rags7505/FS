package day86_24_07_2025;
/*
There are N cities in a state.
The cities are connected with two types of roadways:
1) concrete roadway 2) asphalt roadway.
The roadways may be parallel.

You are given the lists of concrete roadways and asphalt roadways
between the cities. All roadways are unidirectional.
Concrete_Roadway[i,j] indiactes: a concrete road from city-i to city-j. Similarly,
Asphalt[i,j] indiactes: an asphalt road from city-i to city-j. Similarly,

Your task is to find and return the list of lengths of the shortest paths from 
city-0 to city-P, where P start from 0 to N-1. And the path should contains 
alternative roadways like as follows: concrete - asphalt - concrete -asphalt --etc
or vice versa. If there is no such shortest path exist print -1.

Input Format:
-------------
Line-1: 3 space separated integers N, C & A, Number of cities, routes between the cities.
		number of concrete roads and number of asphalt roads
Next C lines: Two space separated integers, concrete road between city-i to city-j.		
Next A lines: Two space separated integers, asphalt road between city-i to city-j.		

Output Format:
--------------
Print the list of lengths, the shortest paths.


Sample Input-1:
---------------
4 2 1
0 1
2 3
1 2

Sample Output-1:
----------------
0 1 2 3

Sample Input-2:
---------------
4 2 1
1 0
2 3
1 2

Sample Output-2:
----------------
0 -1 -1 -1


Sample Input-3:
---------------
4 3 2
1 0
1 2
2 3
0 1
1 2

Sample Output-3:
----------------
0 1 2 -1
*/
import java.util.*;
class program1{
    static int minCon=Integer.MAX_VALUE;
    static int minAsp=Integer.MAX_VALUE;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();
        int a=sc.nextInt();
        Map<Integer,List<Integer>> mc=new HashMap<>();
        for(int i=0;i<c;i++){
            int st=sc.nextInt();
            int end=sc.nextInt();
            mc.putIfAbsent(st,new ArrayList<>());
            mc.get(st).add(end);
        }
        Map<Integer,List<Integer>> ma=new HashMap<>();
        for(int i=0;i<a;i++){
            int st=sc.nextInt();
            int end=sc.nextInt();
            ma.putIfAbsent(st,new ArrayList<>());
            ma.get(st).add(end);
        }
        List<Integer> ans=new ArrayList<>();
        ans.add(0);
        sc.close();
        for(int i=1;i<n;i++){
            dfs(0,i,mc,ma,"con", 0, new HashSet<>());
            dfs(0,i,mc,ma,"asp", 0, new HashSet<>());
            int min=Math.min(minCon,minAsp);
            if(min==Integer.MAX_VALUE) ans.add(-1);
            else ans.add(min);
            minCon=Integer.MAX_VALUE;
            minAsp=Integer.MAX_VALUE;
        }
        System.out.println(ans);
    }
    private static void dfs(int curr, int target, Map<Integer, List<Integer>> mc, Map<Integer, List<Integer>> ma,
                                  String type, int count, Set<String> visited) {
        if (curr == target) {
            if (type.equals("con")) minCon = Math.min(minCon, count);
            else minAsp = Math.min(minAsp, count);
            return;
        }
        String key = curr + "-" + type;
        if (visited.contains(key)) return;
        visited.add(key);
        if (type.equals("con") && mc.containsKey(curr)) {
            for (int next : mc.get(curr)) {
                dfs(next, target, mc, ma, "asp", count + 1, visited);
            }
        } else if (type.equals("asp") && ma.containsKey(curr)) {
            for (int next : ma.get(curr)) {
                dfs(next, target, mc, ma, "con", count + 1, visited);
            }
        }
    }
}