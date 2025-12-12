public class p1
{
    public static void setMapping(Tree node)
    {
        if(node==null)
            return;
        setMapping(node.left);
        Tree n=new Tree(node.data);
        n.left=node.left;
        node.left=n;
        setMapping(node.right);
    }
    public static void setRandom(Tree node)
    {
        if(node==null)
            return;
        if(node.random!=null)
            node.left.random=node.random.left;
        setRandom(node.left.left);
        setRandom(node.right);
    }
    public static Tree extract(Tree node)
    {
        if(node==null)
            return null;
        Tree l=extract(node.left.left);
        Tree r=extract(node.right);
        if(l==null && r==null)
        {
            Tree myclone=node.left;
            node.left=null;
            return myclone;
        }
        else if(l==null)
        {
            Tree myclone=node.left;
            node.left=null;
            myclone.right=r;
            return myclone;
        }
        else if(r==null)
        {
            Tree myclone=node.left;
            node.left=node.left.left;
            myclone.left=l;
            return myclone;
        }
        else
        {
            Tree myclone=node.left;
            node.left=node.left.left;
            myclone.left=l;
            myclone.right=r;
            return myclone;
        }
    }
    public static Tree cloneTree(Tree tree){
        setMapping(tree);
        setRandom(tree);
        return extract(tree);
    }
    public static void main(String args[])
    {

    }
}