package day73_03_07_2025;
/*
 Prabhath is working on words.  He used to take out every letter that was repeated 
in the word. 
A word W is given to Prabhath. His objective is to eliminate every duplicate 
letter from W such that the resultant word R contains every unique letter from W
and did not contain any duplicate letters. 
And R should be at the top of the dictionary order.

NOTE:
-----
He is not allowed to shuffle the relative order of the letters of the word W to
create the word R.

Input Format:
-------------
A String, the word W.

Output Format:
--------------
Print a String, resultant word R.


Sample Input-1:
---------------
cbadccb

Sample Output-1:
----------------
adcb


Sample Input-2:
---------------
silicosis

Sample Output-2:
----------------
ilcos
 */
/* John code */
import java.util.*;
public class program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c))
                continue;
            while (!stack.isEmpty() && stack.peek() > c && lastIndex.get(stack.peek()) > i) {
                set.remove(stack.pop());
            }
            stack.push(c);
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}