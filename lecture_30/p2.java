public class p2 {
    // PREORDER
    // recursive
    List<Integer> res=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode cur) {
        if(cur==null)
            return res;
        res.add(cur.val);
        preorderTraversal(cur.left);
        preorderTraversal(cur.right);
        return res;
    }

    // using stack
    public List<Integer> preorderTraversal(TreeNode cur) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        while(cur!=null || st.size()>0)
        {
            while(cur!=null)
            {
                st.push(cur);
                res.add(cur.val);
                cur=cur.left;
            }
            cur=st.pop();
            cur=cur.right;
        }
        return res;
    }

    // morris 
    // O(1) space
    public List<Integer> preorderTraversal(TreeNode cur) {
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
                    res.add(cur.val);
                    cur=cur.left;
                }
                else
                {
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