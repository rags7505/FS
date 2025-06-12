package Other_codes_Drives.copart_programs;
/*
 Question: 8

Love Letter

You write a love letter to your friend. However, before your friend can read it. someone else takes it and rotates the characters of
each word left to right K times. Find the number of words that remain the same even after this shifting of letters.

Note: There can be more than one spaces between the words.

Input Specification:
-------------------
input1: String of words

input2: K. number of times rotation happens

Output Specification:
---------------------
Your function should return the number of correct words.

Example 1:
----------
input1: llohe ereth

input2: 2

Output: 0

Explanation:
-------------
In examplet llohe ereth is a rotated string, mence the original string was hello there which is not correct. Hence answer is 0.

Example 2:
----------
input1: adaada

input2: 3

Output:1

Explanation:
------------
inexample 2 adaada when rotated 3 times gives back "adaada". Hence answer is 1

 */
import java.util.*;
class program8{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int k=sc.nextInt();
        sc.close();
        int ans=0;
        for(String i:s){
            int k1=k%i.length();
            String s1=i.substring(k1)+i.substring(0,k1);
            if(s1.equals(i)) ans++;
        }
        System.out.println(ans);
    }
}