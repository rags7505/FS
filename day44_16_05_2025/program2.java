package day44_16_05_2025;
/*
There are N employees from 3 different companies in a row, emps[], the employees 
are identified using company IDs as 1,2,3. A Courier Boy need to deliver 
P parcels to these 3 companies. The parcel details are given as parcels[],
where parcel[i]=[Ci,CIDi], i-th parcel, 'Ci' is Courier Boy's current position, 
and  'CIDi' is company's ID, he/she need to deliver parcel[i] from Ci position 
to the nearest employee belongs to companay ID equals to CIDi in the row.

You are given emps[] and parcels[] information,
Your task is to help the courier boy to find the distance between him to 
the nearest employee in that row to deliver the parcel.
If there is no solution found, return -1.

Input Format:
-------------
Line-1: Two space separated integers, N and P
Line-2: N space separated integers, only 1, 2 & 3.
Next P lines: Two space separated integers, position Ci and Company ID

Output Format:
--------------
Print the space separated integers, distance between boy and the employee for 
all the parcels.


Sample Input-1:
---------------
6 2
1 1 2 2 3 3
1 3
2 2

Sample Output-1:
----------------
3 0 

Sample Input-2:
---------------
5 2
1 2 3 2 1
2 1
1 1

Sample Output-2:
----------------
2 1 

*/
import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        int p[][]=new int[m][2];
        for(int i=0;i<m;i++){
            p[i][0]=sc.nextInt();
            p[i][1]=sc.nextInt();
        }
        sc.close();
        List<Integer> l=new ArrayList<>();
        for(int a1[]:p){
            int idx=a1[0],t=a1[1];
            if(a[idx]==t){
                l.add(0);
                continue;
            }
            int i=idx,j=idx,cnt1=0;
            while(i>=0 && a[i]!=t){
                cnt1++;
                i--;
            }
            int cnt2=0;
            while(j<n && a[j]!=t){
                cnt2++;
                j++;
            }
            if(i!=-1 && j!=n){
                l.add(Math.min(cnt1,cnt2));
            }
            else if(i==-1 && j!=n) l.add(cnt2);
            else if(j==n && i!=-1) l.add(cnt1);
            else l.add(-1);
        }
        System.out.println(l);
    }
}
/* Tejas code (optimal)*/
/*
 import java.util.*;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();
        Map<Integer,List<Integer>> map = new HashMap<>();
        map.put(1,new ArrayList<>());
        map.put(2,new ArrayList<>());
        map.put(3,new ArrayList<>());
        for(int i=0;i<n;i++){
            map.get(sc.nextInt()).add(i);
        } 
        
        
        List<Integer> result= new ArrayList<>();
        for(int i = 0; i < c; i++) {
            int ci = sc.nextInt();
            int d = sc.nextInt();
            int min = Integer.MAX_VALUE;
            for(int pos : map.get(d)) {
                min = Math.min(min, Math.abs(pos - ci));
            }
            if(min == Integer.MAX_VALUE) result.add(-1);
            else result.add(min);
        }

        for(int r : result) System.out.print(r+" ");        
    }
}
 */
/* chatgpt */
/*
 * import java.util.*;

public class CourierDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int P = sc.nextInt();
        int[] emps = new int[N];
        
        // Store employee data
        for (int i = 0; i < N; i++) {
            emps[i] = sc.nextInt();
        }

        // Preprocess: Map company ID to list of employee indices
        Map<Integer, List<Integer>> companyMap = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            companyMap.put(i, new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            companyMap.get(emps[i]).add(i);
        }

        // Process each parcel
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < P; i++) {
            int pos = sc.nextInt();   // current courier position
            int cid = sc.nextInt();   // target company ID

            List<Integer> positions = companyMap.get(cid);
            if (positions == null || positions.isEmpty()) {
                result.add(-1);
            } else {
                int dist = findMinDistance(positions, pos);
                result.add(dist);
            }
        }

        // Output result
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) System.out.print(" ");
        }
    }

    // Binary search to find the minimum distance to the closest index
    private static int findMinDistance(List<Integer> list, int pos) {
        int left = 0, right = list.size() - 1;
        int minDist = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            int curr = list.get(mid);
            minDist = Math.min(minDist, Math.abs(curr - pos));

            if (curr < pos) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return minDist;
    }
}

 */
/* more optimal */
/*
 * import java.util.*;

public class CourierDeliveryOptimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();

        int[] emps = new int[N];
        for (int i = 0; i < N; i++) {
            emps[i] = sc.nextInt();
        }

        // Precompute distances for each company from every position
        int[][] distances = new int[4][N]; // index 1 to 3 used
        for (int c = 1; c <= 3; c++) {
            Arrays.fill(distances[c], Integer.MAX_VALUE);

            // Left to right pass
            int prev = -1;
            for (int i = 0; i < N; i++) {
                if (emps[i] == c) prev = i;
                if (prev != -1) distances[c][i] = Math.abs(i - prev);
            }

            // Right to left pass
            prev = -1;
            for (int i = N - 1; i >= 0; i--) {
                if (emps[i] == c) prev = i;
                if (prev != -1)
                    distances[c][i] = Math.min(distances[c][i], Math.abs(i - prev));
            }
        }

        // Process each parcel
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < P; i++) {
            int pos = sc.nextInt();
            int cid = sc.nextInt();
            int dist = distances[cid][pos];
            output.append(dist == Integer.MAX_VALUE ? -1 : dist).append(" ");
        }

        System.out.println(output.toString().trim());
    }
}

 */