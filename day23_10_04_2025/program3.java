package day23_10_04_2025;

/*
Nehanth, a bubbly kid playing with digits and creating numbers using them.
The kid is creating the number called successive number. 
A number is called successive number, if and only if 
each digit in the number is one less than the next digit.

You are given two integers, start and end, both are inclusive.
Your task to find and print all the successive numbers in the given range (start, end).

Input Format:
-------------
Two space separated integers, start and end

Output Format:
--------------
Print the list of successive numbers in the range(start, end).


Sample Input-1:
---------------
50 150

Sample Output-1:
----------------
[56, 67, 78, 89, 123]


Sample Input-2:
---------------
100 600

Sample Output-2:
----------------
[123, 234, 345, 456, 567]

*/
/* Brute Force  mine */
import java.util.*;
class program3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int st=sc.nextInt();
        int end=sc.nextInt();
        sc.close();
        List<Integer> l=new ArrayList<>();
        for(int i=st;i<=end;i++){
            if(is(i)) l.add(i);
        }
        System.out.print(l);
    }
    public static boolean is(int num){
        String s=Integer.toString(num);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)-1 !=s.charAt(i-1)) return false;
        }
        return true;
    }
} 
/* optimal -other
import java.util.*;
class program3{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int st=sc.nextInt();
        int end=sc.nextInt();
        String s="0123456789";
        int min_length=Integer.toString(st).length(),max_length=Integer.toString(end).length();
        List<Integer> l=new ArrayList<>();
        while(min_length<=max_length){
            for(int i=0;i<s.length()-min_length+1;i++){
                int num=Integer.valueOf(s.substring(i,i+min_length));
                if(num>=st && num<=end && !l.contains(num)) l.add(num);
            }
            min_length++;
        }
        System.out.print(l);
    }
}   */
