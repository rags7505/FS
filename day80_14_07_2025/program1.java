package day80_14_07_2025;
/*
You have given a bulb grid, where the bulb which is turned ON is indicated 
with 1, and turned OFF is indicated with 0.

You are allowed to perform an operation:
    - Select a row/column in the buld grid, and toggle the bulbs,
    the bulbs which are turned ON will be truned OFF and the bulbs which are 
    turned OFF will be turned ON.

Your task is to find the highest possible sum of all the binary equivalents 
of each row in the bulb grid, after performing the above operation any 
number of times on the bulb grid.


Input Format:
-------------
Line-1: Two space separated integers, M and N
Next M lines: N space separated integers, grid[][]

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 5
0 1 1 1 1 
1 0 1 1 1 
0 0 0 0 1 

Sample Output-1:
----------------
78

Explanation:
------------
Given grid is 
0 1 1 1 1
1 0 1 1 1
0 0 0 0 1

Perform operation on row-0 and row-2
1 0 0 0 0
1 0 1 1 1
1 1 1 1 0

Perform operation on col-1 and col-4
1 1 0 0 1 = 25
1 1 1 1 0 = 30
1 0 1 1 1 = 23
So, now the total value of Binary Equivalent is 78


Sample Input-2:
---------------
2 3
0 1 0
0 0 1

Sample Output-2:
----------------
11
*/
import java.util.*;
public class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int a[][]=new  int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        sc.close();
        for(int i=0;i<m;i++){
            if(a[i][0]==1) continue;
            tog(a,"row",n,i);
        }
        for(int i=0;i<n;i++){
            int b=check(a,i,m);
            if(b<=(m/2)){
                tog(a,"col",m,i);
            }
        }
        System.out.println(binary(a));
    }
    public static int binary(int[][]a){
        int sum=0;
        for(int[] r:a){
            int d=0;
            for(int i=0;i<r.length;i++){
                d=d*2+r[i];
            }
            sum+=d;
        }
        return sum;
    }
    public static int check(int[][]a,int i,int m){
        int c=0;
        for(int j=0;j<m;j++){
            if(a[j][i]==1) c++;
        }
        return c;
    }
    public static void tog(int[][]a,String b,int k,int j){
        if(b.equals("row")){
            for(int i=0;i<k;i++){
                if(a[j][i]==0){
                    a[j][i]=1;
                }
                else{
                    a[j][i]=0;
                }
            }
        }
        else{
            for(int i=0;i<k;i++){
                if(a[i][j]==0){
                    a[i][j]=1;
                }
                else{
                    a[i][j]=0;
                }
            }
        }
    }
}