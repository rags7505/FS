package day6_06_02_2025;
import classes.TreeNode;
/*
In a distant galaxy, an ancient civilization built a hierarchical communication 
network of interconnected relay stations. The structure of this network can be 
reconstructed using two ancient data logs:
    - Beacon Activation Order (analogous to in-order traversal)
    - Final Signal Sent Order (analogous to post-order traversal)

Using these logs, we can reconstruct the original relay network and process 
queries about signals reaching specific hierarchical levels.

Given the Beacon Activation Order and the Final Signal Sent Order of a galactic 
communication network, reconstruct the relay network. After reconstructing the 
hierarchy, process multiple queries to identify which stations transmitted 
signals within a given range of levels. Each query consists of a lower level 
and an upper level, and the output should list the relay stations in the order 
they appear in a level-wise transmission sequence.

Input Format:
-------------
An integer N representing the number of relay stations in the network.
A space-separated list of N integers representing the Beacon Activation Order (similar to in-order traversal).
A space-separated list of N integers representing the Final Signal Sent Order (similar to post-order traversal).
An integer Q representing the number of queries.
Q pairs of integers, each representing a query in the form:
Minimum Transmission Depth (L)
Maximum Transmission Depth (U)

Output Format:
--------------
For each query, print the relay stations in order of their signal transmissions within the given depth range


Sample Input:
-------------
7
4 2 5 1 6 3 7
4 5 2 6 7 3 1
2
1 2
2 3

Sample Output:
--------------
[1, 2, 3]
[2, 3, 4, 5, 6, 7]


Explanation:
------------
The logs correspond to the following hierarchical relay network:
        1
       / \
      2   3
     / \  / \
    4   5 6  7
Query 1 (Transmission Levels 1 to 2): 1 2 3
Query 2 (Transmission Levels 2 to 3): 2 3 4 5 6 7
*/
import java.util.*;
public class program2{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] in=new int[n];
    int[] po=new int[n];
    for(int i=0;i<n;i++) in[i]=sc.nextInt();
    for(int i=0;i<n;i++) po[i]=sc.nextInt();
    int m=sc.nextInt();
    int qu[][]=new int[m][2];
    for(int i=0;i<m;i++){
        qu[i][0]=sc.nextInt();
        qu[i][1]=sc.nextInt();
    }
    Map<Integer, Integer> mi = new HashMap<>();
    for (int i = 0; i < n; i++) {
      mi.put( in[i],i);
    }
    TreeNode root = build(0, n - 1, 0, n - 1, po, mi);
    Queue<TreeNode> q = new LinkedList<>();
    for(int[] i:qu){
        int level=1;
        if(root!=null) q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                TreeNode cur=q.poll();
                if(level>=i[0] && level<=i[1]){
                    System.out.print(cur.val+" ");
                }
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
            level++;
        }
        System.out.println();
        sc.close();
    }
  }

  public static TreeNode build(int i, int m, int j, int n,int[] po,Map<Integer,Integer>  mi) {
    if (i < 0 || i > m || j < 0 || j > n)
      return null;
    TreeNode root = new TreeNode(po[n]);
    root.left=build(i,mi.get(po[n])-1,j,j+mi.get(po[n])-i-1,po,mi);
    root.right = build(mi.get(po[n])+1,m,j+mi.get(po[n])-i,n-1,po,mi);
    return root;
  }
}
