package day29_23_04_2025;
/*
You can call two strings X and Y are friendly strings, 
if you can swap two letters in X, so the result is equal to Y.

The condition to swap the letters is as follows:
	Swapping letters is defined as taking two indices i and j (0-indexed) 
	such that i != j and swapping the characters at A[i] and A[j] . 
	For example, swapping at indices 0 and 2 in "abcd" results in "cbad" .

You are given two strings X and Y of lowercase letters, 
return true if X and Y are friendly strings, otherwise return false.

Input Format:
-------------
Two space separated Strings X and Y

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
abcde bacde

Sample Output-1:
----------------
true

Sample Input-2:
---------------
abcde abcde

Sample Output-2:
----------------
false

*/
import java.util.*;
class program4{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        String[] arr = str.split(" ");
        String s1 = arr[0];
        String s2 = arr[1];
        if (s1.length() != s2.length()) {
          System.out.println(false);
          return;
        }
        if(s1.equals(s2)){
          int f[] = new int[26];
          for (int i = 0; i < s1.length(); i++) {
            f[s1.charAt(i) - 'a']++;
            if (f[s1.charAt(i) - 'a'] > 1) {
              System.out.println(true);
              return;
            }
          }
          System.out.println(false);
          return;
        }
        int n = s1.length();
        List<Integer> l1 = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                l1.add(i);
            }
        }
        if(l1.size()!=2){
            System.out.println(false);
        }else{
            int i = l1.get(0);
            int j = l1.get(1);
            if(s1.charAt(i)==s2.charAt(j) && s1.charAt(j)==s2.charAt(i)){
                System.out.println(true);
            }else{
                System.out.println(false);
            }
        }
    }
}