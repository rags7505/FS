package day26_16_04_2025;

/*
Ramesh and Suresh are best friends. 
They decided to play a word game.

The game rules are as follows:
	- The game board shows a word W consist of two characters only A and B.
	- You are allowed to replace a pair of neighbour letters AA with BB in W.
	- Finally, The one who failed to replace the letters will lose the game.

You can assume that Ramesh will start playing the game always.

Your task is to determine if Ramesh can guarantee a win.
Print 'true', if Ramesh guarantee a win, otherwise, print 'false'.

Input Format:
-------------
A string W, word.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
AAABAAAA

Sample Output-1:
----------------
true

Explanation:
------------
Given word is AAABAAAA 
Ramesh -> AAABBBAA 
Now whatever the pair Suresh replaced with BB, 
one more replace is possible for Ramesh
So, there is a guarantee for Ramesh to win.

Sample Input-2:
---------------
AAAAAA

Sample Output-2:
----------------
true


Sample Input-3:
---------------
AAABAAA

Sample Output-3:
----------------
false
*/
/* better code */
/*
 * import java.util.*;
public class Test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(wins(s));
    }
    public static boolean wins(String s){
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='A' && s.charAt(i+1)=='A'){
                String next = s.substring(0, i) + "BB" + s.substring(i + 2);
                if(!wins(next)){
                    return true;
            }
            
        }
    }
    return false;
    

}
}
 */
/* my code (not correct....) (just some test cases are passing)*/
/*
 * import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char c[]=s.toCharArray();
        boolean b=backtrack(0,c);
        System.out.println(b);
    }
    public static boolean backtrack(int cnt,char c[]){
        for(int k=0;k<c.length-1;k++){
            if(c[k]=='A' && c[k+1]=='A'){
                c[k]='B';
                c[k+1]='B';
                boolean b=backtrack(cnt+1,c);
                if(!b) return true;
                c[k]='A';
                c[k+1]='A';
            }
        }
        return cnt%2!=0;
    }
}
 */
/* chatgpt */
import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        sc.close();
        char c[]=s.toCharArray();
        System.out.println(backtrack(c));
    }
    public static boolean backtrack(char c[]){
        for(int k=0;k<c.length-1;k++){
            if(c[k]=='A' && c[k+1]=='A'){
                c[k]='B';
                c[k+1]='B';
                boolean b=!backtrack(c);
                c[k]='A';
                c[k+1]='A';
                if(b) return true;
            }
        }
      return false;  
    }
}
