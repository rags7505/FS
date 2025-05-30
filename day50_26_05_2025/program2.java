package day50_26_05_2025;
/*
JVS Infra Pvt Ltd purchased a flatland of size M*N, and it is divided 
into 1*1 cells. They mave marked some cells with red colors indicated 
with 1 and other cells with blue color indicated with 0.

They want build the walls in the form of rectangles by connecting four distinct 
red colored cells on the flatland that forms an axis-aligned rectangle.
And only the corners of the walls need to be red colored.

Your task is to help, JVS Infra to count the number of rectangular walls
can be built by connecting the red colored cells on the flatland.

Input Format:
-------------
Line-1: Two space separated integers, M and N
Next M lines: N space separated integers, either 0 or 1 only.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 4
1 0 1 0
1 1 1 1
0 1 1 1

Sample Output-1:
----------------
4

Explanation:
-----------
Given flatland is:
1 0 1 0
1 1 1 1
0 1 1 1
Number of rectngular walls are: 4
rectangle-1: by connecting 1's at (0, 0), (1, 0), (0, 2), (1, 2)
rectangle-2: by connecting 1's at (1, 1), (1, 2), (2, 1), (2, 2)
rectangle-3: by connecting 1's at (1, 1), (1, 3), (2, 1), (2, 3)
rectangle-4: by connecting 1's at (1, 2), (2, 2), (1, 3), (2, 3)


Sample Input-2:
---------------
4 5
1 0 1 0 1
0 0 0 1 0
0 1 1 0 1
1 0 1 0 0

Sample Output-2:
----------------
2
*/
import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt(),n=sc.nextInt();
        int a[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        sc.close();
        Set<String> st=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==1) st.add(i+" "+j);
            }
        }
        int ans=0;
        for(String i:st){
            String s[]=i.split(" ");
            int x=Integer.parseInt(s[0]),y=Integer.parseInt(s[1]);
            for(int j=x+1;j<m;j++){
                if(a[j][y]!=1) continue;
                for(int k=y+1;k<n;k++){
                    if(a[x][k]!=1) continue;
                    if(st.contains(j+" "+k)) ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
/* Chatgpt */
/*
 * import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(), N = sc.nextInt();
        int[][] arr = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                arr[i][j] = sc.nextInt();

        long total = 0;
        // For every pair of rows (r1 < r2)…
        for (int r1 = 0; r1 < M; r1++) {
            for (int r2 = r1 + 1; r2 < M; r2++) {
                int commonOnes = 0;
                // Count columns where both rows have a 1
                for (int c = 0; c < N; c++) {
                    if (arr[r1][c] == 1 && arr[r2][c] == 1) {
                        commonOnes++;
                    }
                }
                // From those columns, choose any 2 for left/right edges
                if (commonOnes >= 2) {
                    total += (long) commonOnes * (commonOnes - 1) / 2; //C(k,2)-> combination 
                }
            }
        }

        System.out.println(total);
    }
}
 */