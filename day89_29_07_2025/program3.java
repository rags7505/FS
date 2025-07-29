package day89_29_07_2025;
/*Somesh is given a task to you on Strings.
You have given a string S ([a-z]), and an integer array Arr[]
Now your task is to modify 'S' in such way:
replace the 'i+1' characters in the string, with next i-th character 
in alphabetic order(cyclic).

For example, if S="art", Arr[]=[2,3,5] is 3, 
i=0, modify('a') = 'c' , S="crt".
i=1, modify('c') = 'f', modify('r') = 'u', S="fut".
i=2, modify('f') = 'k', modify('u') = 'z', modify('t') = 'y', S="kzy"
Finally modified string is 
kzy. 

Note: if arr[i]=3 modify('z') ='c'

Return the final modified string after all such modifications to S are applied.

Input Format:
-------------
Line-1 -> A String S, length of S is L
Line-2 -> L space separated integers.

Output Format:
--------------
Print modifed String.


Sample Input-1:
---------------
adbp
1 2 3 4

Sample Output-1:
----------------
kmit
 */

import java.util.*;

public class program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] k = sc.nextLine().split(" ");
        sc.close();
        int n = k.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(k[i]);
        int cur = 0;
        char[] c = s.toCharArray();
        while (cur < n) {
            for (int i = 0; i <= cur; i++) {
                c[i] = (char) ('a' + (c[i] - 'a' + arr[cur]) % 26);
            }
            cur++;
        }
        String res = new String(c);
        System.out.print(res);
    }
}
