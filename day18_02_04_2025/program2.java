package day18_02_04_2025;

/*
You are given two words W1 and W2.
You need find all the mapping of W2 in W1, and 
return all the statrting indices of the mappings.

The mapping of the words w2 and w1 is as follows:
	- A shuffled word contains all the characters as original word.
	The length of the words and occurrence count of each character are same.
	- find shuffled word of W2 as a substring in W1, and 
	return the starting index of substring.


Input Format:
-------------
Single line space separated strings, two words.

Output Format:
--------------
Print the list of integers, indices.


Sample Input-1:
---------------
abcabcabc abc
 
Sample Output-1:
----------------
[0, 1, 2, 3, 4, 5, 6]



Sample Input-2:
---------------
bacacbacdcab cab

Sample Output-2:
----------------
[0, 3, 4, 5, 9]

*/
import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String w1=sc.next();
        String w2 = sc.next();
        sc.close();
        List<Integer> l1=new ArrayList<>();
        if(w1.length()<w2.length()){
            System.out.println(l1);
            return;
        }
        Map<Character,Integer> mw1=new HashMap<>();
        Map<Character,Integer> mw2=new HashMap<>();
        for(int i=0;i<w2.length();i++){
            mw1.put(w1.charAt(i),mw1.getOrDefault(w1.charAt(i),0)+1);
            mw2.put(w2.charAt(i),mw2.getOrDefault(w2.charAt(i),0)+1);
        }
        if(mw1.equals(mw2)) l1.add(0);
        int l=0;
        for(int i=w2.length();i<w1.length();i++){
            mw1.put(w1.charAt(l),mw1.get(w1.charAt(l))-1);
            if(mw1.get(w1.charAt(l))==0) mw1.remove(w1.charAt(l));
            l++;
            mw1.put(w1.charAt(i),mw1.getOrDefault(w1.charAt(i),0)+1);
            if(mw1.equals(mw2)) l1.add(l);
        }
        System.out.println(l1);
    }
}
