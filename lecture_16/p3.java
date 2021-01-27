package lecture_16;

import java.util.HashMap;

public class p3
{
    // 633ms
    public static int kEmptySlots(int slots[],int k)
    {
        int arr[]=new int[slots.length];
        for(int i=0;i<slots.length;i++)
        {
            arr[slots[i]-1]=i+1;
        }
        slots=arr;
        int i=0;
        int j=i+k+1;
        int ans=slots.length+1;
        while(j<slots.length)
        {
            int temp=i+1;
            while(temp<j)
            {
                if(slots[temp]>slots[i] && slots[temp]>slots[j])
                    temp++;
                else
                    break;
            }
            if(temp==j)
                ans=Math.min(ans,Math.max(slots[i],slots[j]));
            i++;
            j=i+k+1;
        }
        return ans<slots.length+1?ans:-1;
    }
    public static int kEmptySlots2(int slots[],int k)
    {
        int arr[]=new int[slots.length];
        for(int i=0;i<slots.length;i++)
        {
            arr[slots[i]-1]=i+1;
        }
        slots=arr;
        int i=0;
        int j=i+k+1;
        int ans=slots.length+1;
        while(j<slots.length)
        {
            int temp=i+1;
            while(temp<j)
            {
                if(slots[temp]>slots[i] && slots[temp]>slots[j])
                    temp++;
                else{
                    i=temp;
                    break;
                }
            }
            if(temp==j){
                ans=Math.min(ans,Math.max(slots[i],slots[j]));
                i=j;
            }  
            j=i+k+1;
        }
        return ans<slots.length+1?ans:-1;
    }
    public static void main(String args[])
    {
        int k=2;
        int slots[]={2,5,1,4,3};
        System.out.println(kEmptySlots(slots,k));  
        System.out.println(kEmptySlots2(slots,k));        
    }
}