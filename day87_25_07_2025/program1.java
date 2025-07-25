package day87_25_07_2025;
/*
Sukumar is a mathematics teacher.
Sukumar is always intersted to create logical problems.
He has given a problem to the students to solve it.
Students are given sentence with set of words, students has to find two words
W1 and W2, such that there should be no common letters between W1 and W2, 
and return the product of W1.length and W2.length.
If there are no such words in the sentence return 0.

Your task is to solve the problem given by Sukumar and help the students.

Input Format:
-------------
Space separated strings, the sentence with set of words[].

Output Format:
--------------
Print an integer, maximum product of two max length words.


Sample Input-1:
---------------
there is an wondeful event going to happen in the school

Sample Output-1:
----------------
30

Explanation: 
------------
The two words will be "there", "school".
or "going", "happen"..etc


Sample Input-2:
---------------
elegant jewels are made here

Sample Output-2:
----------------
0

Explanation: 
------------
All words have atleast one letter in common.
*/
import java.util.*;
public class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        sc.close();
        Map<Integer,int[]> m=new HashMap<>();
        for(int i=0;i<s.length;i++){
            String s1=s[i];
            int f[]=new int[26];
            for(char c:s1.toCharArray()){
                f[c-'a']++;
            }
            m.put(i,f);
        }
        int max=0;
        for(int i=0;i<s.length;i++){
            for(int j=i+1;j<s.length;j++){
                int f1[]=m.get(i);
                int f2[]=m.get(j);
                boolean flag=true;
                for(int k=0;k<26;k++){
                    if(f1[k]==0 || f2[k]==0) continue;
                    flag=false;
                    break;
                }
                if(flag){
                    max=Math.max(max,s[i].length()*s[j].length());
                }
            }
        }
        System.out.println(max);
    }
}
/* Tejas code */
/*
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        int n = words.length;
        int[] masks = new int[n];
        
        for (int i=0; i<n; i++)
            for (char c: words[i].toCharArray())
                masks[i] |= (1 << (c - 'a'));
        
        int largest = 0;
        for (int i=0; i<n-1; i++) 
            for (int j=i+1; j<n; j++) 
                if ((masks[i] & masks[j]) == 0) largest = Math.max(largest, words[i].length() * words[j].length());
        
        System.out.println(largest);
    }
}
*/