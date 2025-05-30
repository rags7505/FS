package day37_07_05_2025;

/*
Pramod plans to design a program that generates all possible valid IP addresses from a given string S.
It is guaranteed that S contains only digits.

Help Pramod by designing a program that returns all valid IP addresses generated from S.
The IP addresses must be printed in lexicographic order.

Note:

- A valid IP address consists of exactly four integers, each ranging from 0 to 255, separated by single dots (.).
- IP address segments cannot contain leading zeros.
- Valid IP addresses must fall within the range 0.0.0.0 to 255.255.255.255.

Examples of invalid IP addresses: 123.012.234.255, 123.234.345.34.

Input Format:
-------------
A string S, contains only digits [0-9].

Output Format:
--------------
Print all possible IP addresses which are valid.


Sample Input-1:
---------------
23323311123

Sample Output-1:
----------------
[233.233.11.123, 233.233.111.23]


Sample Input-2:
---------------
12345678

Sample Output-2:
----------------
[1.234.56.78, 12.34.56.78, 123.4.56.78, 123.45.6.78, 123.45.67.8]


Sample Input-3:
---------------
02550255

Sample Output-3:
----------------
[0.25.50.255, 0.255.0.255]

*/

import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        List<String> l=new ArrayList<>();
        generate(0,0,s,l,new StringBuilder());
        System.out.println(l);
    }
    public static void generate(int i,int cnt,String s,List<String> l,StringBuilder sb){
        if(cnt==4){
            if(i==s.length()){
                sb.deleteCharAt(sb.length()-1);
                l.add(sb.toString());
                sb.append('.');
            }
            return;
        }
        for(int k=i;k<s.length();k++){
            String s1=s.substring(i,k+1);
            if(s1.length()>3) return;
            if(s1.equals("0") || (!s1.startsWith("0") && Integer.parseInt(s1)<=255)){
                int len=sb.length();
                sb.append(s1+".");
                generate(k+1,cnt+1,s,l,sb);
                sb.setLength(len);
            }
        }
    }
}