public class p4 {
    // SQUARE ROOT DECOMPOSITION
    public static int sumIToJ(int arr[],int l,int r)
    {
        int bs=(int)Math.ceil(Math.sqrt(arr.length));
        int temp[]=new int[bs];
        for(int i=0;i<arr.length;i++)
        {
            int idx=i/bs;
            temp[idx]+=arr[i];
        }
        int ans=0;
        int i=l;
        while(i<=r)
        {
            int idx=i/bs;
            if(i%bs==0)
            {
                if(r>=i+bs-1)
                {
                    ans+=temp[idx];
                    i=i+bs;
                }
                else
                {
                    ans+=arr[i];
                    i++;
                }
            }
            else
            {
                ans+=arr[i];
                i++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={2,6,-1,3,1,-2,4,8,7,-7,6,-5,3,2,1,-6,3,2,0,5};
        int l=3;
        int r=17;
        System.out.println(sumIToJ(arr,l,r));
    }
}