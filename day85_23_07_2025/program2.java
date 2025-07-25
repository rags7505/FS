package day85_23_07_2025;
/*
Vihaan is given a list of words[]. 
He is asked to create a method which returns the numbers of characters in a word 
formed from long lasting frequent posteriority.

Posteriority is the word formed from the original word with few characters removed
without modifying the corresponding order of the left over characters.

An uncommon posteriority between the list of words is a word that is a posteriority
of one word but not the others.

Your task is to find the longest uncommon posteriority of the list of words.
Return 0 if no uncommon posteriority.


Input Format:
-------------
Space separated strings words[]

Output Format:
--------------
Print an integer, the length of longest uncommon prosperity.


Sample Input-1:
---------------
mom rar ama

Sample Output-1:
----------------
3


Sample Input-2:
---------------
ppp ppp pp

Sample Output-2:
----------------
-1
*/
import java.util.*;
public class program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        sc.close();
        System.out.println(check(s));
    }
    private static boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == a.length();
    }
    public static int check(String[] s) {
        int maxLen = -1;
        for (int i = 0; i < s.length; i++) {
            boolean flag = true;
            for (int j = 0; j < s.length; j++) {
                if (i == j) continue;
                if (isSubsequence(s[i], s[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                maxLen = Math.max(maxLen, s[i].length());
            }
        }
        return maxLen;
    }
}
