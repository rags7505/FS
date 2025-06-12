package day62_12_06_2025;
/*
Luke likes to construct and play with arrays. His dad gave him an array M of 
length N and assigned him the following tasks to be done in order:
 - reate continuous groups of size i from the array M (where i goes from 1 to N).
 - For each group of size i, find the minimum value.
 - Among all the minimums from that step, select the maximum.
 - Add this selected value as the i-th element of a new array P.
 - Repeat until i = N.

Note: Use 1-based indexing for array P in logic.

Input Format:
-------------
input1: Integer N – length of array M
input2: Integer array M of length N

Output Format:
--------------
Return the array P as output.

Sample Input:
-------------
3
1 2 3

Sample Output:
--------------
3 2 1


Sample Input: 
-------------
4
20 10 30 40

Sample Output: 
--------------
40 30 10 10
*/

/* Brute Force */
/*
import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        sc.close();
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            int size=i+1;
            List<Integer> min=new ArrayList<>();
            for(int j=0;j<=n-size;j++){
                int m=Integer.MAX_VALUE;
                for(int k=j;k<j+size;k++){
                    m=Math.min(a[k],m);
                }
                min.add(m);
            }
            l.add(Collections.max(min));
        }
        System.out.print(l);
    }
}
*/
/*With 2D array */
/*
 import java.util.*;
public class program1{
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []ans=new int[n];
        int []a=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        int [][]dp=new int[n][n];
        dp[0]=Arrays.copyOf(a, n);
        for(int i=1;i<n;i++){
            for(int j=0;j<n-i;j++){
                dp[i][j]=Math.min(dp[i-1][j], dp[i-1][j+1]);
            }
        }
        for(int i=0;i<n;i++){
            int max=0;
            for(int j=0;j<n;j++) max=Math.max(max, dp[i][j]);
            ans[i]=max;
        }
        System.out.println(Arrays.toString(ans));
    }
}
 */
/* With 1D array */
import java.util.*;

class program1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    sc.close();
    int[] ans = new int[n];
    List<Integer> minList = new ArrayList<>();
    for(int i: a) {
      minList.add(i);
    }
    for (int i = 0; i < n; i++) {
      ans[i] = Collections.max(minList);
      List<Integer> newMinList = new ArrayList<>();
      for (int j = 0; j < minList.size() - 1; j++) {
        newMinList.add(Math.min(minList.get(j), minList.get(j + 1)));
      }
      minList = newMinList;
    }
    System.out.println(Arrays.toString(ans));
  }
}