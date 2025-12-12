public class p1
{
    // INORDER
    // recursion
    List<Integer> res=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)
            return res;
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    // using stack
    public List<Integer> inorderTraversal(TreeNode cur) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        while(cur!=null || st.size()>0)
        {
            while(cur!=null)
            {
                st.push(cur);
                cur=cur.left;
            }
            cur=st.pop();
            res.add(cur.val);
            cur=cur.right;
        }
        return res;
    }
    // morris
    // O(1) space
    public List<Integer> inorderTraversal(TreeNode cur) {
        List<Integer> res=new ArrayList<>();
        while(cur!=null)
        {
            if(cur.left==null)
            {
                res.add(cur.val);
                cur=cur.right;
            }
            else
            {
                TreeNode curp1=cur.left;
                while(curp1.right!=null && curp1.right!=cur)
                    curp1=curp1.right;
                if(curp1.right==null)
                {
                    curp1.right=cur;
                    cur=cur.left;
                }
                else
                {
                    res.add(cur.val);
                    curp1.right=null;
                    cur=cur.right;
                }
            }
        }
        return res;
    }    
    public static void main(String[] args) {
        
    }
}