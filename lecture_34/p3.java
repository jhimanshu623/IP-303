public class p3 {
    // bst from postorder
    static class Node{
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }
    static class Pair
    {
        Node node;
        int min;
        int max;
        boolean isLeft;
        Pair(Node node,int min,int max,boolean isLeft)
        {
            this.node=node;
            this.min=min;
            this.max=max;
            this.isLeft=isLeft;
        }
    }
    public static Node constructTree(int post[],int n)
    {
        if(post.length==0)
            return null;
        Stack<Pair> st=new Stack<>();
        Node root=new Node(post[n-1]);
        st.push(new Pair(root,Integer.MIN_VALUE,root.data-1,true));
        st.push(new Pair(root,root.data+1,Integer.MAX_VALUE,false));

        for(int i=n-2;i>=0;i--)
        {
            while(st.size()>0 && !(post[i]>=st.peek().min && post[i]<=st.peek().max))
                st.pop();
            Pair rp=st.pop();
            Node nn=new Node(post[i]);
            if(rp.isLeft)
                rp.node.left=nn;
            else
                rp.node.right=nn;
            st.push(new Pair(nn,rp.min,nn.data-1,true));
            st.push(new Pair(nn,nn.data+1,rp.max,false));
        }
        return root;
    }
    public static void display(Node node)
    {
        if(node==null)
            return;
        System.out.print(node.data+"  ");
        display(node.left);
        display(node.right);
    }


    // bst from preorder
    class Pair
    {
        TreeNode node;
        int min;
        int max;
        boolean isLeft;
        Pair(TreeNode node,int min,int max,boolean isLeft)
        {
            this.node=node;
            this.min=min;
            this.max=max;
            this.isLeft=isLeft;
        }
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0)
            return null;
        Stack<Pair> st=new Stack<>();
        TreeNode root=new TreeNode(preorder[0]);
        st.push(new Pair(root,root.val+1,Integer.MAX_VALUE,false));
        st.push(new Pair(root,Integer.MIN_VALUE,root.val-1,true));
        
        for(int i=1;i<preorder.length;i++)
        {
            // no need to check st.size()>0 , as any element in array is goona attach to some node(which is already present in stack)
            while(st.size()>0 && !(preorder[i]>=st.peek().min && preorder[i]<=st.peek().max))
                st.pop();
            Pair rp;
            if(st.size()>0)
                rp=st.pop();
            else
                continue;
            TreeNode n=new TreeNode(preorder[i]);
            if(rp.isLeft)
                rp.node.left=n;
            else
                rp.node.right=n;
            st.push(new Pair(n,n.val+1,rp.max,false));
            st.push(new Pair(n,rp.min,n.val-1,true));
        }
        return root;
    }

    public TreeNode solve(int preorder[],int min,int max,TreeNode i)
    {
        if(i.val>=preorder.length || preorder[i.val]<min || preorder[i.val]>max)
            return null;
        TreeNode node=new TreeNode(preorder[i.val]);
        i.val++;
        node.left=solve(preorder,min,node.val-1,i);
        node.right=solve(preorder,node.val+1,max,i);
        return node;
    }
    public TreeNode bstFromPreorder2(int[] preorder) 
    {
        if(preorder.length==0)
            return null;
        TreeNode i=new TreeNode(0);
        return solve(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE,i);
    }
    public static void main(String[] args) {
        
    }
}