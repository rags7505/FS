/*
Write Java code for a method which takes a String (a sentence) as input 
and returns a HashMap. The Map key is String (word in the String) and 
value is frequency of the word in the given sentence.
(In the words ignore any special characters)

Sample Input:
---------------
Java is fun, and Ja#va@ is powerful 

Sample Output:
-----------------
java: 2
is: 2
fun: 1
and: 1
powerful: 1
*/
import java.util.*;
class WordFrequency{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        sc.close();
        System.out.println(check(s));
    }
    public static LinkedHashMap<String,Integer> check(String[] s){
        LinkedHashMap<String,Integer> hm=new LinkedHashMap<>();
        for(String s1:s){
            StringBuilder sb=new StringBuilder(s1.toLowerCase());
            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)<'a' || sb.charAt(i)>'z'){
                    sb.deleteCharAt(i);
                    i--;
                }
            }
            hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0)+1);
        }
        return hm;
    }
}