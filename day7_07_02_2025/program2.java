package day7_07_02_2025;
import classes.TreeNode;
/*
Given the preorder and postorder traversals of a binary tree, construct 
the original binary tree and print its level order traversal.

Input Format:
---------------
Space separated integers, pre order data
Space separated integers, post order data

Output Format:
-----------------
Print list of list of integers, the level-order data of the tree.


Sample Input:
----------------
1 2 4 5 3 6 7
4 5 2 6 7 3 1

Sample Output:
----------------
[[1], [2, 3], [4, 5, 6, 7]]

Explanation:
--------------
        1
       / \
      2   3
     / \  / \
    4   5 6  7


Sample Input:
----------------
1 2 3
2 3 1

Sample Output:
----------------
[[1], [2, 3]]

Explanation:
--------------
    1
   / \
  2  3
*/
import java.util.*;
public class program2{
    public static int index=0;
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String pre=sc.nextLine();
    String post=sc.nextLine();
    int pr[]=Arrays.stream(pre.split(" ")).mapToInt(Integer::parseInt).toArray();
    int po[]=Arrays.stream(post.split(" ")).mapToInt(Integer::parseInt).toArray();
    int n=pr.length;
    Map<Integer, Integer> mpo = new HashMap<>();
    for (int i = 0; i < n; i++) {
      mpo.put(po[i], i);
    }
    TreeNode root = build( 0, n - 1, mpo, pr);
    List<List<Integer>> l=new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    if (root != null) {
      q.add(root);
    }
    while (!q.isEmpty()) {
        int size=q.size();
        List<Integer> l1=new ArrayList<>();
        for(int i=0;i<size;i++){
            TreeNode cur = q.poll();
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
            l1.add(cur.val);
        }
        l.add(l1);
    }
    System.out.println(l);
    sc.close();
  }

  public static TreeNode build(int j, int n,Map<Integer,Integer>  mpo,int[] pr) {
    if ( index>=pr.length || j < 0 || j > n)
      return null;
    TreeNode root = new TreeNode(pr[index++]);
    if(j==n) return root;
    int leftRindex=mpo.get(pr[index]);
    root.left=build(j,leftRindex,mpo,pr);
    root.right=build(leftRindex+1,n-1,mpo,pr);
    return root;
  }
}
