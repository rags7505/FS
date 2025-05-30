package day36_05_05_2025;
/* 
Kittu playing a game, the game contains a panel of N cells.
Each cell in the panel is a number panel[i], 
Kittu will win when he reaches 0.

The rules to play the game are as follows:
	- Kittu's intital position is S.
	- When Kittu is at index i, he can move to position-(i + panel[i] ) or 
	position-(i - panel[i]).
	- Kittu cannot move outside the panel.
	- if he reaches any panel[i] has value 0, He wins.	

Your task to find that whether kittu wins or not.
if he wins print "true".
if there is no way to reach 0 then print "false".

NOTE: cell positions are numbered from 0 to N-1.
0<= panel[i] < N


Input Format:
-------------
Line-1: Two integers N and S, number of cells in the panel and 
		Kittu's initial position.
Line-2: N space separated integers.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
7 5
4 2 3 0 3 1 2

Sample Output-1:
----------------
true

Explanation: 
------------
All possible ways to reach at position 3 with value 0 are: 
position 5 -> position 4 -> position 1 -> position 3 
position 5 -> position 6 -> position 4 -> position 1 -> position 3 


Sample Input-2:
---------------
5 2
3 0 2 1 2

Sample Output-2:
----------------
false

*/

import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int pos=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        boolean v[]=new boolean[n];
        System.out.println(check(a,v,pos));
    }
    public static boolean check(int []a,boolean[] b,int st){
        if(st>=a.length || st<0||b[st]) return false;
        if(a[st]==0) return true;
        b[st]=true;
        return check(a,b,st+a[st]) || check(a,b,st-a[st]);
    }
}