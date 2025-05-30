package day32_28_04_2025;
import classes.DSU;
/*
You're working as a network administrator for a new startup that has set up 
N computers in its office. Due to cost constraints, they’ve haphazardly laid out
Ethernet cables between computers. Each cable connects exactly two computers, 
and no two computers are connected by more than one cable.

The management wants every computer to be part of a fully connected network, 
where any computer can reach any other either directly or indirectly. 
You're allowed to reallocate existing cables by removing them from 
one connection and using them to connect a new pair of computers.

However, you cannot create new cables — you can only reuse the existing ones. 
Your task is to determine the minimum number of such cable reallocation 
operations required to make the network fully connected. 
If it’s not possible with the current number of cables, return -1.

Input Format:
-------------
- N and C (integer): number of computers labeled from 0 to n - 1, and number 
of connections.
- C connections (List of integer pairs): each pair [a, b] represents 
a cable directly connecting computers a and b0 1

Output Format:
--------------
An integer result.


Sample Input-1:
---------------
4 3
0 1
0 2
1 2

Sample Output-1:
----------------
1


Sample Input-2:
---------------
6 5
0 1
0 2
0 3
1 2
1 3

Sample Output-2:
----------------
2


Sample Input-3:
---------------
6 4
0 1
0 2
0 3
1 2


Sample Output-3:
----------------
-1
*/

import java.util.*;

class program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        DSU u = new DSU(n);
        int cnt = 0;
        for (int i = 0; i < c; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (u.find(a) != u.find(b)) {
                u.union(a, b);
            } else {
                cnt++;
            }
        }
        sc.close();
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st.add(u.find(i));
        }
        if (st.size() - 1 <= cnt) {
            System.out.println(st.size() - 1);
        } else {
            System.out.println(-1);
        }
    }
}