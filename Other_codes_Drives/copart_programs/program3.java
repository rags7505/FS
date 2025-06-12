package Other_codes_Drives.copart_programs;
import classes.TreeNode;
/*
 Question 3 – Tree Puzzle

Shifu was good at solving problems involving trees.so one day as a challenge Master Oogway gave him a problem.He gave Shifu the post-order and in-order traversals of a tree and asked him to tell the elements in a sequential order present between two levels of that tree whose index he had provided himself. 

Input Specification:
--------------------
 input1: The in-order traversal array of the tree
 input2: The post-order traversal array of the tree
 input3: The lower level 'l'
 input4: The higher level 'h'

Output Specification:
--------------------
 Return the array representing the elements between input3 and input4 levels of the tree.

Example 1:
----------
input1: [2, 1, 3]  
input2: [2, 3, 1]  
input3: 1  
input4: 2  
Output: [1, 2, 3]  


Explanation:
-------------
The tree is:


    1
   / \
  2   3


and the nodes between Levels 1 and 2 are 1, 2 and 3.

Example 2:
----------
input1: [4, 2, 5, 1, 6, 3, 7]  
input2: [4, 5, 2, 6, 7, 3, 1]  
input3: 2  
input4: 3 

Output: [2, 3, 4, 5, 6, 7]  


Explanation:
------------
Here,the tree will be:


        1
       / \
      2   3
     / \ / \
    4  5 6  7


and the nodes between Levels 2 and 3 are 2, 3, 4, 5, 6, 7.

 */
import java.util.*;
class program3{
    static int posIndex;

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int in[] = new int[n];
      int pos[] = new int[n];
      for (int i = 0; i < n; i++) {
        in[i] = sc.nextInt();
      }
      for (int i = 0; i < n; i++) {
        pos[i] = sc.nextInt();
      }

        int low = sc.nextInt(); // lower level
        int high = sc.nextInt(); // higher level
        sc.close();
        Map<Integer,Integer> mi=new HashMap<>();
        posIndex=n-1;
        for(int i=0;i<n;i++) mi.put(in[i],i);
        TreeNode root=construct(pos,mi,0,n-1);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<Integer> l = new ArrayList<>();
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(level >= low && level <= high) {
                for(int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    l.add(cur.val);
                    if(cur.left != null) q.add(cur.left);
                    if(cur.right != null) q.add(cur.right);
                }
            } else {
                for(int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    if(cur.left != null) q.add(cur.left);
                    if(cur.right != null) q.add(cur.right);
                }
            }
            level++;
        }
        System.out.println(l);
    }
    public static TreeNode construct(int[] pos,Map<Integer,Integer> mi,int i,int m){
        if(i>m) return null;
        int root_val=pos[posIndex--];
        TreeNode root=new TreeNode(root_val);
        int idx=mi.get(root_val);
        root.right=construct(pos,mi,idx+1,m);
        root.left=construct(pos,mi,i,idx-1);
        return root;
    }
}