package day8_10_02_2025;
import classes.TreeNode;
/*
Mr. Rakesh is interested in working with Data Structures.

He has constructed a Binary Tree (BT) and asked his friend 
Anil to check whether the BT is a self-mirror tree or not.

Can you help Anil determine whether the given BT is a self-mirror tree?
Return true if it is a self-mirror tree; otherwise, return false.

Note:
------
In the tree, '-1' indicates an empty (null) node.

Input Format:
-------------
A single line of space separated integers, values at the treenode

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 1 1 2 3 3 2

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 1 1 -1 3 -1 3

Sample Output-2:
----------------
false
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
    if(root!=null) q.add(root);
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
    boolean f = false;
    if (root != null)
        f = mirror(root.left, root.right);
    System.out.println(f);
    sc.close();
  }
  public static boolean mirror(TreeNode root1,TreeNode root2){
    if(root1==null && root2==null) return true;
    if(root1==null || root2==null) return false;
    if(root1.val!=root2.val) return false;
    return mirror(root1.left,root2.right) && mirror(root1.right,root2.left);
  }
}
