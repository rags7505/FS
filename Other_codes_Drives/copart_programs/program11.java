package Other_codes_Drives.copart_programs;
/*
 Question: 11

Tech Club Committee Selection Problem

A group of students is planning to form a tech club and the club is open for recruitment.
They are interviewing students and marking the skill levels in Mathematics and Physics of the `iᵗʰ` student as `(M, P)` respectively. 
They will be segregating the selected students into committees, and for better efficiency they have a few conditions:

1. All members of a committee should have different skill levels in Mathematics
2. All members of a committee Should have different skill levels in Physics .
3. The difference in the skill level for Mathematics and Physics for two students should not be the same.
       |M1 - M2|should not be equal to |P1 - P2|.


you are given an integer N representing the size of a committee and an integer K. representing that K*K students are being interviewed . 
Your task is to return an integer value representing the number of ways in which the committees can be formed.

note:

* The answer should be returned after performing the modulo operation with 10^4
* The skill level for K students (k>1) will be (0,0),(0,1)...(k-1,k-1) respectively.

Input Specification:
--------------------
* input1: An integer value `N` representing the size of a committee.
* input2: An integer value `K` representing that `K * K` students are being interviewed.

output specification:
---------------------
Return an integer value representing the number of ways in which committees can be formed.

Example 1:
---------
input1: 2
input2: 3

Output:
8


Explanation:
-----------
The number of students being interviewed is 3*3=9 and the number of members in a committee is 2.
The number of ways in which committees can be forn=med while satisfying the conditions is as under 

--------------------------------------------------------------
|	                   |   student 1                      |       student 2                     |
|Committees  |(mathematics,physics) | (mathematics,physics)   |
|-------------------------------------------------------------                                 |
|1	                  |      (0,0)	    |	   (1,2)              |
|2	     |      (0,0)	    |	   (2,1)              |
|3	     |	    (0,1)	    |	   (2,0)              |
|4	     |      (0,1)	    |	   (2,2)              |
|5	     |      (0,2)	    |	   (1,0)              |
|6	     |      (0,2)	    |	   (2,1)              |
|7	     |      (1,0)	    |	   (2,2)              |
|8	     |      (1,2)	    |	   (2,0)              | 
---------------------------------------------------------------

Since 8 committees can be formed, 8 is returned as the output.

Example 2:
----------
input1: 2
input2: 2

Output:
0


Explanation:
------------
The number of students being interviewed is 2*2=4 and the number of members in the committee is 2.
The students being interviewed possess mathematics and physics skills as under:(0,0),(0,1) and (1,1).
 * (1,1) and (0,0) cannot be together as the difference of their   
    Mathematics and physics skills is the Same.
 * (0,0) cannot be in the same committee as (0,1) or (1,0)   
    because they have the same Mathematics and physics skills respectively.
 *  Similarly (1,1) cannot be in the same committee as (0,1) or (1,0).

There is no way in which a committee which satisfies the given conditions can be formed.Therefore 0 is returned as the output.

 */

/* Tejas code (THE BEST CODE) (similar to n-queens)*/
import java.util.*;

