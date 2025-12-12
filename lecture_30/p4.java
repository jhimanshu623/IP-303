public class p4 {
    int ans=Integer.MIN_VALUE;
    public int solve(TreeNode node)
    {
        if(node==null)
            return 0;
        int ls=solve(node.left);
        int rs=solve(node.right);
        ans=Math.max(ans,node.val);
        ans=Math.max(ans,node.val+ls);
        ans=Math.max(ans,node.val+rs);
        ans=Math.max(ans,node.val+ls+rs);
        return Math.max(node.val,Math.max(node.val+ls,node.val+rs));
    }
    public int maxPathSum(TreeNode root) {
        solve(root);
        return ans;
    }
    
    public static void main(String[] args) {
        
    }
}