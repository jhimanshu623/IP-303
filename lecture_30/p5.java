public class p4 {
    // using bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        LinkedList<TreeNode> que=new LinkedList<>();
        if(root!=null)
            que.addLast(root);
        while(que.size()>0)
        {
            int size=que.size();
            List<Integer> tres=new ArrayList<>();
            while(size-->0)
            {
                TreeNode rn=que.removeFirst();
                tres.add(rn.val);
                if(rn.left!=null)
                    que.addLast(rn.left);
                if(rn.right!=null)
                    que.addLast(rn.right);
            }
            res.add(tres);
        }
        return res;
    }

    // using dfs
    public void solve(List<List<Integer>> res,TreeNode root,int d)
    {
        if(root==null)
            return;
        if(d>=res.size())
            res.add(new ArrayList<>());
        res.get(d).add(root.val);
        solve(res,root.left,d+1);
        solve(res,root.right,d+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        solve(res,root,0);
        return res;
    }

    public static void main(String[] args) {
        
    }
}