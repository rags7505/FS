package day66_23_06_2025;
/*
Mr Rajendra Tapadia is given a number N as string to Mr Satyam, and ask him 
to find the number of ways to make that number N equal to zero by using 
the following steps:
    - He need to perform either '+' or '-' operation between two adjacent digits
    - You can repeat the above step to make the N value to 0.
    
For example: if N is 454522 then it's possible to perform the '+'/'-' operations 
the following way, 4+5-4-5-2+2, 4-5-4+5-2+2, 4+5-4-5+2-2 or 4-5-4+5+2-2.
A total of 4 ways.

Your task is to help Mr Satyam to find the number of ways possible to make N to 0
using the above steps. Print "invalid", if it is not possible.

Input Format:
-------------
A String, the number N.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
13741

Sample Output-1:
----------------
2

Explanation: 
------------
The ways are, 1+3-7+4-1 and 1-3+7-4-1.


Sample Input-2:
---------------
2351

Sample Output-2:
----------------
invalid
*/
/* Simmu's code */
import java.util.*;

public class program1 {
    static Map<String, Integer> hm = new HashMap<>();

    private static String sol(String s) {
        int[] inp = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
        int count = dfs(inp, 1, inp[0]);
        return count == 0 ? "invalid" : String.valueOf(count);
    }

    private static int dfs(int[] arr, int idx, int accum) {
        if (idx == arr.length) {
            return accum == 0 ? 1 : 0;
        }

        String key = idx + ":" + accum;
        if (hm.containsKey(key))
            return hm.get(key);

        int ways = dfs(arr, idx + 1, accum + arr[idx]) + dfs(arr, idx + 1, accum - arr[idx]);
        hm.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(sol(s));
    }
}
/*Tejas code */
/*
 import java.util.*;
class Solution{
    private static int check(char[] arr, int index, int sum){
        if(index==arr.length){
            if(sum==0) return 1;
            return 0;
        }
        
        return check(arr,index+1,sum+(arr[index]-'0'))+check(arr,index+1,sum-(arr[index]-'0'));
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.next();
        
        if (inp.length() == 0){
            System.out.println("invalid");
            return;
        }
        
        char[] arr = inp.toCharArray();
        int ans = check(arr,1,arr[0]-'0');
        

        if(ans!=0)
            System.out.println(ans);
        else 
            System.out.println("invalid");
    }
}
 */
/* Same code */
/*
 import java.util.*;
public class program1 {
    static Map<String, Integer> m = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int a[]=new int[s.length()];
        int i=0;
        for(char c:s.toCharArray()){
            a[i++]=Integer.parseInt(c+"");
        }
        int count = dfs(a, 1, a[0]);
        System.out.println(count == 0 ? "invalid" : count);
    }
    public static int dfs(int[] arr, int idx, int val) {
        if(idx == arr.length) {
            return val == 0 ? 1 : 0;
        }
        String key = idx + ":" + val;
        if(m.containsKey(key)) return m.get(key);
        int ways = dfs(arr, idx + 1, val + arr[idx]) + dfs(arr, idx + 1, val - arr[idx]);
        m.put(key, ways);
        return ways;    
    }
}
*/