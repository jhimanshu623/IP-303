public class p7 {
    static Node temp;
    public static Node convertToBst(int n)
    {
        if(n==0)
            return null;
        Node l=convertToBst(n/2);
        Node root=temp;
        temp=temp.next;
        root.prev=l;
        root.next=convertToBst(n-n/2-1);
        return root;
    }
    public static void main(String args[])
    {
        convertToBst(n);

    }
}