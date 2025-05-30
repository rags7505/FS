package day10_18_03_2025;
import classes.TreeNode;
/*
VishnuVardan is working with Decision Trees for AI-based predictions.
To analyze alternative outcomes, Kishore has planned to flip the decision 
tree horizontally to simulate a reverse processing approach.

Rules for Flipping the Decision Tree:
	- The original root node becomes the new rightmost node.
	- The original left child becomes the new root node.
	- The original right child becomes the new left child.
This transformation is applied level by level recursively.

Note:
------
- Each node in the given tree has either 0 or 2 children.
- Every right node in the tree has a left sibling sharing the same parent.
- Every right node has no further children (i.e., they are leaf nodes).

Your task is to help VishnuVardan flip the Decision Tree while following 
the given transformation rules.

Input Format:
-------------
Space separated integers, nodes of the tree.

Output Format:
--------------
Print the list of nodes of flipped tree as described below.


Sample Input-1:
---------------
4 2 3 5 1

Sample Output-1:
----------------
5 1 2 3 4


Sample Input-2:
---------------
4 2 5

Sample Output-2:
----------------
2 5 4
*/
import java.util.*;
class program1{
    static TreeNode rootNode;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int a[]=new int[s.length];
        for(int i=0;i<s.length;i++){
            a[i]=Integer.parseInt(s[i]);
        }
        TreeNode root=new TreeNode(a[0]);
        int j=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(j<a.length){
            TreeNode t=q.poll();
            if(j<a.length && a[j]!=-1){
                t.left=new TreeNode(a[j]);
                q.add(t.left);
            }
            j++;
            if(j<a.length && a[j]!=-1){
                t.right=new TreeNode(a[j]);
                q.add(t.right);
            }
            j++;
        }
        dfs(root);
        q.clear();
        q.add(rootNode);
        while (!q.isEmpty()) {
          TreeNode t = q.poll();
          System.out.print(t.val + " ");
          if (t.left != null) {
            q.add(t.left);
          }
          if (t.right != null) {
            q.add(t.right);
          }
        }
        sc.close();
    }
    public static TreeNode dfs(TreeNode root){
        TreeNode t=null;
        if(root.left!=null){
            t = dfs(root.left);
        }
        else{
            rootNode=root;
            return root;
        }
        t.left=root.right==null?root:root.right;
        t.right=root.right==null?null:root;
        root.left=null;
        root.right=null;
        return t.left;
    }
}