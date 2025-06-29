package day69_26_06_2025;
/*
 Basava is interested in playing with digits.
He wants to create a set of integers of length N, using the digits[0-9].
The rules to create the integers are as follows:
	- digits in each integer are like d0,d1,d2...dn-1
	- and |d0-d1| = |d1-d2| = |d2-d3| ... |dn-2 - dn-1|= D

Basava is given two integers N and D, where N is length of the integer and 
D is the difference. Can you help Basava, to create such list of integers 
and print all the possible integers in ascending order


Note:
-----
Integers with leading 0's are not allowed


Input Format:
-------------
Two space separated integers N and K.

Output Format:
--------------
Print all the possible integers in ascending order.


Sample Input-1:
---------------
3 5

Sample Output-1:
----------------
[161, 272, 383, 494, 505, 616, 727, 838, 949]


Sample Input-2:
---------------
2 3

Sample Output-2:
----------------
[14, 25, 30, 36, 41, 47, 52, 58, 63, 69, 74, 85, 96]

 */
import java.util.*;
public class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d=sc.nextInt();
        sc.close();
        List<String> l=new ArrayList<>();
        generate(n,d,new StringBuilder(),l);
        System.out.println(l);
    }
    public static void generate(int n,int d,StringBuilder sb,List<String> l){
        if(sb.length()==n){
            l.add(sb.toString());
            return;
        }
        for(int i=0;i<=9;i++){
            if(sb.length()==0 && i==0) continue;
            if(sb.length()==0 || Math.abs(((sb.charAt(sb.length()-1))-'0')-i)==d){
                sb.append(i);
                generate(n,d,sb,l);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
/* Srihitha code */
/*
 import java.util.*;
public class program1{
    public static void helper(int k,ArrayList<Integer>l,int n,StringBuilder sb){
        if(sb.length()==n){
            l.add(Integer.parseInt(sb.toString()));
            return;
        }
        int last=sb.charAt(sb.length()-1)-'0';
        if(last+k<=9){
            sb.append((char)(last+k+'0'));
            helper(k,l,n,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(k!=0 &&last-k>=0){
            sb.append((char)(last-k+'0'));
            helper(k,l,n,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        ArrayList<Integer>l=new ArrayList<>();
        for(int i=1;i<=9;i++){
            StringBuilder sb=new StringBuilder();
            sb.append((char)(i+'0'));
            helper(k,l,n,sb);
        }
        Collections.sort(l);
        System.out.println(l);
    }
}
 */