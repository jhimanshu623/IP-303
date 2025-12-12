import java.util.Stack;

public class p1
{
    public static int[] nextGreater(int arr[])
    {
        int res[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            while(st.size()>0 && arr[i]>=arr[st.peek()])
            {
                int idx=st.pop();
                res[idx]=arr[i];
            }
            st.push(i);
        }
        while(st.size()>0)
        {
            int idx=st.pop();
            res[idx]=-1;
        }
        return res;
    }

    public static long[] nextGreaterElements1(long arr[])
    {
        int n=arr.length;
        long[] ans=new long[n];
        Stack<Long> st=new Stack();
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && st.peek()<arr[i])
                st.pop();
            if(st.size()==0){
                ans[i]=-1;
            }else{
                ans[i]=st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={4,2,1,10,3,9,7,20,18};
        int res[]=nextGreater(arr);
        for(int i:res)
            System.out.print(i+" ");
        System.out.println();
    }
}