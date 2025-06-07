/*

Write a Java code to return the length of longest sub-string without repeating 
characters

Sample Input: 
-------------
abcabcbb

Sample Output: 
--------------
3


*/
import java.util.*;
class Solution2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        sc.close();
        Map<Character,Integer> m=new HashMap<>();
        int l=0,ans=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            m.put(c,m.getOrDefault(c,0)+1);
            while(m.get(c)>1){
                char c1=s.charAt(l++);
                m.put(c1,m.get(c1)-1);
                if(m.get(c1)==0) m.remove(c1);
            }
            ans=Math.max(ans,i-l+1);
        }
        System.out.println(ans);
    }
}