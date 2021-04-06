package lecture_20;

public class p1
{
    // 0ms
    public static int maximumSwap(int num) {
        int count=0;
        int x=num;
        while(x>0)
        {
            count++;
            x=x/10;
        }
        int arr[]=new int[count];
        x=num;
        for(int i=arr.length-1;i>=0;i--)
        {
            arr[i]=x%10;
            x=x/10;
        }
        int i;
        for(i=0;i<arr.length-1;i++)
        {
            if(arr[i]<arr[i+1])
                break;
        }
        if(i==arr.length-1)
            return num;
        int max=i;
        i++;
        while(i<arr.length)
        {
            if(arr[max]<=arr[i])
                max=i;
            i++;
        }
        i=0;
        while(i<arr.length)
        {
            if(arr[i]<arr[max]){
                int t=arr[i];
                arr[i]=arr[max];
                arr[max]=t;
                break;
            }
            i++;
        }
        x=0;
        for(int j=0;j<arr.length;j++)
        {
            x=x*10+arr[j];
        }
        return x;
    }
    // 5ms
    public static int maximumSwap2(int num) {
        StringBuilder str=new StringBuilder(num+"");
        int midx=str.length()-1;
        for(int i=0;i<str.length()-1;i++)
        {
            if(str.charAt(i)-'0'<str.charAt(i+1)-'0')
            {
                midx=i;
                i++;
                while(i<str.length())
                {
                    if(str.charAt(midx)-'0'<=str.charAt(i)-'0')
                        midx=i;
                    i++;
                }
            }
        }
        for(int i=0;i<=midx;i++)
        {
            if(str.charAt(i)-'0'<str.charAt(midx)-'0')
            {
                char c=str.charAt(i);
                str.setCharAt(i,str.charAt(midx));
                str.setCharAt(midx, c);
                break;
            }
        }
        return Integer.parseInt(str.toString());
    }

    // 9ms
    public int maximumSwap3(int num) {
        StringBuilder arr=new StringBuilder(num+"");
        int rmax=arr.charAt(arr.length()-1)-'0';
        int r=arr.length()-1;
        int al=-1;
        int ar=arr.length()-1;
        for(int i=arr.length()-2;i>=0;i--)
        {
            if(arr.charAt(i)-'0' < rmax)
            {
                al=i;
                ar=r;
            }
            else if(arr.charAt(i)-'0' > rmax)
            {
                r=i;
                rmax=Math.max(rmax,arr.charAt(i)-'0');   
            }
        }
        if(al!=-1)
        {
            char temp=arr.charAt(al);
            arr.setCharAt(al,arr.charAt(ar));
            arr.setCharAt(ar,temp);
            return Integer.parseInt(arr.toString());
        }
        return num;
    }

    public static void main(String[] args) {
        int n=19931227;
        System.out.println(maximumSwap(n));
        System.out.println(maximumSwap2(n));
    }
}