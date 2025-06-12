package day62_12_06_2025;
/*
You write a love letter to your friend. However, before your friend can read it, 
someone else takes it and rotates the characters of each word from left to right 
K times.

Your task is to determine how many of the words still remain the same even after 
this rotation.

Input Format:
-------------
input1: A string containing words separated by spaces.
input2: An integer K indicating the number of right rotations for each word.

Output Format:
--------------
An integer representing the number of words that remain unchanged after K right 
rotations.


Sample Input: 
-------------
ramram santan nnnn
3

Sample Output:
--------------
2


Sample Input: 
-------------
adasda
3

Sample Output:
--------------
0
*/
import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int k=sc.nextInt();
        sc.close();
        int ans=0;
        for(String i:s){
            int k1=k%i.length();
            String s1=i.substring(k1)+i.substring(0,k1);
            if(s1.equals(i)) ans++;
        }
        System.out.println(ans);
    }
}