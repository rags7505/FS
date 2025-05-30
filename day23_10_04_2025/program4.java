package day23_10_04_2025;

/*
You can call two strings X and Y are friendly strings, 
if you can swap two letters in X, so the result is equal to Y.

The condition to swap the letters is as follows:
	Swapping letters is defined as taking two indices i and j (0-indexed) 
	such that i != j and swapping the characters at A[i] and A[j] . 
	For example, swapping at indices 0 and 2 in "abcd" results in "cbad" .

You are given two strings X and Y of lowercase letters, 
return true if X and Y are friendly strings, otherwise return false.

Input Format:
-------------
Two space separated Strings X and Y

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
abcde bacde

Sample Output-1:
----------------
true

Sample Input-2:
---------------
abcde abcde

Sample Output-2:
----------------
false

*/

import java.util.*;
class program4{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        sc.close();
        System.out.println(check(s1,s2));
    }
    public static boolean check(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        int cnt=0;
        char prev1='*',prev2='*';
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(i)) continue;
            if(prev1=='*'){
                prev1=s1.charAt(i);
                prev2=s2.charAt(i);
            }
            else{
                if(prev1!=s2.charAt(i) || prev2!=s1.charAt(i)){
                    return false;
                }
            }
            cnt++;
        }
        if(cnt==0){
            int f[]=new int[26];
            for(char c:s1.toCharArray()){
                f[c-'a']++;
            }
            for(int i=0;i<26;i++){
                if(f[i]>1) return true;
            }
        }
        return cnt==2;
    }
}
