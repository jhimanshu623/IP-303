public class p2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null)
        {
            if(p.val<=root.val && q.val>=root.val)
                return root;
            else if(q.val<=root.val && p.val>=root.val)
                return root;
            else if(p.val<root.val && q.val<root.val)
                root=root.left;
            else
                root=root.right;
        }
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null)
        {
            if(p.val<root.val && q.val<root.val)
                root=root.left;
            else if(p.val>root.val && q.val>root.val)
                root=root.right;
            else
                return root;
        }
        return null;
    }
    public static void main(String[] args) {
        
    }
}