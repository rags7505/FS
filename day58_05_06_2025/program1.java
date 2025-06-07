package day58_05_06_2025;
/*
Write a Java Program to read a sentence and print each word reversed, but 
maintain the original word order.

Input: 
------
Java is fun

Output:
-------
 avaJ si nuf

*/
import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        sc.close();
        StringBuilder sb=new StringBuilder();
        for(String i:s){
            sb.append((new StringBuilder(i)).reverse().toString());
            sb.append(' ');
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }
}