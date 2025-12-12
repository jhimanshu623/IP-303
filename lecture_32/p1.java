public class p1 {
    
    // O(n) time
    // O(1)space excluding stack space
    boolean isFound=false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null)
            return null;
        
        TreeNode l=inorderSuccessor(root.left,p);
        if(l!=null)
            return l;
        if(isFound==true)
            return root;
        if(root==p)
            isFound=true;
        TreeNode r=inorderSuccessor(root.right,p);
        if(r!=null)
            return r;
        return null;
    }

    // O(h) time
    // O(1) space
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode temp=null;
        while(root!=null)
        {
            if(root==p)
            {
                if(root.right==null)
                    return temp;
                else
                {
                    root=root.right;
                    while(root.left!=null)
                        root=root.left;
                    temp=root;
                    return temp;
                }
            }
            else if(p.val < root.val)
            {
                temp=root;
                root=root.left;
            }
            else
                root=root.right;
        }
        return temp;
    }
    public static void main(String[] args) {
        
    }
}