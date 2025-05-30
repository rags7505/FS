package day24_11_04_2025;

/*
Rohan has a habit of writing a word in reverse as R and then checks whether R is same as Original word W. If R is not same as W, he can remove only one character from R to make it as W.
Print 'true', if Rohan makes R equals W, Otherwise print 'false'.

Input Format:
-------------
Line-1: A string represents a word.

Output Format:
--------------
return a boolean result.

Sample Input-1:
---------------
bcba

Sample Output-1:
----------------
true

Explanation:
------------
By removing charcter 'a', we will get the word in reverse is also same.

Sample Input-2:
---------------
abcd

Sample Output-2:
----------------
false

Explanation:
-------------
There is no possibility to make the reverse is also same.

*/

import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        sc.close();
        int i=0,j=s1.length()-1,c=0;
        boolean reverse=true;
        while(i<=j){
            if(s1.charAt(i)==s1.charAt(j)){
                i++;
                j--;
            }
            else{
                if(s1.charAt(i+1)==s1.charAt(j) && c==0){
                    i++;
                    c=1;
                }
                else if(s1.charAt(j-1)==s1.charAt(i) && c==0){
                    j--;
                    c=1;
                }
                else{
                    reverse=false;
                    break;
                }
            }
        }
        System.out.print(reverse);
    }
}
