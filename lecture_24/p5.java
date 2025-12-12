// solution 1
// using 2 arrays
class GfG
{
    public int[] leftSmaller(int[] arr)
    {
        int[] ls=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            while(st.size()>0 && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.size()==0)
                ls[i]=0;
            else
                ls[i]=arr[st.peek()];
            st.push(i);
        }
        return ls;
    }

    public int[] rightSmaller(int[] arr)
    {
        int[] rs=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            while(st.size()>0 && arr[i]<arr[st.peek()])
            {
                rs[st.pop()]=arr[i];
            }
            st.push(i);
        }
        while(st.size()>0)
        {
            rs[st.pop()]=0;
        }
        return rs;
    }
    int findMaxDiff(int arr[], int n)
    {
        int ans=0;
        int[] ls=leftSmaller(arr);
        int[] rs=rightSmaller(arr);
        for(int i=0;i<rs.length;i++)
        {
            ans=Math.max(ans,Math.abs(ls[i]-rs[i]));
        }
        return ans; 
    }
}


// using single stack
class Solution{
    int findMaxDiff(int arr[], int n)
    {
        int ans=0;
        Stack<Integer> st=new Stack<>();
        int ls=0;
        int rs=0;
        for(int i=0;i<arr.length;i++)
        {
            while(st.size()>0 && arr[i]<arr[st.peek()])
            {
                rs=arr[i];
                st.pop();
                if(st.size()==0)
                    ls=0;
                else
                    ls=arr[st.peek()];
                ans=Math.max(ans,Math.abs(ls-rs));
            }
            if(st.size()==0 || arr[st.peek()]!=arr[i])
                st.push(i);
        }
        while(st.size()>0)
        {
            rs=0;
            st.pop();
            if(st.size()==0)
                ls=0;
            else
                ls=arr[st.peek()];
            ans=Math.max(ans,Math.abs(ls-rs));
        }
        return ans; 
    }
}
class GfG
{
    int findMaxDiff(int arr[], int n)
    {
        int ans=0;
        Stack<Integer> st=new Stack<>();
        int ls=0;
        int rs=0;
        for(int i=0;i<arr.length;i++)
        {
            while(st.size()>0 && arr[i]<arr[st.peek()])
            {
                rs=arr[i];
                int val = arr[st.peek()];
                st.pop();
                while(st.size()>0 && arr[st.peek()]==val) // for case [2 4 8 7 7 9 3]
                    st.pop();
                if(st.size()>0)
                    ls=arr[st.peek()];
                else
                    ls=0;
                ans=Math.max(ans,Math.abs(ls-rs));
            }
            st.push(i);
        }
        while(st.size()>0)
        {
            rs=0;
            st.pop();
            if(st.size()>0)
                ls=arr[st.peek()];
            else
                ls=0;
            ans=Math.max(ans,Math.abs(ls-rs));
        }
        return ans; 
    }
}