package day85_23_07_2025;
/*
Mr Ashoka planted N trees in a land around the Flag Post which is at the center 
of the land, i.e., (0,0) position. You will be given the positions of N trees
as trees[], where tree[i]=[Xi,Yi], where Xi, Yi are the positions of i-th tree
with respect to X-axis and Y-axis. And you are also an integer C.

The distance between any two trees on the land plane is the Euclidean distance 
(i.e., sqrt((x1 - x2)^2 + (y1 - y2)^2).

Your task is to return positions of the C trees Nearest to the Flag post. 
The answer is supposed to be sorted based on distance, if the distances 
are same keep the original order of the trees[].


Input Format:
-------------
Line-1: Two space separate integers, N and C
Next N Lines: Two space separated integers, x,y

Output Format:
--------------
Print the positionf of C Nearest Trees.

Sample Input-1:
---------------
4 4
-3 -3
3 -3
3 3
-3 3

Sample Output-1:
----------------
[-3, -3] [3, -3] [3, 3] [-3, 3]


Sample Input-2:
---------------
4 3
2 -1
1 2
2 4
3 2

Sample Output-2:
----------------
[2, -1] [1, 2] [3, 2]
*/
import java.util.*;
public class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();
        int a[][]=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
        }
        sc.close();
        List<int[]> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new int[]{a[i][0],a[i][1],i});
        }
        Collections.sort(l,(a1,b1)->{
            double d1 = Math.sqrt(a1[0] * a1[0] + a1[1] * a1[1]);
            double d2 = Math.sqrt(b1[0] * b1[0] + b1[1] * b1[1]);
            int cmp = Double.compare(d1, d2);
            if (cmp != 0) return cmp;
            return Integer.compare(a1[2], b1[2]);
        });
        for(int i=0;i<c;i++){
            System.out.print("[" + l.get(i)[0] + ", " + l.get(i)[1] + "]");
        }
    }
}