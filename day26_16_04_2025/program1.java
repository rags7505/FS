package day26_16_04_2025;

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
/* mine  */
import java.util.*;
class program1{
    static boolean b=false;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        sc.close();
        Map<Character,String> m=new HashMap<>();
        backtrack(0,0,s1,s2,m);
        System.out.println(b);
    }
    public static void backtrack(int i,int j,String s1,String s2,Map<Character,String> m){
        if(i==s1.length()){
            if(j==s2.length()){
                b=true;
            }
            return;
        }
        for(int k=j;k<s2.length();k++){
            String s=s2.substring(j,k+1);
            if(m.containsKey(s1.charAt(i))){
                if(!m.get(s1.charAt(i)).equals(s)){
                    continue;
                }
                backtrack(i+1,k+1,s1,s2,m);
                if(b) return;
            }
            else{
                if(m.containsValue(s)){
                    continue;
                }
                m.put(s1.charAt(i),s);
                backtrack(i+1,k+1,s1,s2,m);
                if(b) return;
                m.remove(s1.charAt(i));
            }
        }
    }
}
/* some what better code.. */
/*
 * import java.util.*;
public class test{
    public static boolean bt(String s1,String s2,HashMap<Character,String> map,int i,int j){
        // System.out.println(map);
        if(i==s1.length()&&j==s2.length()) return true;
        if(i>=s1.length()||j>=s2.length()) return false;
        if(map.keySet().contains(s1.charAt(i))){
            String v = map.get(s1.charAt(i));
            if(j+v.length()<=s2.length()&&v.equals(s2.substring(j,j+v.length()))){
                return bt(s1,s2,map,i+1,j+v.length());
            }
            return false;
        }
        for(int k=j+1;k<=s2.length();k++){
            map.put(s1.charAt(i),s2.substring(j,k));
            if(bt(s1,s2,map,i+1,k)){
                return true;
            }
        }
        map.remove(s1.charAt(i));
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        HashMap<Character,String> map = new HashMap<>();
        System.out.println(bt(s1,s2,map,0,0));
        
    }
}
 */
