package day16_27_03_2025;

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
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int maxLen=0,sid=-1;
        for (int i = 0; i < s.length(); i++) {
          for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            if (sub.length() > maxLen && isHarmoni(sub)) {
              sid = i;
              maxLen = sub.length();
            }
          }
        }
        sc.close();
        System.out.print(sid==-1?"":s.substring(sid,sid+maxLen));
    }
    public static boolean isHarmoni(String s){
        int u[]=new int[26];
        int l[]=new int[26];
        for(char c:s.toCharArray()){
            if(Character.isUpperCase(c)){
                u[c-'A']++;
            }
            else{
                l[c-'a']++;
            }
        }
        for(int i=0;i<26;i++){
	    if(u[i]==0 && l[i]==0) continue;
            if((u[i]==0 && l[i]!=0) || (l[i]==0 && u[i]!=0)) return false;
        }
        return true;
    }
}
