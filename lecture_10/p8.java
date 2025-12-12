import java.util.HashMap;

public class p8
{
    public static int countSub(String str)
    {
        int ans=0;
        HashMap<String,Integer> map=new HashMap<>();
        map.put("0*0",1);
        int c0=0;
        int c1=0;
        int c2=0;
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch=='0')
                c0++;
            else if(ch=='1')
                c1++;
            else
                c2++;
            String diff=(c0-c1)+"*"+(c1-c2);
            ans+=map.getOrDefault(diff, 0);
            map.put(diff,map.getOrDefault(diff, 0)+1);
        }
        return ans;
    }
    public static void main(String args[])
    {
       String str="102100211";
       System.out.println(countSub(str));
    }
}