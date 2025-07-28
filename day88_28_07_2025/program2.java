package day88_28_07_2025;
/*
Consider a pair of integers, (a,b). The following operations can be performed 
on (a,b) in any order, zero or more times:
	- (a,b) -> ( a+b, b )
	- (a,b) -> ( a, a+b )

For example, starting with (1,1), perform the operation (1, 1+1) to get (1,2), 
perform the operation (1+2, 2) to get (3,2), and perform the operation (5,2). 
Alternatively the first operation could be (1+1, 1) to et (2,1) and so on.

Your task is to build a function must return a string that denotes whether you 
can convert (a,b) to (c,d) by performing zero or more operations specified 
above? or not. 

If it is possible, return true, otherwise false.

NOTE: 
1<= a,b,c,d <= 1000

Input Format:
-------------
Line-1: Two space separated integers, a,b
Line-2: Two space separated integers, c,d

Output Format:
--------------
Return a boolean value.


Sample Input-1:
---------------
1 2
5 4

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 3
10 7

Sample Output-2:
----------------
false
*/
/* chatgpt */
import java.util.*;

public class program2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();
    sc.close();
    System.out.println(canConvert(a, b, c, d));
  }

  public static boolean canConvert(int a, int b, int c, int d) {
    while (c >= a && d >= b) {
      if (c == a && d == b) {
        return true;
      }
      if (c > d) {
        c -= d;
      } else {
        d -= c;
      }
    }
    return false;
  }
}
/* dfs */
/*
import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        sc.close();
        System.out.println(dfs(a,b,c,d));
    }
    public static boolean dfs(int a,int b,int c,int d){
        if(a>c || b>d) return false;
        if(a==c && b==d) return true;
        return dfs(a+b,b,c,d) || dfs(a,b+a,c,d);
    }
}
*/
/* BFS */
/*
import java.util.*;

class program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // start a
        int b = sc.nextInt(); // start b
        int c = sc.nextInt(); // target c
        int d = sc.nextInt(); // target d
        sc.close();

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});

        boolean found = false;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            if (x > c || y > d) continue;
            if (x == c && y == d) {
                found = true;
                break;
            }

            // Generate both possible moves
            queue.offer(new int[]{x + y, y});
            queue.offer(new int[]{x, x + y});
        }

        System.out.println(found);
    }
}

*/