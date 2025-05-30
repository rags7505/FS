package day7_07_02_2025;
import classes.TreeNode;
/*
Write a program to construct a binary tree from level-order input, while treating -1 
as a placeholder for missing nodes. The program reads input, constructs the tree, 
and provides an in-order traversal to verify correctness.

Input Format:
---------------
Space separated integers, level order data (where -1 indiactes null node).

Output Format:
-----------------
Print the in-order data of the tree.


Sample Input:
----------------
1 2 3 -1 -1 4 5

Sample Output:
----------------
2 1 4 3 5

Explanation:
--------------
    1
   / \
  2   3
     / \
    4   5


Sample Input:
----------------
1 2 3 4 5 6 7

Sample Output:
----------------
4 2 5 1 6 3 7

Explanation:
--------------
        1
       / \
      2   3
     / \  / \
    4  5 6  7

====================================
*/
import java.util.*;
class program1{
  public static void main(String[] args) {
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
      if (l[j] == -1) {
        cur.left = null;
      } else {
        cur.left = new TreeNode(l[j]);
        q.add(cur.left);
      }
      j++;
      if (j < n) {
        if (l[j] == -1) {
          cur.right = null;
        } else {
          cur.right = new TreeNode(l[j]);
          q.add(cur.right);
        }
        j++;
      }
    }
    inorder(root);
    sc.close();
  }
  public static void inorder(TreeNode root){
      if(root==null) return;
      inorder(root.left);
      System.out.print(root.val+" ");
      inorder(root.right);
  }
}
