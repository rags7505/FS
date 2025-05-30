package day21_08_04_2025;

/*
In the context of linguistic harmony, we define a "harmonious string" as a string where 
every alphabet it contains appears both in uppercase and lowercase forms. For instance, 
a string like "pqQpP" is harmonious because it has both 'P' and 'p' as well as 'Q' and 'q'. 
Conversely, a string like "pqP" is not harmonious as it fails to meet this condition, 
with 'q' present while 'Q' is absent.

Your are given a string S, your task is  to return the longest harmonious substring in S. 
If there are multiple answers meeting this criterion, you should return the one that appears 
earliest in the string. If there is no harmonious substring, you should return an empty string.

Input Format:
-------------------
A string S

Output Format:
-------------------
Prin the longest harmonious string.


Sample Input:
--------------
QcvcCcq

Sample Output:
---------------
cCc


Sample Input:
--------------
pqrs

Sample Output:
--------------
""

*/

import java.util.*;
class program4{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        sc.close();
        String ans="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String s1=s.substring(i,j+1);
                if(s1.length()>ans.length() && harmonious(s1)){
                    ans=s1;
                }
            }
        }
        System.out.print(ans);
    }
    public static boolean harmonious(String s){
        int l[]=new int[26];
        int u[]=new int[26];
        for(char c:s.toCharArray()){
            if(Character.isUpperCase(c)){
                u[c-'A']++;
            }
            else l[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(u[i]==l[i]) continue;
            if(u[i]==0 && l[i]!=0 ) return false;
            if(u[i]!=0 && l[i]==0) return false;
        }
        return true;
    }
}
