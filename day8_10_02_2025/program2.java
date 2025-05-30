package day8_10_02_2025;
import classes.TreeNode;
/*
In an Intelligence Agency, each senior officer supervises either two junior officers 
or none. The senior officer is assigned a clearance level equal to the lowest clearance 
level of the two junior officers they supervise.

The clearance levels are represented as integer values in the range [1, 50], and multiple 
officers may have the same clearance level.

At the end, all officers (senior and junior) are collectively referred to as agents in the system.

You are provided with a hierarchical clearance level tree where each node represents 
an officer's clearance level. The tree structure follows these rules:
	- If a node has two children, its clearance level is the minimum of the two children's
	  clearance levels.
	- If a node has no children, it's clearance level is same as exists.
	- The value -1 indicates an empty (null) position.
Your task is to find the highest clearance level among all agents in the agency. 
If no such level exists, return -2.

Input Format:
-------------
A single line of space separated integers, clearance levels of each individual.

Output Format:
--------------
Print an integer, the highest clearance level.


Sample Input-1:
---------------
2 5 2 -1 -1 2 4

Sample Output-1:
----------------
5


Sample Input-2:
---------------
3 3 3 3 3

Sample Output-2:
----------------
3
*/
import java.util.*;
public class program2 {
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
    int value = -2;
    if(root!=null){
        value = clearence(root);
    }
    System.out.println(value);
    sc.close();
  }
  public static int clearence(TreeNode root){
      if(root.left==null && root.right==null) return root.val;
      int val1=clearence(root.left);
      int val2=clearence(root.right);
      return Math.max(val1,val2);
  }
}
