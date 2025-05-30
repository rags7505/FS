package day30_24_04_2025;
import classes.DSU;
/* ## There are N computers in a network, all the computers are connected as tree 
structure. And one new connection is added in the Network. The computers in 
the network are identified with their IDs, the IDs are numbered between 1 to N.

The connections in the network is given as coonection[i] = [comp-A, comp-B], 
there is a connection between comp-A and comp-B.

Your task is to remove a connection in the network and print it, so that 
all the computers are connected as tree structure. If there are multiple 
options to remove, remove the connection that occurs last in the input.


Input Format:
-------------
Line-1: Two space separated integers N, number of computers.
Next N lines: Two space separated integers, comp-A & comp-B.

Output Format:
--------------
Print the connection which is removed.


Sample Input-1:
---------------
6
1 2
3 4
3 6
4 5
5 6
2 3

Sample Output-1:
---------------
5 6


Sample Input-2:
---------------
4
1 2
2 3
3 4
2 4

Sample Output-2:
---------------
2 4 */
import java.util.*;
class program1{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    DSU u = new DSU(n);
    int a[][] = new int[n][2];
    int a1 = 0, a2 = 0;
    for (int i = 0; i < n; i++) {
      a[i][0] = sc.nextInt();
      a[i][1] = sc.nextInt();
      if (u.find(a[i][0]) == u.find(a[i][1])) {
        a1 = a[i][0];
        a2 = a[i][1];
      } else
        u.union(a[i][0], a[i][1]);
    }
    System.out.println(a1 + " " + a2);
    sc.close();
  }
}
