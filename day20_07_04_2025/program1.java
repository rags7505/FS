package day20_07_04_2025;

/*

"Emphatic Pronunciation" of a given word is where we take the word and
replicate some of the letter to emphasize their impact.

Instead of saying 'oh my god', someone may say "ohhh myyy goddd", 
We define emphatic pronunciation of a word, which is derived by replicating 
a group (or single) of letters in the original word. 

So that the replicated group is atleast 3 characters or more and 
greater than or equal to size of original group. 
For example Good -> Goood is an emphatic pronunciation,
but Goodd is not because in Goodd the 'd' are only occuring twice consecutively.
 
In the question you are given the "Emphatic pronunciation" word, 
you have to findout how many words can legal result in the 
"emphatic pronunciation" word.

Input Format:
-------------
Line-1 -> A String contains a single word, Emphatic Pronunciation word
Line-2 -> Space seperated word/s

Output Format:
--------------
Print an integer as your result


Sample Input-1:
---------------
goood
good goodd

Sample Output-1:
----------------
1

Sample Input-2:
---------------
heeelllooo
hello hi helo

Sample Output-2:
----------------
2
*/


import java.util.*;
public class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String words[]=sc.nextLine().split(" ");
        int ans=0;
        List<Pair> l=getList(s);
        for(String s1:words){
            List<Pair> l1=getList(s1);
            if(can(l,l1)){
                ans++;
            }
        }
        System.out.print(ans);
        sc.close();
    }
    public static boolean can(List<Pair> l,List<Pair> l1){
        if(l.size()!=l1.size()) return false;
        for(int i=0;i<l.size();i++){
            Pair p=l.get(i);
            Pair p1=l1.get(i);
            if(p.c!=p1.c) return false;
            if(p.cnt==p1.cnt) continue;
            if(p.cnt<p1.cnt || p.cnt<3) return false;
        }
        return true;
    }
    public static List<Pair> getList(String s){
        List<Pair> l=new ArrayList<>();
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            int cnt=1;
            while(i+1<s.length() && s.charAt(i+1)==c){
                i++;
                cnt++;
            }
            l.add(new Pair(c,cnt));
            i++;
        }
        return l;
    }
}
class Pair{
    char c;
    int cnt;
    Pair(char c,int cnt){
        this.c=c;
        this.cnt=cnt;
    }
}
