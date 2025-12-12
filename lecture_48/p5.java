public class p5 {
    public static void merge(int[] arr,int l,int m,int r)
    {
        int[] arr1=new int[m-l+1];
        int[] arr2=new int[r-m];
        for(int i=l;i<=m;i++)
        {
            arr1[i-l]=arr[i];
        }
        for(int i=m+1;i<=r;i++)
        {
            arr2[i-(m+1)]=arr[i];
        }
        int i=0;
        int j=0;
        int k=l;
        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]<arr2[j])
            {
                arr[k]=arr1[i];
                k++;
                i++;
            }
            else
            {
                arr[k]=arr2[j];
                k++;
                j++;
            }
        }
        while(i<arr1.length)
        {
           arr[k]=arr1[i];
           k++;
           i++;
        }
        while(j<arr2.length)   
        {
           arr[k]=arr2[j];
           k++;
           j++;
        }
    }
    public static void mergeSort(int[] nums,int l,int h)
    {
        if(l>=h)
            return;
        int mid=l+(h-l)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, h);
        merge(nums,l,mid,h);
    }
    public static void main(String args[])
    {
        int[] nums={10,8,14,6,12,25,1,9};
        mergeSort(nums,0,nums.length-1);
        for(int i:nums)
            System.out.print(i+" ");
        System.out.println();
    }
}