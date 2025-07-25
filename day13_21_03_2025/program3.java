package day13_21_03_2025;

/*
Pascal's Triangle looks like below:
			1
		  1  1
		1  2  1
	  1  3  3  1
ans so on... You can create N number of rows, rows are indexed from 0 onwards.

You are given an integer N,
Your task is to print N-th index Row of the Pascal's Triangle.

Input Format:
-------------
An integer N, index number.

Output Format:
--------------
Print the n-th index row of Pascal's Triangle.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
1 1


Sample Input-2:
---------------
3

Sample Output-2:
----------------
1 3 3 1

*/
import java.util.*;
class program3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> l=new ArrayList<>();
        List<Integer> prev;
        l.add(1);
        for(int i=1;i<=n;i++){
            prev=new ArrayList<>(l);
            l=new ArrayList<>();
            l.add(1);
            for(int j=1;j<prev.size();j++){
                l.add(prev.get(j-1)+prev.get(j));
            }
            l.add(1);
        }
        sc.close();
        System.out.println(l);
    }
}
