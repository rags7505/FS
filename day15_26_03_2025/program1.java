package day15_26_03_2025;

/*
You have been tasked with managing scores in a unique game. 
The game begins with an empty scorecard. You are provided with a list 
of operations represented as a string of characters, denoted as operations[i], 
each corresponding to a specific action. These actions include:

A digit S: This means you should add a new score of S to the scorecard.
'A': This means you should add a new score to the scorecard, 
	which is the addition of the last two scores.
'D': This means you should add a new score to the scorecard, 
	which is double the value of the previous score.
'R': This means you should invalidate the previous score, 
	removing it from the scorecard.
	
Your objective is to calculate the sum of all the scores that remain on
the scorecard after performing all the specified operations.


Input Format:
-------------
A string consists of characters, represents series of operations.

Output Format:
--------------
An integer result.


Sample Input-1:
---------------
526RDAA

Sample Output-1:
----------------
27

Explanation:
-----------
'5' - Add 5 to the scorecard, scorecard is now [5].
'2' - Add 2 to the scorecard, scorecard is now [5, 2].
'6' - Add 6 to the scorecard, scorecard is now [5, 2, 6].
'R' - Invalidate and remove the previous score, scorecard is now [5, 2].
'D' - Add 2 * 2 = 4 to the scorecard, scorecard is now [5, 2, 4].
'A' - Add 2 + 4 = 6 to the scorecard, scorecard is now [5, 2, 4, 6].
'A' - Add 4 + 6 = 10 to the scorecard, scorecard is now [5, 2, 4, 6, 10].
The total sum is 5 + 2+ 4 + 6 + 10 = 27.


Sample Input-2:
---------------
1R

Sample Output-2:
----------------
0
*/
import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        List<Integer> l=new ArrayList<>();
        for (char c : s.toCharArray()) {
          if (Character.isDigit(c)) {
            l.add(c - '0');
          } else {
            if (c == 'R')
              l.remove(l.size() - 1);
            else if (c == 'D') {
              int el = l.get(l.size() - 1);
              l.add(el * 2);
            } else {
              int num1 = l.get(l.size() - 1);
              int num2 = l.get(l.size() - 2);
              l.add(num1 + num2);
            }
          }
        }
        sc.close();
        int sum=0;
        for(int i:l) sum+=i;
        System.out.println(sum);
    }
}
