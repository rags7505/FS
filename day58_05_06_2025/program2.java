package day58_05_06_2025;

/*
Problem 3: 
Write a program that finds the longest substring that reads the same forwards 
and backwards.

Input: 
------
babad

Output: 
-------
bab or aba
*/

import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        sc.close();
        String ans="";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String s2=s.substring(i,j);
                if(ans.length()<s2.length() && isPalindrome(s2)){
                    ans=s2;
                }
            }
        }
        System.out.println(ans);
    }
    public static boolean isPalindrome(String s){
        StringBuilder sb=new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }
}