public class program11 {
    static long count = 0;
    static long MOD = 1000000000+7;
    private static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res = (res * i) % MOD;
        }
        return res;
    }
    
    private static void check(Set<Integer> rowVisited, Set<Integer> colVisited, Set<Integer> dia1, Set<Integer> dia2,
            int n, int k) {
        if (n == 0) {
            count=(count+1)%MOD;
            // System.out.println("rv= " + rowVisited + "  cv= " + colVisited + "  dia1= " + dia1 + "  dia2= " + dia2);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (rowVisited.contains(i))
                continue;
            for (int j = 0; j < k; j++) {
                // System.out.println("i=" + i + " j=" + j + " rv= " + rowVisited + "  cv= " + colVisited + "  dia1= "
                        // + dia1 + "  dia2= " + dia2);
                if (colVisited.contains(j) || dia1.contains(i - j) || dia2.contains(i + j))
                    continue;
                rowVisited.add(i);
                colVisited.add(j);
                dia1.add(i - j);
                dia2.add(i + j);
                check(rowVisited, colVisited, dia1, dia2, n - 1, k);
                rowVisited.remove(i);
                colVisited.remove(j);
                dia1.remove(i - j);
                dia2.remove(i + j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        Set<Integer> rowVisited = new HashSet<>();
        Set<Integer> colVisited = new HashSet<>();
        Set<Integer> dia1 = new HashSet<>();
        Set<Integer> dia2 = new HashSet<>();
        check(rowVisited, colVisited, dia1, dia2, n, k);

        System.out.println(count/factorial(n));
    }
}
/* Good code(some ones) */
/*
 * import java.util.*;

public class Main{
    static int mod = 1000000007;
    static int count = 0;
    
    static void bt(List<int[]> skills,
            List<int[]> selected,
            int n,int k,int idx,
            Set<Integer> usedM,
            Set<Integer> usedP,
            List<int[]> students){
        if(selected.size() == n){
            count = (count+1)%mod;
            return;
        }
        
        for(int i=idx;i<students.size();i++){
            int[] s = students.get(i);
            int m = s[0],p=s[1];
            if(usedM.contains(m) || usedP.contains(p)) continue;
            boolean valid = true;
            for(int[] sel:selected){
                int dm = Math.abs(sel[0]-m);
                int dp = Math.abs(sel[1]-p);
                if(dm == dp){
                    valid = false;
                    break;
                }
            }
            
            if(!valid) continue;
            selected.add(s);
            usedM.add(m);
            usedP.add(p);
            bt(skills,selected,n,k,i+1,usedM,usedP,students);
            selected.remove(selected.size()-1);
            usedM.remove(m);
            usedP.remove(p);
            
        }
        
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        
        List<int[]> students = new ArrayList<>();
        
        for(int m=0;m<k;m++){
            for(int p=0;p<k;p++){
                students.add(new int[]{m,p});
            }
        }
        
        bt(new ArrayList<>(),new ArrayList<>(),n,k,0,new HashSet<>(),new HashSet<>(),students);
        System.out.println(count);
    }
}
 */
/* OutOfMemory Worst code part 1 */
/*
 * import java.util.*;
class test{
    static int ans=0;
    static int mod=(int)Math.pow(10,9)+7;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        sc.close();
        List<int[]> l=new ArrayList<>();
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                l.add(new int[]{i,j});
            }
        }
        for(int i=0;i<l.size();i++){
            boolean b[]=new boolean[l.size()];
            b[i]=true;
            List<int[]> l1=new ArrayList<>();
            l1.add(l.get(i));
            backtrack(l,n,1,l1,b);
        }
        System.out.println(ans/2);
    }
    public static void backtrack(List<int[]> l,int n,int cnt,List<int[]> l1,boolean b[]){
        if(cnt==n){
            if(valid(l1)){
                ans=(ans+1)%mod;
            }
            return;
        }
        for(int k=0;k<l.size();k++){
            if(b[k]) continue;
            b[k]=true;
            l1.add(l.get(k));
            backtrack(l,n,cnt+1,l1,b);
            l1.remove(l1.size()-1);
            b[k]=false;
        }
    }
    public static boolean valid(List<int[]> l1) {
        int n = l1.size();
        Set<Integer> m = new HashSet<>();
        Set<Integer> p = new HashSet<>();
        for (int[] s : l1) {
            if (!m.add(s[0]) || !p.add(s[1])) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            int[] a = l1.get(i);
            for (int j = i + 1; j < n; j++) {
                int[] b = l1.get(j);
                if (Math.abs(a[0] - b[0]) == Math.abs(a[1] - b[1])) {
                    return false;
                }
            }
        }
        return true;
    }
}
 */
/* OutOfMemory Worst code part 2 */
/*
 * import java.util.*;
class test{
    static int ans=0;
    static int mod=(int)Math.pow(10,9)+7;
    static int[][] temp;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        sc.close();
        List<int[]> l=new ArrayList<>();
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                l.add(new int[]{i,j});
            }
        }
        temp = new int[n][2];
        boolean[] b = new boolean[l.size()];
        for (int i = 0; i < l.size(); i++) {
            Arrays.fill(b, false);
            b[i] = true;
            temp[0][0] = l.get(i)[0];
            temp[0][1] = l.get(i)[1];
            backtrack(l, n, 1, b);
        }
        System.out.println(ans / 2);
    }
    public static void backtrack(List<int[]> l, int n, int cnt, boolean[] b) {
        if (cnt == n) {
            if (valid(temp)) {
                ans = (ans + 1) % mod;
            }
            return;
        }
        for (int k = 0; k < l.size(); k++) {
            if (b[k]) continue;
            b[k] = true;
            temp[cnt][0] = l.get(k)[0];
            temp[cnt][1] = l.get(k)[1];
            backtrack(l, n, cnt + 1, b);
            b[k] = false;
        }
    }
    public static boolean valid(int[][] l1) {
        int n = l1.length;
        Set<Integer> m = new HashSet<>();
        Set<Integer> p = new HashSet<>();
        for (int[] s : l1) {
            if (!m.add(s[0]) || !p.add(s[1])) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            int[] a = l1[i];
            for (int j = i + 1; j < n; j++) {
                int[] b = l1[j];
                int dx = a[0] - b[0];
                int dy = a[1] - b[1];
                if (dx == dy || dx == -dy) {
                    return false;
                }
            }
        }
        return true;
    }
}
 */
/* OutOfMemory Worst code part 3(But Better) */
/*
  75/100

import java.util.*;
class test {
    static int ans = 0;
    static int mod = (int)Math.pow(10, 9) + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        List<int[]> l = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                l.add(new int[]{i, j});
            }
        }
        for (int i = 0; i < l.size(); i++) {
            boolean[] b = new boolean[l.size()];
            b[i] = true;
            List<int[]> l1 = new ArrayList<>();
            l1.add(l.get(i));
            HashSet<Integer> mathSet = new HashSet<>();
            HashSet<Integer> physSet = new HashSet<>();
            mathSet.add(l.get(i)[0]);
            physSet.add(l.get(i)[1]);
            backtrack(l, n, 1, l1, b, mathSet, physSet);
        }
        System.out.println(ans / fact(n));
    }
    public static int fact(int n){
        if(n==0 || n==1) return 1;
        return n*fact(n-1);
    }
    public static void backtrack(List<int[]> l, int n, int cnt, List<int[]> l1, boolean[] b,
                                 HashSet<Integer> mathSet, HashSet<Integer> physSet) {
        if (cnt == n) {
            if (valid(l1)) {
                ans = (ans + 1) % mod;
            }
            return;
        }
        for (int k = 0; k < l.size(); k++) {
            if (b[k]) continue;
            int[] student = l.get(k);
            int m = student[0];
            int p = student[1];
            if (mathSet.contains(m) || physSet.contains(p)) continue;
            b[k] = true;
            l1.add(student);
            mathSet.add(m);
            physSet.add(p);
            backtrack(l, n, cnt + 1, l1, b, mathSet, physSet);
            b[k] = false;
            l1.remove(l1.size() - 1);
            mathSet.remove(m);
            physSet.remove(p);
        }
    }

    public static boolean valid(List<int[]> l1) {
        int n = l1.size();
        for (int i = 0; i < n; i++) {
            int[] a = l1.get(i);
            for (int j = i + 1; j < n; j++) {
                int[] b = l1.get(j);
                if (Math.abs(a[0] - b[0]) == Math.abs(a[1] - b[1])) {
                    return false;
                }
            }
        }
        return true;
    }
}

 */