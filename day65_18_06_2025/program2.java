package day65_18_06_2025;
/*
Aruna as a type writer, typing a document in her laptop. Suddently her system got
hacked and whatever she types as words are displaying in reverse and with simple 
braces. She types only lowercase letters.

Inorder to get the actual words, Aruna has to reverse each word starting with the
word which is in innermost most braces and remove those braces.
Help Aruna to get actual words.

Constraints:
------------
  - 0 <= word.length <= 2000
  - Word only contains lower case English characters and parentheses.
    It's guaranteed that all braces are balanced.


Input Format:
-------------
Line-1: a string represents an encoded word.

Output Format:
--------------
return the original string.


Sample Input-1:
---------------
(pqrs)

Sample Output-1:
----------------
srqp


Sample Input-2:
---------------
(uoy(are)woh)

Sample Output-2:
----------------
howareyou

Explanation
------------
Initially "are" will be revesed as "era".
Then (uoyerawoh) will be reversed.
*/
import java.util.*;

public class program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        System.out.println(decodeWord(s));
    }

    public static String decodeWord(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                // Pop until '(' and reverse the substring
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    temp.append(stack.pop());
                }
                stack.pop(); // remove the '('

                // Push reversed substring back
                for (char c : temp.toString().toCharArray()) {
                    stack.push(c);
                }
            } else {
                stack.push(ch);
            }
        }

        // Build final result
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
