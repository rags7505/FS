package day6_06_02_2025;
import classes.TreeNode;
/*
In a distant future, humanity has begun interstellar colonization, establishing 
zones of habitation and control on a new planet. Scientists have recorded two 
types of data regarding how these zones were structured:

1. Survey Order (analogous to pre-order traversal) – This record details how 
the colonization started, with the first zone established and then expanding 
into new zones following a systematic approach.
2. Planetary Layout (analogous to in-order traversal) – This document shows 
how zones were positioned relative to each other on the map, based on 
territorial boundaries.

Using this information, scientists need to reconstruct the colonization hierarchy 
(binary tree of zones) and display them level wise.

Input Format:
--------------
An integer N representing the number of zones colonized.
A space-separated list of N integers representing the Planetary Layout Order (in-order).
A space-separated list of N integers representing the Survey Order ( pre-order ).

Output Format:
---------------
Print all zone IDs in level order:

Sample Input:
-------------
7
4 2 5 1 6 3 7
1 2 4 5 3 6 7

Sample Output:
---------------
3 2 4 5 6 7

Explanation:
The given Planetary Layout (in-order) and Survey Order (pre-order) correspond to the following colonization hierarchy:
        1
       / \
      2   3
     / \  / \
    4   5 6  7

Level Order: [1, 2, 3, 4, 5, 6, 7]
*/
import java.util.*;
public class program5{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] in=new int[n];
    int[] pr=new int[n];
    for(int i=0;i<n;i++) in[i]=sc.nextInt();
    for(int i=0;i<n;i++) pr[i]=sc.nextInt();
    Map<Integer, Integer> mi = new HashMap<>();
    for (int i = 0; i < n; i++) {
      mi.put( in[i],i);
    }
    TreeNode root = build(0, n - 1, 0, n - 1, pr, mi);
    Queue<TreeNode> q = new LinkedList<>();
    if (root != null) {
      q.add(root);
    }
    while (!q.isEmpty()) {
        TreeNode cur = q.poll();
        System.out.print(cur.val + " ");
        if (cur.left != null)
            q.add(cur.left);
        if (cur.right != null)
            q.add(cur.right);
    }
    sc.close();
  }

  public static TreeNode build(int i, int m, int j, int n,int[] pr,Map<Integer,Integer>  mi) {
    if (i < 0 || i > m || j < 0 || j > n)
      return null;
    TreeNode root = new TreeNode(pr[j]);
    root.left=build(i,mi.get(pr[j])-1,j+1,j+mi.get(pr[j])-i,pr,mi);
    root.right = build(mi.get(pr[j])+1,m,j+mi.get(pr[j])-i+1,n,pr,mi);
    return root;
  }
}
