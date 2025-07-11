package day48_22_05_2025;

/*
Sampoornesh Babu is working with Strings.
He is trying to form a palindrome using two strings P and Q.
The rules to form the palindrome are as follows:
	- Divide the strings P and Q into two parts, and length of P and Q are same.
	- Division of P and Q should be done at same index position.
	- After Division P -> P1 + P2 and Q -> Q1 + Q2, where + indicates concatenation.
	- Now, check whether P1 + Q2 or Q1 + P2 forms a palindrome or not.
	- if palindrome is formed print 'true', otherwise 'false'. 

For Example: 'job' can be divided in the following ways:
""+"job", "j"+"ob",  "jo"+"b", "job"+"".

Your task is to help Sampoornesh Babu to find whether palindrome can be 
formed with the strings P and Q.

Input Format:
-------------
Two space separated strings P and Q

Output Format:
--------------
Print a boolean value, whether can you form a palindrome or not.


Sample Input-1:
---------------
mortal carrom

Sample Output-1:
----------------
true

Explanation:
------------
Divide P="mortal" and Q="carrom" at index 3 as follows:
    P -> "mor" + "tal", P1 = "mor" and P2 = "tal"
    Q -> "car" + "rom", Q1 = "car" and Q2 = "rom"

P1 + Q2 = "morrom" is a palindrome,so print true.


Sample Input-2:
---------------
romans carrom

Sample Output-2:
----------------
false
*/
/* not optimal */
import java.util.*;
public class program1{
    public static boolean isPalin(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    public static boolean checkPalindromeFormation(String a, String b) {
        if(a.length()==1)return true;
        for(int i=0;i<a.length();i++){
            String ap=a.substring(0,i);
            String as=a.substring(i,a.length());
            String bp=b.substring(0,i);
            String bs=b.substring(i,b.length());
            if(isPalin(ap+bs) || isPalin(bp+as))return true;
        }
        return false;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2 = sc.next();
        sc.close();
        System.out.println(checkPalindromeFormation(s1,s2));
    }
}
/* Optimal code (simmu) */
/*
 import java.util.*;

public class DSAprogram1 {
    private static boolean sol(String s1, String s2) {
        int i = 0, j = s1.length() - 1;
        while(i < j) {
            if(s1.charAt(i) != s2.charAt(j)) break;
            i++;
            j--;
        }        

        // System.out.println(i + " " + j);
        return isPalindrome(s1, i, j) || isPalindrome(s2, i, j);
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(sol(s1, s2) || sol(s2, s1));
    }
}
 */