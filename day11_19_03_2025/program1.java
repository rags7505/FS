package day11_19_03_2025;
import classes.TreeNode;
/*
Mr. Rakesh is interested in working with Data Structures.

He has constructed a Binary Tree (BT) and asked his friend 
Anil to check whether the BT is a self-mirror tree or not.

Can you help Rakesh determine whether the given BT is a self-mirror tree?
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
class program1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int a[]=new int[s.length];
        for(int i=0;i<a.length;i++){
            a[i]=Integer.parseInt(s[i]);
        }
        if(a.length==0){
          System.out.println(true);
            sc.close();
            return;
        }
        TreeNode root=new TreeNode(a[0]);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int j=1;
        while(j<a.length){
            TreeNode t=q.poll();
            if(a[j]!=-1){
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
        System.out.println(isMirror(root.left, root.right));
        sc.close();
    }
    public static boolean isMirror(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val != root2.val) return false;
        return isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
    }
}
