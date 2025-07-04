package day74_04_07_2025;
/*
Given two strings S1 and S2, find if S2 can match S1 or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and 
distinct non-empty substring in S2, where each non-empty substring in S2
also has a corresponding letter in S1.

Return true,if S2 can match S1.
Otherwise false.

Input Format:
-------------
Line-1 -> Two strings S1 and S2

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
abab kmitngitkmitngit

Sample Output-1:
----------------
true


Sample Input-2:
---------------
aaaa kmjckmjckmjckmjc

Sample Output-2:
----------------
true

Sample Input-3:
---------------
mmnn pqrxyzpqrxyz

Sample Output-3:
----------------
false
*/
import java.util.*;
class program1{
    static boolean flag=false;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        sc.close();
        System.out.println(check(s1,s2));
    }
    public static boolean check(String s1,String s2){
        if(s1.length()>s2.length()) return false;
        Map<Character,String> m=new HashMap<>();
        backtrack(m,s1,s2,0,0);
        return flag;
    }
    public static void backtrack(Map<Character,String> m,String s1,String s2,int i,int k){
        if(i==s2.length() && k==s1.length()){
            flag=true;
            return;
        }
        else if(i==s2.length() || k==s1.length()) return ;
        char c=s1.charAt(k);
        for(int j=i;j<s2.length();j++){
            String s3=s2.substring(i,j+1);
            if(m.containsKey(c) && s3.equals(m.get(c))){
                backtrack(m,s1,s2,j+1,k+1);
                if(flag) return ;
            }
            else if(m.containsKey(c)) continue;
            else if(m.containsValue(s3)) continue;
            else{
                m.put(c,s3);
                backtrack(m,s1,s2,j+1,k+1);
                if(flag) return ;
                m.remove(c);
            }
        }
    }
}