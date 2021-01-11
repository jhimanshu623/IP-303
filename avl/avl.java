public class avl {
    static class Node
    {
        int val;
        Node left;
        Node right;
        int height;
        int balance;
        Node(int val)
        {
            this.val=val;
            this.left=null;
            this.right=null;
        }
        Node(int val,Node left,Node right)
        {
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static Node createBst(int[] arr,int st,int end)
    {
        if(st>end)
            return null;
        int mid=st+(end-st)/2;
        Node node=new Node(arr[mid]);
        node.left=createBst(arr, st, mid-1);
        node.right=createBst(arr, mid+1, end);
        return node;
    }
    public static void display(Node node)
    {
        if(node==null)
            return;
        String str=node.val+" -> ";
        str+=((node.left!=null)?node.left.val:"." )+ " , ";
        str+=((node.right!=null)?node.right.val:".");
        System.out.println(str);
        display(node.left);
        display(node.right);
    }


    // in avl
    public static Node addNode(Node node,int val) {
        if(node==null)
            return new Node(val);
        if(val<node.val)
            node.left=addNode(node.left,val);
        else
            node.right=addNode(node.right,val);
        node=getRotate(node);   //this line converting bst to avl
        return node;
    }

    // in avl
    public static Node deleteNode(Node node,int val) {
        if(node==null)
            return null;
        if(node.val==val)
        {
            if(node.left==null && node.right==null)
                return null;
            else if(node.left==null)
                return node.right;
            else if(node.right==null)
                return node.left;
            else
            {
                Node temp=node.left;
                while(temp.right!=null)
                    temp=temp.right;
                node.val=temp.val;
                node.left=deleteNode(node.left, temp.val);
            }
        }
        else if(val<node.val)
            node.left=deleteNode(node.left,val);
        else
            node.right=deleteNode(node.right, val);
        node=getRotate(node);  //this line converting bst to avl
        return node;
    }


    public static Node ll(Node node)
    {
        Node y=node.left;
        Node yright=y.right;
        y.right=node;
        x.left=yright;
        updateHeightBal(node);
        updateHeightBal(y);
        return y;
    }

    public static Node rr(Node node)
    {
        Node y=node.right;
        Node yleft=y.left;
        y.left=node;
        node.right=yleft;
        updateHeightBal(node);
        updateHeightBal(y);
        return y;
    }

    // perform rotation if required
    public static Node getRotate(Node node)
    {
        updateHeightBal(node);     //update details of node
        if(node.balance==2){ // ll,lr
            if(node.left.balance==1){ // ll
                return ll(node);
            }else{  // lr
                node.left=rr(node.left);
                return ll(node);
            }
        }else{ // rr,rl
            if(node.right.balance==-1){ // rr
                return rr(node);
            }else{ // rl
                node.right=ll(node.right);
                return rr(node);
            }
        }
    }
    public static void updateHeightBal(Node node)
    {
        int lh=-1;
        int rh=-1;
        if(node.left!=null)
            lh=node.left.height;
        if(node.right!=null)
            rh=node.right.height;
        node.height=Math.max(lh,rh)+1;
        node.balance=node.left.height-node.right.height;
    }
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60,70,80,90};
        Node root=createBst(arr,0,arr.length-1);
        // display(root);
        root=addNode(root,25);
        // display(root);
        root=deleteNode(root, 20);
        display(root);
    }
}