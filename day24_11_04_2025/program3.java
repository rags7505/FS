package day24_11_04_2025;

/*
Chhota Bheem is fond of Laddus, there are N Laddus in a row, N is an even number. 
Where k-th laddu is of type-laddu[k], 1<=k<=N.
 
Due to health issues, Chhota Bheem was suggested to eat atmost N/2 Laddus of 
different types. He can eat only 1 Laddu of each type.
 
You are given an list of integers,
Your task is to find the maximum number of Laddus, Chhota Bheem can eat.
 
 
Input Format:
-------------
Line -1:An integer N, represents number of Laddus.
Line-2: N space separated integers, Laddu types.
 
Output Format:
--------------
Print an integer result.
 
Sample Input-1:
---------------
6
2 4 1 2 3 4
 
Sample Output-1:
----------------
3
 
Explanation:
------------
There are 6 Laddus, and 4 types of Laddus, 
So Bheem can eat 3 laddus only.
 
 
Sample Input-2:
---------------
8
1 1 1 2 1 2 1 1
 
Sample Output-2:
----------------
2
 
Explanation:
------------
There are 8 Laddus, and 2 types of Laddus, 
So Bheem can eat 2 ladddus only.
*/

import java.util.*;
class program3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        Set<Integer> st=new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(sc.nextInt());
        }
        int half=n/2;
        System.out.println(st.size()>=half?half:st.size());
    }
}

