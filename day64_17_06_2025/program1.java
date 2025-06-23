package day64_17_06_2025;
/*
You are given a set of releases of a software and you are asked to find the most
recent release. There may be multiple checkins of the software in a given branch. 
Each branch may also have sub branches. For example release 3-5-4 refers to the 
fourth checkin in the fifth sub branch of the third main branch. 
This hierarchy can go upto any number of levels. 

If a level is missing it is considered as level 0 in that hierarchy. 
For example 3-5-7 is  same as 3-5-7-0 or even same as 3-5-7-0-0. 
The higher numbers denote more recent releases. 

For example 3-5-7-1 is more recent than 3-5-7 but less recent than 3-6.

Input Format:
-------------
A single line space separated strings, list of releases 

Output Format:
--------------
Print the latest release of the software.


Sample Input-1:
---------------
1-2 1-2-3-0-0 1-2-3

Sample Output-1:
----------------
1-2-3

Sample Input-2:
---------------
3-5-4 3-5-7 3-5-7-1 3-5-7-0-0 3-6

Sample Output-2:
----------------
3-6
*/
/* Someones code */
import java.util.*;
public class program1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(" ");
        sc.close();
        String res=str[0];
        for(int i=0;i<str.length;i++){
            res=compare(res,str[i]);
        }
        String k[]=res.split("-");
        int j=k.length-1;
        while(j>=0 && Integer.parseInt(k[j])==0){
            j--;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=j;i++){
            sb.append(k[i]).append('-');
        }
        String p=sb.substring(0,sb.length()-1);
        boolean f=false;
        for(String i:str){
            if(i.equals(p)){
                System.out.println(i);
                f=true;
                break;
            }
        }
        if(!f){
            System.out.println(res);
        }
    }
    public static String compare(String str1,String str2){
        String[] s1=str1.split("-");
        String[] s2=str2.split("-");
        int a=0;
        int b=0;
        while(a<s1.length || b<s2.length){
            int x1=(a<s1.length)?Integer.parseInt(s1[a]):0;
            int x2=(b<s2.length)?Integer.parseInt(s2[b]):0;
            if(x1>x2){
                return str1;
            }else if(x1<x2){
                return str2;
            }else{
                a++;
                b++;
            }
        }
        return str1;
    }
}