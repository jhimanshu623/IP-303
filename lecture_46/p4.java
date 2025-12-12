public class p4 {
    public static int manachers(String s)
    {
        String str="";
        for(int i=0;i<s.length();i++)
        {
            str+="#";
            str+=s.charAt(i);
        }
        str+="#";
        int[] p=new int[str.length()];
        int r=0;
        int c=0;
        for(int i=1;i<p.length;i++)
        {
            int mirr=2*c-i;
            if(i<r)
                p[i]=Math.min(p[mirr],r-i);
            while(i+(p[i]+1) < p.length && i-(p[i]+1) >=0 && str.charAt(i+(p[i]+1)) == str.charAt(i-(p[i]+1)) )
                p[i]++;
            if(i+p[i]>r)
            {
                c=i;
                r=i+p[i];
            }
        }
        int ans=0;
        for(int i:p){
            System.out.print(i+" ");
            ans=Math.max(ans,i);
        }
        System.out.println();
        return ans;
    }
    public static void main(String[] args) {
        String s="abababa";
        System.out.println(manachers(s));
    }
}