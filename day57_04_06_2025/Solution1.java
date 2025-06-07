/*
Problem: Write a program to count each word's first index and total occurrences 
in a sentence.

Sample Input: 
apple banana apple orange banana apple

Sample Output:
apple -> first index: 0, count: 3
banana -> first index: 6, count: 2
orange -> first index: 19, count: 1

*/
/*
Problem: Write a program to count each word's first index and total occurrences 
in a sentence.

Sample Input: 
apple banana apple orange banana apple

Sample Output:
apple -> first index: 0, count: 3
banana -> first index: 6, count: 2
orange -> first index: 19, count: 1

*/
import java.util.*;
class Solution1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        sc.close();
        Map<String,Integer> m=new LinkedHashMap<>();
        int index=0;
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<s.length;i++){
            m.put(s[i],m.getOrDefault(s[i],0)+1);
            if(m.get(s[i])==1){
                l.add(index);
            }
            index+=s[i].length()+1;
        }
        index=0;
        if(m.size()==0) return;
        for(String i:m.keySet()){
            System.out.println(i+" -> first index: "+l.get(index++)+", count: "+m.get(i));
        }
    }
}