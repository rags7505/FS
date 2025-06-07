/*

Problem: 
Write Java code to identify if given two strings are Anagrams 
(strings that contain same set of alphabets)

Sample Input: 
-------------
listen silent

Sample Output: 
--------------
true

*/
import java.util.*;
class Solution4{
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
        int f[]=new int[26];    
        for(int i=0;i<s1.length();i++){
            f[s1.charAt(i)-'a']++;
            f[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(f[i]!=0) return false;
        }
        return true;
    }
}