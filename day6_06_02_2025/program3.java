package day6_06_02_2025;

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
(binary tree of zones) and analyze areas within a specific range of levels. 
However, due to security concerns, patrol teams will scan these zones in a 
zigzag pattern:
    - Odd levels (starting from 1) should be inspected from left to right.
    - Even levels should be inspected from right to left.

Input Format:
-------------
An integer N representing the number of zones colonized.
N space-separated integers representing the Planetary Layout Order (in-order).
N space-separated integers representing the Survey Order (pre-order).
Two space sepaarted integers,Lower Level (L), Upper Level (U)

Output Format:
--------------
Print all zone IDs within the specified levels, but in spiral order:
    - Odd levels → Left to Right.
    - Even levels → Right to Left.

Sample Input:
-------------
7
4 2 5 1 6 3 7
1 2 4 5 3 6 7
2 3

Sample Output:
--------------
3 2 4 5 6 7

Explanation:
------------
The given Planetary Layout (in-order) and Survey Order (pre-order) correspond 
to the following colonization hierarchy:

        1
       / \
      2   3
     / \  / \
    4   5 6  7

Levels 2 to 3 in Regular Order:
Level 2 → 2 3
Level 3 → 4 5 6 7 

Spiral Order:
Level 2 (Even) → 3 2 (Right to Left)
Level 3 (Odd) → 4 5 6 7 (Left to Right)

*/
import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}
public class program3{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] in=new int[n];
    int[] pr=new int[n];
    for(int i=0;i<n;i++) in[i]=sc.nextInt();
    for(int i=0;i<n;i++) pr[i]=sc.nextInt();
    int l=sc.nextInt();
    int r=sc.nextInt();
    Map<Integer, Integer> mi = new HashMap<>();
    for (int i = 0; i < n; i++) {
      mi.put( in[i],i);
    }
    TreeNode root = build(0, n - 1, 0, n - 1, pr, mi);
    Queue<TreeNode> q = new LinkedList<>();
    List<Integer> list=new ArrayList<>();
    if (root != null) {
      q.add(root);
      list.add(root.val);
    }
    int level=1;
    while (!q.isEmpty()) {
        int size=q.size();
        if(level>=l && level<=r){
            for(int i=0;i<size;i++){
                if(level%2==0){
                    System.out.print(list.get(size-i-1)+" ");
                }
                else{
                    System.out.print(list.get(i)+" ");
                }
            }
        }
        list.clear();
        for(int i=0;i<size;i++){
            TreeNode cur=q.poll();
            if(cur.left!=null){
                q.add(cur.left);
                list.add(cur.left.val);
            }
            if(cur.right!=null){
                q.add(cur.right);
                list.add(cur.right.val);
            }
        }
        level++;
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
