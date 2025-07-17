package day82_16_07_2025;
/*
There are N tourist places in India, where some are connected with each other 
through Airways and some or not. You will be given the Airways as routes[] array, 
where routes[i]=[X,Y], there is an direct airway route between place-X to place-Y 
and vice versa.

Reachability Score of two tourist places is defined as the total number of direct 
airway routes to any tourist place. If there is a common airway route between both
the tourist places, it is counted only once.

Your task is to find and return the maximum reachability score between any pair 
of tourist places among the N tourist places in INDIA.

Input Format:
-------------
Line-1:Two space separated integers, N number of places, and R number of routes.
Next R lines: Two space separated integers, X and Y. 

Output Format:
--------------
Print an integer, maximum reachability score.


Sample Input-1:
---------------
5 6
0 1
1 2
0 4
1 4
2 4
3 4

Sample Output-1:
----------------
6

Explanation:
------------
The Reachability Score of the tourist places place-1 is 3 and place-4 is 4 .
There is a common route between place-1 and place-4,
So, the maximum reachability score is 3+4-1 = 6.


Sample Input-2:
---------------
8 9
0 1
1 2
0 3
1 3
2 3
4 5
6 5
5 7
4 7

Sample Output-2:
----------------
6
*/

/*Others 1 */
import java.util.*;
public class program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] degree = new int[n];
        Set<String> direct = new HashSet<>();
        int a[][] = new int[m][2];
        for (int i = 0; i < m; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            degree[a[i][0]]++;
            degree[a[i][1]]++;
            direct.add(a[i][0] + " " + a[i][1]);
        }
        sc.close();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int linked = degree[i] + degree[j];
                if (direct.contains(i + " " + j) || direct.contains(j + " " + i)) {
                    linked--;
                }
                ans = Math.max(ans, linked);
            }
        }
        System.out.println(ans);
    }
}
/*Others 2 */
/*
import java.util.*;
class program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            adj.get(start).add(end);
            adj.get(end).add(start);
        }
        sc.close();
        int maxReachabilityScore = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int score = adj.get(i).size() + adj.get(j).size();
                if (adj.get(i).contains(j) || adj.get(j).contains(i)) {
                    score--;
                }
                maxReachabilityScore = Math.max(maxReachabilityScore, score);
            }
        }
        System.out.println(maxReachabilityScore);
    }
}  */
/*other 3 */
/*
import java.util.*;
class program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int aa[] = new int[n];
        boolean b[][] = new boolean[n][n];
        for (int i = 0; i < r; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            aa[u]++;
            aa[v]++;
            b[u][v] = true;
            b[v][u] = true;
        }
        sc.close();
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int c = aa[i] + aa[j];
                if (b[i][j]) {
                    c--;
                }
                max = Math.max(max, c);
            }
        }
        System.out.println(max);
    }
}*/
/* chatgpt */
/*
import java.util.*;
class program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < r; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.putIfAbsent(x, new HashSet<>());
            graph.putIfAbsent(y, new HashSet<>());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        sc.close();
        int maxReachabilityScore = 0;
        
        for (int i : graph.keySet()) {
            for (int j : graph.keySet()) {
                if (i != j) {
                    // Get all routes (edges) accessible from place i
                    Set<String> routesFromI = new HashSet<>();
                    for (int neighbor : graph.get(i)) {
                        routesFromI.add(Math.min(i, neighbor) + "-" + Math.max(i, neighbor));
                    }
                    
                    // Get all routes (edges) accessible from place j
                    Set<String> routesFromJ = new HashSet<>();
                    for (int neighbor : graph.get(j)) {
                        routesFromJ.add(Math.min(j, neighbor) + "-" + Math.max(j, neighbor));
                    }
                    
                    // Combine routes (union) - common routes counted only once
                    Set<String> combinedRoutes = new HashSet<>(routesFromI);
                    combinedRoutes.addAll(routesFromJ);
                    
                    int score = combinedRoutes.size();
                    maxReachabilityScore = Math.max(maxReachabilityScore, score);
                }
            }
        }
        
        System.out.println(maxReachabilityScore);
    }
}*/