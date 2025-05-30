package day9_11_02_2025;
import classes.TreeNode;
/*
Balbir Singh is working with Binary Trees.
The elements of the tree are given in level-order format.

Balbir is observing the tree from the right side, meaning he 
can only see the rightmost nodes (one node per level).

You are given the root of a binary tree. Your task is to determine 
the nodes visible from the right side and return them in top-to-bottom order.

Input Format:
-------------
Space separated integers, elements of the tree.

Output Format:
--------------
A list of integers representing the node values visible from the right side


Sample Input-1:
---------------
1 2 3 4 -1 -1 5

Sample Output-1:
----------------
[1, 3, 5]



Sample Input-2:
---------------
3 1 4 5 2

Sample Output-2:
----------------
[3, 4, 2]

*/
import java.util.*;

class program1 {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s[]=sc.nextLine().split(" ");
    int n=s.length;
    int[] l=new int[n];
    for(int i=0;i<n;i++) l[i]=Integer.parseInt(s[i]);
    TreeNode root = new TreeNode(l[0]);
    int j = 1;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty() && j < n) {
      TreeNode cur = q.poll();
      if (l[j] != -1) {
        cur.left = new TreeNode(l[j]);
        q.add(cur.left);
      }
      j++;
      if (j < n && l[j] != -1) {
        cur.right = new TreeNode(l[j]);
        q.add(cur.right);
      }
      j++;
    }
    q.clear();
    if (root != null) q.add(root);
    List<Integer> l1=new ArrayList<>();
    while(!q.isEmpty()){
      int size=q.size();
      int right_value=0;
      for (int i = 0; i < size; i++) {
        TreeNode cur = q.poll();
        if (cur.left != null) q.add(cur.left);
        if (cur.right != null) q.add(cur.right);
        right_value=cur.val;
      }
      l1.add(right_value);
    }
    System.out.println(l1);
    sc.close();
  }
}
/* Alternate
List<Integer> l1=new ArrayList<>();
dfs(root,l1,0);
System.out.println(l1);
public static void dfs(TreeNode root,List<Integer> l1,int depth){
      if(root==null) return;
      if(depth==l1.size()) l1.add(root.val);
      dfs(root.right,l1,depth+1);
      dfs(root.left,l1,depth+1);
}
*/
