package day38_08_05_2025;

/*
'''
A Kid built a structure using building blocks, 
by placing the building-blocks adjacent to each other.

A building-block is a vertical alignment of blocks.
	                            ___
here one block each represents  as |___|.

The following structure made up of using building blocks

                          ___
                      ___|___|    ___
                     |___|___|_w_|___|___              ___
                  ___|___|___|___|___|___| w   _w_  w |___| 
              ___|___|___|___|___|___|___|_w__|___|_w_|___|____________
    
               0  1   3   4   2   3    2   0   1   0   2

Once the structure is completed, kid pour water(w) on it.

You are given a list of integers, heights of each building-block in a row.
 Now your task How much amount of water can be stored by the structure.

 Input Format:
 -------------
 Space separated integers, heights of the blocks in the structure. 

Output Format:
 --------------
 Print an integer, 
  
Sample Input:
-------------
 0 1 3 4 2 3 2 0 1 0 2
    
Sample Output:
--------------
6
    
Explanation:
 -----------
In the above structure,  6 units of water (w represents the water in the structure)
can be stored.
*/

import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        sc.close();
        int n=s.length;
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(s[i]);
        }
        int pre[]=new int[n];
        pre[0]=a[0];
        for(int i=1;i<n;i++) pre[i]=Math.max(pre[i-1],a[i]);
        int suff[]=new int[n];
        suff[n-1]=a[n-1];
        for(int i=n-2;i>=0;i--) suff[i]=Math.max(suff[i+1],a[i]);
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.min(pre[i],suff[i])-a[i];
        }
        System.out.println(ans);
    }
}