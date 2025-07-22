package day84_22_07_2025;
/*
Given N satellite stations, numbered 1 to N.
These satellites are connected to send signals from one to other.
To send a signal from satellite 's' to satellite 'd', it takes 
an amount of time 't'.

You are given a list of travel times as directed edges times[i] = (s, d, t).

Your task to find the time taken to recieve signal from a satellite station K, 
to all N-1 satellite stations. If it is impossible, return -1 .

Input Format:
-------------
Line-1 ->   Three integers, N number of satellite stations, 
            K is the satellite to send signal and T is the number of edges.
Next T lines -> Three space separated integers, 's' is the source, 
            'd' is the destination, 
			't' is the time taken recieve signal from 's' to 'd'.

Output Format:
--------------
Print an integer as your result.


Sample Input-1:
---------------
4 2 3
2 1 1
2 3 1
3 4 1

Sample Output-1:
----------------
2


Sample Input-2:
---------------
5 2 4
2 1 1
2 3 2
3 4 3
5 1 4

Sample Output-2:
----------------
-1


Sample Input-3:
---------------
5 2 4
2 1 1
2 3 2
3 4 3
1 5 6

Sample Output-3:
----------------
7
*/
/* chatgpt */
import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int m=sc.nextInt();
        List<List<int[]>> l=new ArrayList<>();
        for(int i=0;i<=n;i++){
            l.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            int t=sc.nextInt();
            l.get(s).add(new int[]{d,t});
        }
        sc.close();
        int[] distance=new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k]=0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0, k});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0];
            int satellite = cur[1];
            for (int[] edge : l.get(satellite)) {
                int nextSatellite = edge[0];
                int timeToNext = edge[1];
                if (distance[nextSatellite] > time + timeToNext) {
                    distance[nextSatellite] = time + timeToNext;
                    pq.add(new int[]{distance[nextSatellite], nextSatellite});
                }
            }
        }
        int time=0;
        for(int i=1;i<=n;i++){
            if(i==k) continue;
            if(distance[i]==Integer.MAX_VALUE){
                System.out.println(-1);
                return;
            }
            time=Math.max(time, distance[i]);
        }
        System.out.println(time);
    }
}