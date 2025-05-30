package day25_15_04_2025;

/*
Bablu is working in a construction field.
He has N number of building blocks, where the height and width of all the blocks are same.
And the length of each block is given in an array, blocks[].

Bablu is planned to build a wall in the form of a square.
The rules to cunstruct the wall are as follows:
	- He should use all the building blocks.
	- He should not break any building block, but you can attach them with other.
	- Each building-block must be used only once.
	
Your task is to check whether Bablu can cunstruct the wall as a square
with the given rules or not. If possible, print true. Otherwise, print false.

Input Format:
-------------
Line-1: An integer N, number of BuildingBlocks.
Line-2: N space separated integers, length of each block.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
6
1 2 6 4 5 6

Sample Output-1:
----------------
true


Sample Input-2:
---------------
6
5 3 2 5 5 6

Sample Output-2:
----------------
false
*/

import java.util.*;
class program1{
    static boolean b=false;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        sc.close();
        int sum=0;
        for(int i:a) sum+=i;
        if(sum%4!=0){
            System.out.println(false);
            return;
        }
        int side=sum/4;
        for(int i:a){
            if(i>side){
                System.out.println(false);
                return;
            }
        }
        int s[]=new int[4];
        backtrack(0,s,side,a);
        System.out.println(b);
    }
    public static void backtrack(int i,int []s,int side,int[]a){
        if(i==a.length){
            if(is(s,side)){
                b=true;
            }
            return;
        }
        for(int k=0;k<4;k++){
            if(s[k]+a[i]<=side){
                s[k]+=a[i];
                backtrack(i+1,s,side,a);
                if(b) return ;
                s[k]-=a[i];
            }
            if(s[k]==0) break;
        }
    }
    public static boolean is(int[] s,int sum){
        for(int i:s){
            if(i!=sum) return false;
        }
        return true;
    }
}
