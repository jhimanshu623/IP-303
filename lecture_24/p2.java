import java.util.Stack;

public class p2
{
    public static int[] nextGreaterElements(int arr[])
    {
        int res[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int in=0;in<2*arr.length;in++)
        {
            int i=in%arr.length;
            while(st.size()>0 && arr[st.peek()]<arr[i])
            {
                int idx=st.pop();
                res[idx]=arr[i];
            }
            if(in<arr.length)
                st.push(i);
        }
        while(st.size()>0)
        {
            int idx=st.pop();
            res[idx]=-1;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[]={5,9,1,4,10,8,7,6};
        int res[]=nextGreaterElements(arr);
        for(int i:res)
            System.out.print(i+" ");
        System.out.println();
    }
}