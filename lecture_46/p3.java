public class p3
{
    public static int[] zFunction(String s)
    {
        int[] z=new int[s.length()];
        int l=0;
        int r=0;
        for(int i=1;i<z.length;i++)
        {
            if(i<=r)
                z[i]=Math.min(z[i-l],r-i+1);
            while(i+z[i]<z.length && s.charAt(z[i])==s.charAt(i+z[i]))
                z[i]++;
            if(i+z[i]-1<r)
            {
                l=i;
                r=i+z[i]-1;
            }
        }
        return z;
    }
    public static void zAlgo(String text,String pat)
    {
        String s=pat+"#"+text;
        int[] z=zFunction(s);
        for(int i=0;i<z.length;i++)
        {
            if(z[i]==pat.length())
                System.out.println(i-pat.length()-1);
        }
    }
    public static void main(String args[])
    {
        String text="ababadababe";
        String pat="ab";
        zAlgo(text,pat);
    }
}