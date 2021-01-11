import java.util.ArrayList;
import java.util.Scanner;


public class p2 {

    public static void solve(ArrayList<Integer> arr1,ArrayList<Character> arr2)
    {
        int n=arr1.size();
        int[][] min=new int[n][n];
        int[][] max=new int[n][n];
        for(int g=0;g<n;g++)
        {
            for(int i=0;i<n-g;i++)
            {
                int j=i+g;
                if(g==0){
                    min[i][j]=arr1.get(i);
                    max[i][j]=arr1.get(i);
                }
                else{
                    min[i][j]=Integer.MAX_VALUE;
                    max[i][j]=Integer.MIN_VALUE;
                    for(int k=0;k<g;k++)
                    {
                        int l_min=min[i][i+k];
                        int r_min=min[i+1+k][j];
                        int l_max=max[i][i+k];
                        int r_max=max[i+1+k][j];
                        if(arr2.get(i+k)=='+')
                        {
                            min[i][j]=Math.min(min[i][j],l_min+r_min);
                            max[i][j]=Math.max(max[i][j],l_max+r_max);
                        }
                        else
                        {
                            min[i][j]=Math.min(min[i][j],l_min*r_min);
                            max[i][j]=Math.max(max[i][j],l_max*r_max);
                        }
                    }
                }
            }
        }
        System.out.println(min[0][n-1]+" "+max[0][n-1]);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Character> arr2=new ArrayList<>();
        for(int i=0;i<str.length();i++)
        {
            if(i%2==0)
                arr1.add(str.charAt(i)-'0');
            else
                arr2.add(str.charAt(i));
        }
        solve(arr1,arr2);
    }
}
