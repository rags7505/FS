package day84_22_07_2025;
/*
Sumanth has an idea to calculate the ABD value of a string.
An ABD value is defined as the absolute diffrence between
the most occurance count of a charcter and the least occurance count 
of another character in the given string.

Sumanth is given a string S,
He wants to find out, the sum of ABD values of all the substrings of S,
where ABD > 0.

Your task is to help Sumanth to find total ABD value of substrings of S.

Input Format:
-------------
A String S

Output Format:
--------------
Print an integer, sum of ABD of all the strings of S


Sample Input-1:
---------------
abbcc

Sample Output-1:
----------------
5

Explanation: 
------------
The substrings with non-zero ABD are as follows:
Substring and ABD value -> "abb"-1,"abbc"-1,"abbcc"-1,"bbc"-1,"bcc"-1
The total sum of ABD is, 5


Sample Input-2:
---------------
abcbabc

Sample Output-2:
----------------
15

Explanation: 
------------
The substrings with non-zero ABD are as follows:
substring and ABD value -> "abcb"-1,"abcba"-1,"abcbab"-2,"abcbabc"-1,"bcbabc"-2
"bcbab"-2, "bcba"-1, "bcb"-1, "cbab"-1,"cbabc"-1,"bab"-1, "babc"-1.
The total sum of ABD is, 15
*/
import java.util.*;
class program3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        sc.close();
        int ans=0;
        for(int i=0;i<s.length();i++){
            int max=0;
            int f[]=new int[26];
            Set<Character> st=new HashSet<>();
            for(int j=i;j<s.length();j++){
                char c=s.charAt(j);
                f[c-'a']++;
                st.add(c);
                max=Math.max(max,f[c-'a']);
                if(st.size()<2) continue;
                int min=Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                    if(f[k]>0) min=Math.min(min,f[k]);
                }
                ans+=Math.abs(max-min);
                // System.out.println(s.substring(i,j+1)+" "+max+" "+min+" "+ans);
            }
        }
        System.out.println(ans);
    }
}