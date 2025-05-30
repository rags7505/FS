package day51_27_05_2025;
/*
You are a robot explorer navigating a vast digital maze stored as a string of 
digits. Each digit or pair of digits on the path represents a movement
instruction, which translates to a specific direction using the following map:

"1" → Move 'A'

"2" → Move 'B'

...

"26" → Move 'Z'

However, the maze has tricky encoding rules. Sometimes a single digit can be 
read alone, and sometimes two digits together form a valid move — but not every 
combination is valid. 

For example, "05" is invalid, while "5" is fine. Your robot
can only navigate using valid instruction steps, and you must find how many 
unique navigation sequences the robot can follow to reach the end of the maze.

Given the string s of digits, determine the total number of distinct ways the
robot can interpret and follow the path from start to end without making an 
invalid move.

If no valid navigation is possible, return 0.


Input Format:
-------------
A string s.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
123

Sample Output-1:
----------------
3

Explanation:
------------
123 can be converted as: ABC, LC, AW


Sample Input-2:
---------------
326

Sample Output-2:
----------------
2

Explanation:
------------
326 can be converted as: CBF, CZ
*/
/*Mine , Backtracking */
import java.util.*;
class program2{
    static int ans=0;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        sc.close();
        count(s,0);
        System.out.println(ans);
    }
    public static void count(String s,int i){
        if(i==s.length()){
            ans++;
            return;
        }
        for(int k=i;k<s.length();k++){
            String s1=s.substring(i,k+1);
            if(s1.equals("0") || s1.length()>2 || s1.charAt(0)==0 || Integer.parseInt(s1)>26){
                return;
            }
            count(s,k+1);
        }
    }
}
/*Chatgpt */
/*
public class MazeDecoder {

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;  // Empty string
        dp[1] = 1;  // First char already validated

        for (int i = 2; i <= n; i++) {
            char one = s.charAt(i - 1);
            char two1 = s.charAt(i - 2);
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            // Check 1-digit valid move
            if (one != '0') {
                dp[i] += dp[i - 1];
            }

            // Check 2-digit valid move
            if (two1 != '0' && twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s1 = "123";
        System.out.println(numDecodings(s1));  // Output: 3

        String s2 = "326";
        System.out.println(numDecodings(s2));  // Output: 2
    }
}
*/
/* Tejas code (Memorization)*/
/*
class Solution{
    private static int check(int i, String inp,int[] dp){
        if(i<=0) return 1;
        
        if(dp[i]!=-1) return dp[i];
        
        int onePick=0;
        int twoPick=0;
        if(inp.charAt(i)!='0')
            onePick = check(i-1,inp,dp);
        if(inp.charAt(i-1)!='0' && Integer.parseInt(inp.substring(i-1,i+1))<=26)
        twoPick = check(i-2,inp,dp);
        
        return dp[i]=onePick+twoPick;
    } 
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.next();
        int[] dp = new int[inp.length()];
        Arrays.fill(dp,-1);
        System.out.println(check(inp.length()-1,inp,dp));
*/
/* Tejas code (Tabulation) */
/*
 import java.util.*;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.next();
        int[] dp = new int[inp.length()+1];
        if(inp.charAt(0)=='0'){
            System.out.println("0");
            return;
        }
        
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=inp.length();i++){
            int onePick=0;
            int twoPick=0;
             if(inp.charAt(i-1)!='0')
                onePick = dp[i-1];
            if(inp.charAt(i-2)!='0' && Integer.parseInt(inp.substring(i-2,i))<=26)
                twoPick = dp[i-2];
                
            dp[i]=onePick+twoPick;
        }
        
        System.out.println(dp[dp.length-1]);
    }
}
 */