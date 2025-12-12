// https://leetcode.com/problems/kth-smallest-element-in-a-bst

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int counter=0;
        while(root!=null)
        {
            if(root.left==null)
            {
                counter++;
                if(counter==k)
                    return root.val;
                root=root.right;
            }
            else
            {
                TreeNode temp=root.left;
                while(temp.right!=null && temp.right!=root)
                    temp=temp.right;
                if(temp.right==null)
                {
                    temp.right=root;
                    root=root.left;
                }
                else
                {
                    temp.right=null;
                    counter++;
                    if(counter==k)
                        return root.val;
                    root=root.right;
                }
            }
        }
        return 0;
    }
}