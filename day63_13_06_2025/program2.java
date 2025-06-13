package day63_13_06_2025;
/*
3You are building memory management for a smart home hub where apps are loaded on-demand. 
The hub has limited memory (cache size). If an app is not in memory (cache miss), it is loaded and 
a page fault occurs. If memory is full, the Least Recently Used (LRU) app is removed.

Simulate the LRU page replacement and count total page faults.

Input Format:
-------------
- Cache size
- Space-separated app access sequence (e.g., Thermostat Camera Lights)

Output Format:
--------------
Total page faults
Final cache contents

Sample Input:
-------------
3
Thermostat Camera Lights Thermostat Camera Doorbell Lights Thermostat

Sample Output:3
--------------
Total Page Faults: 6
Final Cache: [Doorbell, Lights, Thermostat]


Sample Input:
--------------
2
AC Light Fan AC Heater Light

Sample Output:
--------------
Total Page Faults: 6
Final Cache: [Heater, Light]
*/
/* Chatgpt */
import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String s[]=sc.nextLine().split(" ");
        sc.close();
        LinkedHashSet<String> st=new LinkedHashSet<>();
        int ans=0;
        for(String i:s){
            if(st.contains(i)){
                st.remove(i);
                st.add(i);
            }
            else{
                ans++;
                if(st.size()==n){
                    Iterator<String> it=st.iterator();
                    it.next();
                    it.remove();
                }
                st.add(i);
            }
        }
        System.out.println("Total Page Faults: "+ans);
        System.out.println("Final Cache: "+st);
    }
}


/* Pradeep Code */
/* 
import java.util.*;
public class test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String[] s=sc.nextLine().split(" ");
        Deque<String>q=new LinkedList<>();
        int faults=0;
        for(String i:s){
            if(q.contains(i)){
                q.remove(i);
                q.addLast(i);
            }
            else if(q.size()<n&& !q.contains(i)){
                q.addLast(i);
                faults++;
            }
            else{
                q.remove(q.getFirst());
                q.addLast(i);
                faults++;
            }
        }
        System.out.println("Total Page Faults: "+faults);
        System.out.println("Final Cache: "+q);
    }
}*/