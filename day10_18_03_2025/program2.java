package day10_18_03_2025;

/*
An operating system allows users to switch between open applications using a 
custom Application Switcher. The switcher follows the Most Recently Used (MRU) 
principle, meaning that the last accessed application moves to the front of the queue.

When a user presses the Switch Key (SK) K times, the K-th application in the list 
becomes the most recently used. Your task is to determine the final arrangement 
of applications after K switches.

Constraints
------------
N - The number of applications currently open (1 ≤ N ≤ 100).
K - The number of times the user presses the Switch Key (SK) (0 ≤ K ≤ 10^5).
An array of N unique integers representing application identifiers.

Operations
------------
Each time the user presses the switch key, the next application moves to the front of the list.
The order of other applications remains unchanged.

Input Format
---------------
An integer N - number of applications.
An integer K - number of switch operations.
An array of N integers representing application identifiers.

Output Format
----------------
An array of N integers representing the new order of applications.


Sample Input:
---------------
5
2
10 20 30 40 50

Sample Output:
---------------
[30, 10, 20, 40, 50]

Explanation:
-----------
Initial list: [10, 20, 30, 40, 50]
Press Switch Key once → Moves to 20 → [20, 10, 30, 40, 50]
Press Switch Key twice → Moves to 30 → [30, 10, 20, 40, 50]

Sample Input:
---------------
7
5
5 15 25 35 45 55 65

Sample Output:
----------------
[55, 5, 15, 25, 35, 45, 65]

*/
import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<n;i++) l.add(sc.nextInt());
        k=k%n;
        int val=l.remove(k);
        l.add(0,val);
        System.out.println(l);
        sc.close();
    }
}