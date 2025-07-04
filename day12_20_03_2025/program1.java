package day12_20_03_2025;

/*
A crew of N players played a game for one time, and got some scores.
They have to stand in the same positions after they played the game.
 
There is a constraint that, the player-K score, should not be greater or smaller 
than both of his neighbors. To achieve this constraint, there are few steps 
to be followed as mentioned:
    	- If the score of player-K is smaller than both his neighbors,
    	  then his score is incremented by 1.
    	- If the score of player-K is greater than both his neighbors,
    	  then his score is decremented by 1.
    	- The first and last elements never change.
    	- Repeat these steps, until the constraint is satisified.
   
Your task is to find and print the resultant array of scores, after the constraint is achieved.
   
NOTE: Players are not allowed to swap their positions to achieve the constraint.
  
Input Format:
-------------
Line-1: An integer N, number of players.
Line-2: N space separated integers represemts scores of each player.
  
Output Format:
--------------
Print integer array, the resultant scores.
   
Sample Input-1:
---------------
6
4 3 5 2 6 3
  
Sample Output-1:
----------------
[4, 4, 4, 4, 4, 3]
   
   
Sample Input-2:
---------------
8
5 1 4 2 7 4 6 3
  
Sample Output-2:
----------------
[5, 3, 3, 3, 5, 5, 5, 3]
*/
import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        boolean flag=true;
        while (flag) {
          flag = false;
          int[] temp = Arrays.copyOf(a, n);
          for (int i = 1; i < n - 1; i++) {
            if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
              temp[i]--;
              flag = true;
            } else if (a[i] < a[i - 1] && a[i] < a[i + 1]) {
              temp[i]++;
              flag = true;
            }
          }
          a = temp;
        }
        sc.close();
        System.out.println(Arrays.toString(a));
    }
}
