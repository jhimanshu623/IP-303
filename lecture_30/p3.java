public class p3 {
    
    // POSTORDER
    // recursive
    List<Integer> res=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode cur) {
        if(cur==null)
            return res;
        postorderTraversal(cur.left);
        postorderTraversal(cur.right);
        res.add(cur.val);
        return res;
    }

    // using stack  
    static class Pair
    {
        TreeNode node;
        boolean ld;
        boolean rd;
        Pair(TreeNode node)
        {
            this.node=node;
            this.ld=false;
            this.rd=false;
        }
    }
    public List<Integer> postorderTraversal(TreeNode cur) {
        List<Integer> res=new ArrayList<>();
        Stack<Pair> st=new Stack<>();
        if(cur!=null)
            st.push(new Pair(cur));
        while(st.size()>0)
        {
            Pair rp=st.peek();
            if(rp.node==null)
                st.pop();
            else
            {
                if(rp.ld==false)
                {
                    rp.ld=true;
                    st.push(new Pair(rp.node.left));
                }
                else if(rp.rd==false)
                {
                    rp.rd=true;
                    st.push(new Pair(rp.node.right));
                }
                else
                {
                    res.add(rp.node.val);
                    st.pop();
                }
            }
        }
        return res;
    }
    // like morris
    // O(1) space
    public List<Integer> postorderTraversal(TreeNode cur) {
        List<Integer> res=new ArrayList<>();
        while(cur!=null)
        {
            if(cur.right==null)
            {
                res.add(cur.val);
                cur=cur.left;
            }
            else
            {
                TreeNode curp1=cur.right;
                while(curp1.left!=null && curp1.left!=cur)
                    curp1=curp1.left;
                if(curp1.left==null)
                {
                    curp1.left=cur;
                    res.add(cur.val);
                    cur=cur.right;
                }
                else
                {
                    curp1.left=null;
                    cur=cur.left;
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
    public static void main(String[] args) {
        
    }
}