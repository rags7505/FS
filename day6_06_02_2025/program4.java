package day6_06_02_2025;
import classes.TreeNode;
/*
You are developing an application for a garden management system where each tree 
in the garden is represented as a binary tree structure. The system needs to 
allow users to plant new trees in a systematic way, ensuring that each tree is 
filled level by level.

A gardener wants to:
 - Plant trees based on user input.
 - Ensure trees grow in a balanced way by filling nodes level by level.
 - Inspect the garden layout by performing an in-order traversal, which helps 
   analyze the natural arrangement of trees.

Your task is to implement a program that:
    - Accepts a list of N tree species (as integers).
    - Builds a binary tree using level-order insertion.
    - Displays the in-order traversal of the tree.

Input Format:
-------------
- An integer N representing the number of tree plants.
- A space-separated list of N integers representing tree species.

Output Format:
--------------
A list of integers, in-order traversal of tree.


Sample Input:
-------------
7
1 2 3 4 5 6 7

Sample Output:
--------------
4 2 5 1 6 3 7


Explanation:
------------
The tree looks like this:

        1
       / \
      2   3
     / \  / \
    4   5 6  7
The in order is : 4 2 5 1 6 3 7


*/
import java.util.*;
public class program4{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] l=new int[n];
    for(int i=0;i<n;i++) l[i]=sc.nextInt();
    TreeNode r=new TreeNode(l[0]);
    TreeNode root=r;
    Queue<TreeNode> q=new LinkedList<>();
    q.add(r);
    int j=1;
    while(!q.isEmpty()){
        if(j==n) break;
        TreeNode cur=q.poll();
        cur.left=new TreeNode(l[j++]);
        if(j==n) break;
        cur.right=new TreeNode(l[j++]);
        q.add(cur.left);
        q.add(cur.right);
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
