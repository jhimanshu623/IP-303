class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
class Tree
{ 
    public void merge(Node tail1,Node tail2)
    {
        Node head1=tail1.right;
        Node head2=tail2.right;
        tail1.right=head2;
        head2.left=tail1;
        head1.left=tail2;
        tail2.right=head1;
    }
    Node solve(Node root)
    {
        if(root==null)
            return null;
        Node l=solve(root.left);
        Node r=solve(root.right);
        root.right=root;
        root.left=root;
        if(l==null && r==null)
        {
            return root;
        }
        else if(l==null)
        {
            merge(root,r);
            return r;
        }
        else if(r==null)
        {
            merge(l,root);
            return root;
        }
        else
        {
            merge(l,root);
            merge(root,r);
            return r;
        }
    }
    Node bTreeToClist(Node root)
    {
        if(root==null)
        return null;
        return solve(root).right;
    }
    
}