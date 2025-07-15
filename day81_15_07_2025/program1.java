package day81_15_07_2025;
/*
There are M*N buckets of milk, all the buckets are equal in size (in ltrs).
The buckets are initially filled with different amounts of milk in liters.

You are given the amount of milk in the buckets as a grid of size M x N, 
buckets[][]. You need to make that all the buckets have same quantity of Milk.
You are allowed to perform one operation either adding M liters of Milk
or take away M liters of Milk from the bucket in one step.

Your task is to return the minimum number of steps required to make 
all the buckets in the bucket grid contains same amount of Milk. 
If it is not possible, return -1.

Input Format:
-----------------
Line-1: three space sepaarted integers, A, B and M.
Next A lines: B space sepaarted integers, amount of milk in liters.

Ourput Format:
-------------------
Print the integer result.


Sample Input-1:
-----------------
2 3 5
5 10 15
20 25 40

Sample Output-1:
-------------------
11

Explanation: 
------------
We can make every bucket has equal amount of Milk to 4liters by doing
the following: 
- Add 5ltrs milk to 5ltrs bucket 3 times.
- Add 5ltrs milk to 10ltrs bucket 2 times.
- Add 5ltrs milk to 15ltrs bucket 1 time.
- Takeaway 5ltrs milk from 25ltrs bucket 1 time.
- Takeaway 5ltrs milk from 40ltrs bucket 4 times.
A total of 11 operations required.


Sample Input-2:
-----------------
3 3 3
1 2 3 4
5 6 7 8
9 19 11 12

Sample Output-2:
-------------------
-1
*/
/* chatgpt */
import java.util.*;
class program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int M = sc.nextInt();
        int[][] buckets = new int[A][B];
        
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                buckets[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(minStepsToEqualBuckets(buckets, M));
    }

    private static int minStepsToEqualBuckets(int[][] buckets, int M) {
        List<Integer> milkAmounts = new ArrayList<>();
        
        // Collect all milk amounts
        for (int[] row : buckets) {
            for (int milk : row) {
                milkAmounts.add(milk);
            }
        }
        
        int minSteps = Integer.MAX_VALUE;
        
        // Try each bucket's current amount as a potential target
        for (int target : milkAmounts) {
            boolean possible = true;
            int steps = 0;
            
            for (int milk : milkAmounts) {
                if ((milk - target) % M != 0) {
                    possible = false;
                    break;
                }
                steps += Math.abs(milk - target) / M;
            }
            
            if (possible) {
                minSteps = Math.min(minSteps, steps);
            }
        }
        
        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }
}
/* Tejas code (Best and optimal) */
/*
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int m = sc.nextInt();
        int n = r * c;
        int[] arr = new int[n];

        int mod = -1;
        boolean possible = true;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (mod == -1) 
                mod = arr[i] % m;
            else if (arr[i] % m != mod)
                possible = false;
        }

        if (!possible) {
            System.out.println("-1");
            return;
        }

        int[] norm = new int[n];
        for (int i = 0; i < n; i++) {
            norm[i] = arr[i] - mod;
        }

        Arrays.sort(norm);
        int median = norm[n / 2];

        int moves = 0;
        for (int i = 0; i < n; i++) {
            moves += Math.abs(norm[i] - median)/m;
        }

        System.out.println(moves);
    }

}
*/
/* John code (Similar to tejas not similar , same) (Easy to understand) */
/*
import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();
        int [][] grid = new int[a][b];
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                list.add(grid[i][j]);
            }
        }
        int mod = list.get(0) % m;
        for(int val : list){
            if(val % m != mod){
                System.out.println(-1);
                return;
            }
        }
        Collections.sort(list);
        int steps = 0;
        int median = list.get(list.size() / 2);
        for(int val : list){
            steps += Math.abs(val - median) / m;
        }
        System.out.println(steps);
    }
}
*/