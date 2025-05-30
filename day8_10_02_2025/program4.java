package day8_10_02_2025;
import classes.TreeNode;
/*
A security team is setting up surveillance cameras in a multi-floor building. 
Each floor has a certain number of cameras, and every camera is assigned 
a resolution value (in megapixels). The placement follows a hierarchical 
structure, similar to a tree:
	- Floor 0 (Ground Floor) has a single main camera (root camera).
	- From the next floor onward, each camera can have at most two sub-cameras, 
	one on the left side and one on the right side.
	- If a camera does not have a sub-camera at a position, it is represented as -1.
	
The goal is to identify the camera with the highest resolution on each floor to 
ensure optimal security coverage.

Input Format:
-------------
A single line of space separated integers, the resolution values of cameras

Output Format:
--------------
A list of integers, where eech integer represents the maximum resolution camera 
on that floor.


Sample Input-1:
---------------
2 4 3 6 4 -1 9

Sample Output-1:
----------------
[2, 4, 9]


Sample Input-2:
---------------
3 4 7 7 3 8 4 

Sample Output-2:
----------------
[3, 4, 8]
*/
import java.util.*;
public class program4 {
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
      int max=-1;
      for (int i = 0; i < size; i++) {
        TreeNode cur = q.poll();
        if (cur.left != null) q.add(cur.left);
        if (cur.right != null) q.add(cur.right);
        max=Math.max(max,cur.val);
      }
      l1.add(max);
    }
    System.out.println(l1);
    sc.close();
  }
}
