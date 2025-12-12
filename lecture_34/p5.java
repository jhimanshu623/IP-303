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
    public TreeNode solve(TreeNode node)
    {
        if(node==null)
            return null;
        TreeNode l=solve(node.left);
        TreeNode r=solve(node.right);
        if(l==null && r==null)
            return node;
        else if(l==null)
            return r;
        else if(r==null)
        {
            node.right=node.left;
            node.left=null;
            return l;
        }
        else
        {
            l.right=node.right;
            node.right=node.left;
            node.left=null;
            return r;
        }
    }

    // void flatten(TreeNode *root) {
    //     while(root){
    //         if(root->left == NULL)
    //             root = root->right;
    //         else {
    //             if(root->right){
    //                 TreeNode *l = root->left;
    //                 while(l->right) l = l->right;
    //                 l->right = root->right;
    //             }
    //             root->right = root->left;
    //             root->left = NULL;
    //             root = root->right;
    //         }
    //     }
    public void flatten(TreeNode root) {
        solve(root);
    }
}