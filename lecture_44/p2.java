public class p2
{
    static class Pair
    {
        int x;
        int y;
        int g;
        Pair(int x,int y,int g)
        {
            this.x=x;
            this.y=y;
            this.g=g;
        }
    }
    public static Pair extendedEucledian(int a,int b)
    {
        if(b==0)
            return new Pair(1,0,a);
        Pair p=extendedEucledian(b,a%b);
        int x=p.y;
        int y=p.x - (a/b)*p.y;
        return new Pair(x,y,p.g);
    }
    public static void main(String args[])
    {
        int a=17;
        int b=17;
        Pair ans=extendedEucledian(a,b);
        System.out.println(ans.x+" "+ans.y+" "+ans.g);
    }
}