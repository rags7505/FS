package day39_09_05_2025;

/*
 Mr Toronto working with operators in programming language.
He is given statement S, which is a valid statement and consist of digits [0-9] 
and characters '?', ':', 'Y', 'N', where Y indiactes true and N indicates false.
And the statement conatins only numbers with single digits.
(>=10 value is not allowed)

The operator '?' works as follows:
	- if S="Y?1:2" - as Y means true, it will return 1.
	- if S="N?1:2" - as N means false, it will return 2.

Your task is to help Mr Toronto to execute the statement S and return the result.
The result must be either a digit [0-9] or "Y" or "N".

Input Format:
-------------
A string S, a valid statement.

Output Format:
--------------
Print a string, the result of the statement S.


Sample Input-1:
---------------
Y?N?3:4:2

Sample Output-1:
----------------
4

Explanation:
------------
Given statement is Y?N?3:4:2 -> Y?(N?3:4):2 
Y means "true", So you have to execute N?3:4
N means "false", So the answer is 4.


Sample Input-2:
---------------
N?Y?N?N:Y:N:Y

Sample Output-2:
----------------
Y

Explanation:
------------
Given statement is N?Y?N?N:Y:N:Y -> N?(Y?(N?N:Y):N):Y
N means "false", So the answer is Y.

 */
import java.util.*;
class program3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        sc.close();
        char c[]=s.toCharArray();
        System.out.println(solve(c));
    }
    public static char solve(char []a){
        Stack<Character> st=new Stack<>();
        for(int k=a.length-1;k>=0;k--){
            if(!st.isEmpty()&&st.peek()=='?'){
                st.pop();
                char t=st.pop();
                st.pop();
                char f=st.pop();
                if(a[k]=='Y') st.push(t);
                else st.push(f);
            }
            else{
                st.add(a[k]);
            }
        }
        return st.pop();
    }
}
/* Tejas code */
/*
 import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.next();

        char temp;
        StringBuilder sb = new StringBuilder(inp);
        while (sb.length() > 1) {
            int lastIndex = sb.toString().lastIndexOf("?");
            if (sb.charAt(lastIndex - 1) == 'Y')
                temp = sb.charAt(lastIndex + 1);
            else
                temp = sb.charAt(lastIndex + 3);
            sb = sb.replace( lastIndex - 1,lastIndex + 4, temp );
            
        }

        System.out.println(sb.toString());
    }

}
 */