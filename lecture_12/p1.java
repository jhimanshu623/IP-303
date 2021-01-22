import java.util.HashMap;

public class p1
{
    public static int gcd(int a,int b)
    {
        while(a!=0)
        {
            int rem=b%a;
            b=a;
            a=rem;
        }
        return b;
    }
    public static boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:deck)
            map.put(val,map.getOrDefault(val,0)+1);
        int g=map.remove(deck[0]);
        for(int val:map.keySet())
        {
            g=gcd(g,map.get(val));
        }
        return g>=2?true:false;
    }
    public static void main(String[] args) {
        int deck[]={1,2,3,4,4,3,2,1};
        System.out.println(hasGroupsSizeX(deck));
    }
}