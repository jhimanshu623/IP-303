import java.util.Stack;

public class p4
{
    public static int[] stockSpan(int arr[])
    {
        int res[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            while(st.size()>0 && arr[i]>arr[st.peek()])
            {
                int idx=st.pop();
                res[idx]=idx-i;
            }
            st.push(i);
        }
        while(st.size()>0)
        {
            int idx=st.pop();
            res[idx]=idx+1;
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[]={100,80,60,70,60,75,85};
        int res[]=stockSpan(arr);
        for(int i:res)
            System.out.print(i+" ");
        System.out.println();
    }
}