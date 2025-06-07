package day58_05_06_2025;

/*
Problem 4: 
Write a program that reads a sentence, count and display the total number of 
vowels and consonants.

Input: 
------
Hello World

Output:
-------
Vowels: 3, Consonants: 7
*/
import java.util.*;
class program4{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        sc.close();
        int v=0,cnt=0;
        String vowels="aeiouAEIOU";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if((c>='A' && c<='Z') ||(c>='a' && c<='z')){
                if(vowels.indexOf(c)!=-1){
                    v++;
                }
                else{
                    cnt++;
                }
            }
        }
        System.out.println("vowels: "+v+", Consonants: "+cnt);
    }
}