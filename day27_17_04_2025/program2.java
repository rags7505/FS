package day27_17_04_2025;

/* 
Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

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
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        sc.close();
        List<String> l=new ArrayList<>();
        List<List<String>> l1=split(s);
        // System.out.println(l1);
        generate(l1,l,0,new StringBuilder());
        Collections.sort(l);
        System.out.println(l);
    }
    public static void generate(List<List<String>> l1,List<String> l,int i,StringBuilder sb){
        if(i==l1.size()){
            l.add(sb.toString());
            return;
        }
        List<String> l2=l1.get(i);
        for(String s:l2){
            int len=sb.length();
            sb.append(s);
            generate(l1,l,i+1,sb);
            sb.setLength(len);
        }
    }
    public static List<List<String>> split(String s){
        List<List<String>> l=new ArrayList<>();
        int i=0;
        while(i<s.length()){
            List<String> l1=new ArrayList<>();
            String k="";
            while(i<s.length() && s.charAt(i)!='['){
                k=k+s.charAt(i);
                i++;
            }
            if(!k.equals("")){
                l1.add(k);
                l.add(l1);
                continue;
            }
            int st=i;
            while(s.charAt(i)!=']'){
                i++;
            }
            String p[]=s.substring(st+1,i).split(",");
            for(String o:p){
                l1.add(o);
            }
            l.add(l1);
            i++;
        }
        return l;
    }
}
