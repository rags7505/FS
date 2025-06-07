/*

Write Java function to return minimum number of denominations – given an infinite
supply of each denomination of {1, 2, 5, 10, 20, 50, 100, 200,500, 2000} and 
a target value N

Sample Input: 
-------------
187

Sample Output: 
--------------
[100, 50, 20, 10, 5, 2]

*/
import java.util.*;
class Solution5{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        int a[]={2000,500,100,50,20,10,5,2,1};
        List<Integer> l=new ArrayList<>();
        for(int i:a){
            if(n==0) break;
            while(n>=i){
                l.add(i);
                n-=i;
            }
        }
        System.out.println(l);
    }
}