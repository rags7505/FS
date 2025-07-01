package day70_01_07_2025;
/*
Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words, in
lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
A string EXP, expression.

Output Format:
--------------
Print list of words, formed from the expression.


Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:
----------------
[xyzab, xyzac]
*/
import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        sc.close();
        List<List<String>> l=get(s);
        List<String> ans=new ArrayList<>();
        back(0,ans,l,"");
        Collections.sort(ans);
        System.out.println(ans);
    }
    public static void back(int i,List<String> ans,List<List<String>> l,String k){
        if(i==l.size()){
            ans.add(k);
            return;
        }
        for(String p:l.get(i)){
            back(i+1,ans,l,k+p);
        }
    }
    public static List<List<String>> get(String s){
        List<List<String>> l=new ArrayList<>();
        int i=0;
        while(i<s.length()){
            //System.out.println(i+" "+l);
            List<String> l1=new ArrayList<>();
            if(s.charAt(i)=='['){
                int p=++i;
                while(s.charAt(i)!=']') i++;
                String k[]=s.substring(p,i).split(",");
                for(String j:k) l1.add(j);
                i++;
            }
            else{
                String o="";
                while(i<s.length()&&s.charAt(i)!='['){
                    o+=s.charAt(i++);
                }
                l1.add(o);
            }
            l.add(l1);
        }
        return l;
    }
}