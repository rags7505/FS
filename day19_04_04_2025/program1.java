package day19_04_04_2025;
import classes.TreeNode;
/*
Imagine you are a librarian organizing books on vertical shelves in a grand library. The books are currently scattered across a tree-like structure, where each book (node) has a position determined by its shelf number (column) and row number (level).

Your task is to arrange the books on shelves so that:
1. Books are placed column by column from left to right.
2. Within the same column, books are arranged from top to bottom (i.e., by row).
3. If multiple books belong to the same shelf and row, they should be arranged from left to right, just as they appear in the original scattered arrangement.

Example 1:
Input:
3 9 20 -1 -1 15 7
Output: 
[[9],[3,15],[20],[7]]

Explanation:
         3
       /   \
      9     20
          /    \
         15     7

Shelf 1: [9]
Shelf 2: [3, 15]
Shelf 3: [20]
Shelf 4: [7]

Example 2:
Input:
3 9 8 4 0 1 7
Output: 
[[4],[9],[3,0,1],[8],[7]]

Explanation:
          3
       /     \
      9       8
    /   \   /   \
   4     0 1     7

Shelf 1: [4]
Shelf 2: [9]
Shelf 3: [3, 0, 1]
Shelf 4: [8]
Shelf 5: [7]

Library Organization Rules:
1. Each column represents a shelf from left to right.
2. Books on the same shelf are arranged from top to bottom.
3. If books share the same position, they are arranged left to right in order of appearance.

*/
import java.util.*;
class Pair{
    TreeNode cur;
    int index;
    Pair(TreeNode t,int index){
        cur=t;
        this.index=index;
    }
}
public class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        sc.close();
        int a[]=new int[s.length];
        for(int i=0;i<a.length;i++) a[i]=Integer.parseInt(s[i]);
        TreeNode root=new TreeNode(a[0]);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int j=1;
        while(j<a.length){
            TreeNode cur=q.poll();
            if(a[j]!=-1){
                cur.left=new TreeNode(a[j]);
                q.add(cur.left);
            }
            j++;
            if(j<a.length && a[j]!=-1){
                cur.right=new TreeNode(a[j]);
                q.add(cur.right);
            }
            j++;
        }
        System.out.print(Traverse(root));
    }
    public static List<List<Integer>> Traverse(TreeNode root){
        List<List<Integer>> l=new ArrayList<>();
        Map<Integer,List<Integer>> m=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            TreeNode cur=p.cur;
            int index=p.index;
            if(!m.containsKey(index)) m.put(index,new ArrayList<>());
            m.get(index).add(cur.val);
            if(cur.left!=null) q.add(new Pair(cur.left,index-1));
            if(cur.right!=null) q.add(new Pair(cur.right,index+1));
        }
        for(int i:m.keySet()){
            l.add(m.get(i));
        }
        return l;
    }
}
