import java.util.Stack;

public class p3
{
    public static int[] dailyTemperatures(int arr[])
    {
        int res[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            while(st.size()>0 && arr[i]>arr[st.peek()])
            {
                int idx=st.pop();
                res[idx]=i-idx;
            }
            st.push(i);
        }
        while(st.size()>0)
        {
            int idx=st.pop();
            res[idx]=0;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int arr[]={73, 74, 75, 71, 69, 72, 76, 73};
        int res[]=dailyTemperatures(arr);
        for(int i:res)
            System.out.print(i+" ");
        System.out.println();
    }
}