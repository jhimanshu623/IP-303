import java.util.*;

public class p6 {
    static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    // solution 1
    // O(logn) space
    // O(2n) time

    public List<TreeNode> rootToNode(TreeNode node,int val)
    {
        if(node==null)
            return null;
        if(node.val==val)
        {
            List<TreeNode> res=new ArrayList<>();
            res.add(node);
            return res;
        }
        List<TreeNode> lpath=rootToNode(node.left,val);
        if(lpath!=null)
        {
            lpath.add(node);
            return lpath;
        }
        List<TreeNode> rpath=rootToNode(node.right,val);
        if(rpath!=null)
        {
            rpath.add(node);
            return rpath;
        }
        return null;
    }
    public void kDown(TreeNode node,TreeNode avoid,int k,List<Integer> res)
    {
        if(node==null || node==avoid)
            return;
        if(k==0)
        {
            res.add(node.val);
            return;
        }
        kDown(node.left,avoid,k-1,res);
        kDown(node.right,avoid,k-1,res);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> rtnp=rootToNode(root,target.val);
        List<Integer> res=new ArrayList<>();
        TreeNode avoid=null;
        for(int i=0;i<rtnp.size();i++)
        {
            kDown(rtnp.get(i),avoid,k-i,res);
            avoid=rtnp.get(i);
        }
        return res;
    }

    // solution 2
    // O(n) space
    // O(2n) time
    HashMap<Integer,TreeNode> par=new HashMap<>();
    public void getParent(TreeNode node,TreeNode p)
    {
        if(node==null)
            return;
        par.put(node.val,p);
        p=node;
        getParent(node.left,p);
        getParent(node.right,p);
    }
    public List<Integer> distanceK2(TreeNode root, TreeNode target, int K) {
        getParent(root,null);
        LinkedList<TreeNode> que=new LinkedList<>();
        HashSet<Integer> isVisited=new HashSet<>();
        List<Integer> res=new ArrayList<>();
        int dist=0;
        que.addLast(target);
        while(que.size()>0)
        {
            if(dist==K)
                break;
            int size=que.size();
            while(size-->0)
            {
                TreeNode rm=que.removeFirst();
                isVisited.add(rm.val);
                if(rm.left!=null && isVisited.contains(rm.left.val)==false)
                    que.addLast(rm.left);
                if(rm.right!=null && isVisited.contains(rm.right.val)==false)
                    que.addLast(rm.right);
                TreeNode p=par.get(rm.val);
                if(p!=null && isVisited.contains(p.val)==false)
                    que.addLast(p);
            }
            dist++;
        }
        while(que.size()>0)
            res.add(que.removeFirst().val);
        return res;
    }

    // solution 3
    // O(1) space excluding recursion stack
    // O(2n) time

    List<Integer> res=new ArrayList<>();
    public int solve(TreeNode node,int t,int k,int v)
    {
        if(node==null)
            return 0;
        if(v==k)
        {
            res.add(node.val);
            return 0;
        }
        int l=0;
        int r=0;
        if(v>0 || node.val==t)
        {
            l=solve(node.left,t,k,v+1);
            r=solve(node.right,t,k,v+1);
        }
        else
        {
            l=solve(node.left,t,k,v);
            r=solve(node.right,t,k,v);
        }
        if(l==k || r==k)
        {
            res.add(node.val);
            return 0;
        }
        else if(l>0)
        {
            r=solve(node.right,t,k,l+1);
            return l+1;
        }
        else if(r>0)
        {
            l=solve(node.left,t,k,r+1);
            return r+1;
        }
        else if(node.val==t)
            return 1;
        return 0;
    }
    public List<Integer> distanceK3(TreeNode root, TreeNode target, int K) {
        if(K==0)
        {
            res.add(target.val);
            return res;
        }
        solve(root,target.val,K,0);
        return res;
    }
    public static void main(String[] args) {
        
    }
}