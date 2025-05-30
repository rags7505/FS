package day21_08_04_2025;
import classes.TreeNode;
/*
Imagine you're the chief curator at a renowned museum that houses a rare collection 
of ancient artifacts. These artifacts are arranged in a special display that 
follows a strict rule: any artifact positioned to the left of another has a lower 
value, and any artifact on the right has a higher value. 

Your task is to transform this display into what is known as a "Greater Artifact 
Display." In this new arrangement, each artifact’s new value will be its original 
value plus the sum of the values of all artifacts that are more valuable than it.

Example 1:
----------
input=
4 2 6 1 3 5 7
output=
22 27 13 28 25 18 7

Explanation:
Input structure 
       4
      / \
     2   6
    / \ / \
   1  3 5  7

Output structure:
        22
      /   \
     27   13
    / \   / \
   28 25 18  7

Reverse updates:
- Artifact 7: 7
- Artifact 6: 6 + 7 = 13
- Artifact 5: 5 + 13 = 18
- Artifact 4: 4 + 18 = 22
- Artifact 3: 3 + 22 = 25
- Artifact 2: 2 + 25 = 27
- Artifact 1: 1 + 27 = 28


*/

import java.util.*;
class program2{
    static int sum=0;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        sc.close();
        int a[]=new int[s.length];
        for(int i=0;i<s.length;i++) a[i]=Integer.parseInt(s[i]);
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
        Traverse(root);
        q.clear();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            System.out.print(cur.val+" ");
            if(cur.left!=null) q.add(cur.left);
            if(cur.right!=null) q.add(cur.right);
        }
    }
    public static void Traverse(TreeNode root){
        if(root==null) return;
        Traverse(root.right);
        sum+=root.val;
        root.val=sum;
        Traverse(root.left);
    }
}
