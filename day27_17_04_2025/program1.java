package day27_17_04_2025;

/*
Given a integer value N, indicates number of bits in a binary number.

Your task is to design a Binary Code System, where two consecutive 
values in BCS having N bits, must have one bit difference only. 
For example refer the sample testcases.

Find and print the integer values of BCS, starting from 0.


Input Format:
-------------
A integer N, number of bits in BCS

Output Format:
--------------
Print the list of integer values, in BCS form. 


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[0, 1, 3, 2]

Explanation:
------------
00 - 0
01 - 1
11 - 3
10 - 2

Sample Input-2:
---------------
3

Sample Output-2:
----------------
[0, 1, 3, 2, 6, 7, 5, 4]

Explanation:
------------
000 - 0
001 - 1
011 - 3
010 - 2
110 - 6
111 - 7
101 - 5
100 - 4

*/

import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        Set<Integer> s=new LinkedHashSet<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++) sb.append('0');
        generate(sb,s);
        System.out.println(s);
    }
    public static void generate(StringBuilder sb,Set<Integer> s){
        int num=Integer.parseInt(sb.toString(),2);
        if(s.contains(num)) return;
        s.add(num);
        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)=='0'){
                sb.setCharAt(i,'1');
            }
            else{
                sb.setCharAt(i,'0');
            }
            int num1=Integer.parseInt(sb.toString(),2);
            if(s.contains(num1)){
                sb.setCharAt(i,sb.charAt(i)=='0'?'1':'0');
                continue;
            }
            generate(sb,s);
        }
    }
}
