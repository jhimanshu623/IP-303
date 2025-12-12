public class p3 {
    
    // simple find code
    // if either both nodes present or both are absent
    // 5ms
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root==p || root==q)
            return root;
        TreeNode l=lowestCommonAncestor(root.left,p,q);
        TreeNode r=lowestCommonAncestor(root.right,p,q);
        if(l!=null && r!=null)
            return root;
        return l!=null?l:r;
    }

    // using rootTONode path
    // 7ms
    public ArrayList<TreeNode> rootToNodePath(TreeNode node,TreeNode t)
    {
        if(node==null)
            return null;
        
        if(node==t)
        {
            ArrayList<TreeNode> res=new ArrayList<>();
            res.add(node);
            return res;
        }
        ArrayList<TreeNode> l=rootToNodePath(node.left,t);
        if(l!=null)
        {
            l.add(node);
            return l;
        }
        ArrayList<TreeNode> r=rootToNodePath(node.right,t);
        if(r!=null)
        {
            r.add(node);
            return r;
        }
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> rtnp1=rootToNodePath(root,p);
        ArrayList<TreeNode> rtnp2=rootToNodePath(root,q);
        if(rtnp1==null || rtnp2==null)
            return null;
        int i=rtnp1.size()-1;
        int j=rtnp2.size()-1;
        TreeNode lca=null;
        while(i>=0 && j>=0 && rtnp1.get(i)==rtnp2.get(j))
        {
            lca=rtnp1.get(i);
            i--;
            j--;
        }
        return lca;
    }
    
    // using self
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode self=null;
        if(root==null)
            return null;
        if(root==p || root==q)
            self=root;
        TreeNode l=lowestCommonAncestor(root.left,p,q);
        TreeNode r=lowestCommonAncestor(root.right,p,q);
        if((self!=null && l!=null) || (self!=null && r!=null) || (l!=null && r!=null))
            return root;
        if(self!=null)
            return self;
        return l!=null?l:r;
    }

    // for multiple queries
    // O(nh) for n queries
    HashMap <TreeNode,TreeNode> par=new HashMap<>();
    HashMap<Integer,Integer> level=new HashMap<>();
    public void dfs(TreeNode node,TreeNode p,int l)
    {
        if(node==null)
            return;
        par.put(node,p);
        level.put(node.val,l);
        dfs(node.left,node,l+1);
        dfs(node.right,node,l+1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,null,0);
        TreeNode cur1=p;
        TreeNode cur2=q;
        if(par.containsKey(p)==false || par.containsKey(q)==false)
            return null;
        while(cur1!=null && cur2!=null && level.get(cur1.val)!=level.get(cur2.val))
        {
            if(level.get(cur1.val)>level.get(cur2.val))
                cur1=par.get(cur1);
            else
                cur2=par.get(cur2);
        }
        while(par.get(cur1)!=par.get(cur2))
        {
            cur1=par.get(cur1);
            cur2=par.get(cur2);
        }
        if(cur1==cur2)
            return cur1;
        return par.get(cur1);
    }

    // if both integers are given as input

    // solution 1
    HashMap<Integer,Node> par=new HashMap<>();
    HashMap<Integer,Integer> level=new HashMap<>();
    HashMap<Integer,Node> nmap=new HashMap<>();
    public void dfs(Node node,Node p,int l)
    {
        if(node==null)
            return;
        nmap.put(node.data,node);
        par.put(node.data,p);
        level.put(node.data,l);
        dfs(node.left,node,l+1);
        dfs(node.right,node,l+1);
    }
	Node lca(Node root, int n1,int n2)
	{
	    dfs(root,null,0);
        int cur1=n1;
        int cur2=n2;
        if(par.containsKey(cur1)==false || par.containsKey(cur2)==false)
            return null;
        while(level.get(cur1)!=level.get(cur2))
        {
            if(level.get(cur1)>level.get(cur2))
                cur1=par.get(cur1).data;
            else
                cur2=par.get(cur2).data;
        }
        while(par.get(cur1)!=par.get(cur2))
        {
            cur1=par.get(cur1).data;
            cur2=par.get(cur2).data;
        }
        if(cur1==cur2)
            return nmap.get(cur1);
        return par.get(cur1);
    }
    
    // solution 2
    HashMap<Integer,Node> par=new HashMap<>();
    HashMap<Integer,Integer> level=new HashMap<>();
    public void dfs(Node node,Node p,int l)
    {
        if(node==null)
            return;
        level.put(node.data,l);
        par.put(node.data,p);
        dfs(node.left,node,l+1);
        dfs(node.right,node,l+1);
    }
	Node lca(Node root, int n1,int n2)
	{
	    dfs(root,null,0);
        int cur1=n1;
        int cur2=n2;
        if(par.containsKey(cur1)==false || par.containsKey(cur2)==false)
            return null;
        while(level.get(cur1)!=level.get(cur2))
        {
            if(par.get(cur1)!=null && par.get(cur1).data==cur2)
                return par.get(cur1);
            if(par.get(cur2)!=null && par.get(cur2).data==cur1)
                return par.get(cur2);
            if(level.get(cur1)>level.get(cur2))
                cur1=par.get(cur1).data;
            else
                cur2=par.get(cur2).data;
        }
            
        while(par.get(cur1)!=par.get(cur2))
        {
            cur1=par.get(cur1).data;
            cur2=par.get(cur2).data;
        }
        return par.get(cur1);
	}

    // for multiple queries
    // O(n * sqrt(h)) for n queries
    class Tree
    {
    
    /* If n1 and n2 are present, return reference
       to LCA. If both are not present, return 
       null,. Else if left subtree contains any 
       of them return pointer to left.*/
        HashMap<Integer,Node> par=new HashMap<>();
        HashMap<Integer,Integer> level=new HashMap<>();
        HashMap<Integer,Node> gpar=new HashMap<>();
        int tl=0;
        int bs=0;
        // to find parent and level
        public void dfs1(Node node,Node p,int l)
        {
            if(node==null)
                return;
            tl=Math.max(tl,l);
            par.put(node.data,p);
            level.put(node.data,l);
            dfs1(node.left,node,l+1);
            dfs1(node.right,node,l+1);
        }
        // to find grandparent
        public void dfs2(Node node,Node p,int l)
        {
            if(node==null)
                return;
            if(l%bs==0)
                gpar.put(node.data,p);
            else
                gpar.put(node.data,gpar.get(p.data));
            dfs2(node.left,node,l+1);
            dfs2(node.right,node,l+1);
        }
        public void preProcess(Node node)
        {
            dfs1(node,null,0);
            tl++;
            bs=(int)Math.ceil(Math.sqrt(tl));
            gpar.put(node.data,null);
            dfs2(node.left,node,1);
            dfs2(node.right,node,1);
        }
        Node lca(Node root, int n1,int n2)
        {
            preProcess(root);
            if(par.containsKey(n1)==false || par.containsKey(n2)==false)
                return null;
            int cur1=n1;
            int cur2=n2;
           // do box and grandparent same
           while(gpar.get(cur1)!=gpar.get(cur2))
           {
               if(gpar.get(cur1)!=null && gpar.get(cur1).data==cur2)
                    return gpar.get(cur1);
               if(gpar.get(cur2)!=null && gpar.get(cur2).data==cur1)
                    return gpar.get(cur2);
               if(level.get(cur1) > level.get(cur2))
                    cur1=gpar.get(cur1).data;
               else
                    cur2=gpar.get(cur2).data;
           }
           
           
           //do level same
           while(level.get(cur1)!=level.get(cur2))
           {
               if(par.get(cur1)!=null && par.get(cur1).data==cur2)
                    return par.get(cur1);
               if(par.get(cur2)!=null && par.get(cur2).data==cur1)
                    return par.get(cur2);
               if(level.get(cur1) > level.get(cur2))
                    cur1=par.get(cur1).data;
               else
                   cur2=par.get(cur2).data;
           }
           
           //do grandparent same
           //while(gpar.get(cur1)!=gpar.get(cur2))
           //{
           //    cur1=gpar.get(cur1).data;
           //    cur2=gpar.get(cur2).data;
           //}
           
           //do parent same
           while(par.get(cur1)!=par.get(cur2))
           {
               //if(par.get(cur1).data==cur2)
               //     return par.get(cur1);
               //if(par.get(cur2).data==cur1)
               //     return par.get(cur2);
               cur1=par.get(cur1).data;
               cur2=par.get(cur2).data;
           }
           return par.get(cur1);
        }
    }
}    
