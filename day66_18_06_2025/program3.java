package day66_18_06_2025;
/*
Ravi is playing with strings.Given Three alphabets [a,b,c] , ravi has to 
make strings such that no two adjacents alphabets are same.

For example, He can make strings as "ab", "acb", "b" and "cbabcabcb" which 
are acceptable.where as the strings "bb", "bcc" and "aabbc" are not acceptable.

Given two integers N and L, Ravi made a list of all acceptable strings of 
length N sorted in lexicographical order.

Return the Lth string of this list or return an empty string if there are less 
than L acceptable strings of length N.

Input Format:
-------------
Line-1: Two space separated integers N and L.

Output Format:
--------------
Print a string result.


Sample Input-1:
---------------
2 3

Sample Output-1:
----------------
ba

Explanation:
-------------
Strings in lexigraphical order are ab,ac,ba,bc,ca,cb. and 3rd one is ba.


Sample Input-2:
---------------
3 4

Sample Output-2:
----------------
acb

Explanation:
------------
Strings in lexigraphical order are aba,abc,aca,acb,bab....
*/
import java.util.*;
class program3{
    static List<String> arr = new ArrayList<>();
    static char [] c = {'a','b','c'};
    public static void generate(String s , int index){
        if(s.length() == index){
            arr.add(s);
            return;
        }
        for(char i : c){
            if(s.isEmpty() || s.charAt(s.length() - 1) != i){
                generate(s + i, index);
            }
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        generate("",n);
        Collections.sort(arr);
        System.out.println(arr.get(l-1));
        sc.close();
    }
}