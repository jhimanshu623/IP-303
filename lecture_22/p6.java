import java.util.List;
import java.util.ArrayList;
public class p6 {

    // 1ms
    public static List<Integer> getRow(int n) {
        List<Integer> res=new ArrayList<>();
        res.add(1);
        for(int k=1;k<=n;k++)
        {
            for(int i=res.size()-1;i>=1;i--)
            {
                res.set(i,res.get(i)+res.get(i-1));
            }
            res.add(1);
        }
        return res;
    }

    // 0ms
    public static List<Integer> getRow2(int n) {
        List<Integer> res=new ArrayList<>();
        long ncr=1;
        res.add((int)ncr);
        for(int r=0;r<n;r++)
        {
            ncr= ncr * (n-r) / (r+1);   //first solve ncr*(n-r) ,then divide by (r+1) , try for n=4,r=3
            res.add((int)ncr);
        }
        return res;
    }

    public static void main(String[] args) {
        int n=3;
        // List<Integer> res=getRow(n);
        List<Integer> res=getRow2(n);
        for(int i:res)
            System.out.print(i+" ");
    }
}