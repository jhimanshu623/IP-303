public class p2 {
    public boolean solve(TreeNode node,long min,long max)
    {
        if(node==null)
            return true;
        if(node.val<min || node.val>max)
            return false;
        boolean l=solve(node.left,min,(long)node.val-1);
        boolean r=solve(node.right,(long)node.val+1,max);
        return (l&&r);
    }
    public boolean isValidBST(TreeNode root) {
        return solve(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    // long is used because of this case
    // [-2147483648,-2147483648]
    public static void main(String[] args) {
    }
}
