package day12_20_03_2025;

/*
In a School, the math teacher has given a number N between 1000 to 9999.
He asked the students to create two numbers N1 and N2 using the digits of N,
where each digit must be used only once and N1 and N2 must be between 0 to 999 
(leading 0's are allowed). The sum of  N1 and N2 should be minimum.

Your task is to help the students to find the mimimum sum of N1 and N2 using N.

Input Format:
-------------
An integer N.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
7512

Sample Output-1:
----------------
42

Explanation:
------------
The possible numbers of N1 and N2 are,
(125,7), (12,57), (157,2), (17,25) or (15,27),..etc.
Among these 17+25 or 15+27 will give the minimum sum.


Sample Input-2:
---------------
5004

Sample Output-2:
----------------
9

*/
import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        char s[]=sc.next().toCharArray();
        Arrays.sort(s);
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        boolean turn=true;
        for(int i=0;i<4;i++){
            if(turn){
                sb1.append(s[i]);
            }
            else{
                sb2.append(s[i]);
            }
            turn=!turn;
        }
        int val1=Integer.parseInt(sb1.toString());
        int val2 = Integer.parseInt(sb2.toString());
        sc.close();
        System.out.println(val1+val2);
    }
}
