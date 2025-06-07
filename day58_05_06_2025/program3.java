package day58_05_06_2025;

/*
Problem 1: 
Write a java program that reads a sentence and counts how many times each word 
appears. Display only the words that occur more than once.

Input: 
------
this is a test this test is easy

Output:
-------
this -> 2
is -> 2
test -> 2
*/
import java.util.*;
class program3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        sc.close();
        Map<String,Integer> m=new LinkedHashMap<>();
        for(String i:s){
            m.put(i,m.getOrDefault(i,0)+1);
        }
        for(String i:m.keySet()){
            if(m.get(i)>=2){
                System.out.println(i+" -> "+m.get(i));
            }
        }
    }
}