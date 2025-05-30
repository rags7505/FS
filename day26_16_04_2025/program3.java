package day26_16_04_2025;

/*
An valid bracket arrangement is either "", "[" + A + "]", 
or A + B, where A and B are valid bracket arrangements 
and + represents string concatenation.

For example, "", "[]", "[[]]", and "[[][[]]]" are all valid bracket combinations.
A non-empty valid bracket arrangement is called authentic bracket string.
If an authentic bracket string s can be divided into s = A + B, where A and B 
are valid bracket strings and non-empty.

Consider the following basic partitioning of an authentic bracket string S, 
S = P1 + P2 +... + Pk, where Pi are basic authentic bracket string.

Return S after deleting the outermost brackets of each authentic string in S's partitioning.


INPUT FORMAT:
-------------
A String S, consists of '[' and ']' brackets only.

OUTPUT FORMAT:
--------------
Print S after deleting the outermost brackets.


SAMPLE INPUT-1:
---------------
[[]][[][]][]

SAMPLE OUTPUT-1:
----------------
[][][]


SAMPLE INPUT-2:
---------------
[[][]][[]][[][[]]]


SAMPLE OUTPUT-2:
----------------
[][][][][[]]
*/

import java.util.*;
class program3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        sc.close();
        StringBuilder sb=new StringBuilder();
        int open=0;
        for(char c:s.toCharArray()){
            if(c=='[' && open++>0) sb.append(c);
            else if(c==']' && open-->0) sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
