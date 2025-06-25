package day68_25_06_2025;
/*
Bunny is playing with binary strings. He wants to break
a binary string B into 3 parts, of length atleast '1',
when we merge the 3 parts will result the string B.

Your task is to find the count the various forms to break 
the Binary String B into 3 parts, where each part should 
contain equal number of 1's.


Input Format:
-------------
A string S.

Output Format:
--------------
Print an integer, count the various forms to break.


Sample Input-1:
---------------
01010010

Sample Output-1:
----------------
6

Explanation:
------------
There are six forms to break S into 3 parts 
where each part contain the equal number of  1's.
01 | 01 | 0010
01 | 010 | 010
01 | 0100 | 10
010 | 1 | 0010
010 | 10 | 010
010 | 100 | 10


Sample Input-2:
---------------
010010

Sample Output-2:
----------------
0
 */
/* Someones code */
import java.util.*;

public class program2 {
  public static void main(String [] args){
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      sc.close();
      int ones = 0;
      for(char i : s.toCharArray()){
        if(i == '1'){
          ones++;
        }
      }
      if(ones == 0){
        System.out.println((s.length() - 1) *(s.length() -2) / 2 );
        return;
      }
      int k = ones / 3;
      int x = 0;
      int y = 0;
      int count = 0;
      for(int i = 0 ; i < s.length() ; i++){
      if(s.charAt(i) == '1'){
        count++;
      }
      if(count == k){
        x++;
      }
      else if (count == 2 * k){
        y++;
      }
    }
    System.out.println(x*y);
  }
}
