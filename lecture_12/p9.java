import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class Pair
    {
        int st;
        int end;
        int freq;
        Pair(int st,int end,int freq)
        {
            this.st=st;
            this.end=end;
            this.freq=freq;
        }
    }
    public static void solve(int[] arr)
    {
        int gf=0;
        int gs=-1;
        int ge=-1;
        int val2 = -1;
        HashMap<Integer,Pair> map=new HashMap<>();
       
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i])==true)
            {
                Pair p=map.get(arr[i]);
                p.freq++;
                p.end=i;
                map.put(arr[i],p);
            }
            else
            {
                map.put(arr[i],new Pair(i,i,1));
               
            }
        }
        for(int val:map.keySet())
        {
            Pair p=map.get(val);
            if(p.freq > gf)
            {
                gf=p.freq;
                gs=p.st;
                ge=p.end;
                
            }
            else if(p.freq==gf && (p.end-p.st+1)<(ge-gs+1))
            {
                gf=p.freq;
                gs=p.st;
                ge=p.end;
            }else if(p.freq==gf && (p.end-p.st+1)==(ge-gs+1) && p.st < gs){
                gf=p.freq;
                gs=p.st;
                ge=p.end;
            }
        }
        for(int i=gs;i<=ge;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // in one iteration
    public static void solve2(int[] arr)
    {
        int gf=0;
        int gs=-1;
        int ge=-1;
        int val2 = -1;
        HashMap<Integer,Pair> map=new HashMap<>();
       
        for(int i=0;i<arr.length;i++)
        {
            Pair p=null;
            if(map.containsKey(arr[i])==true)
            {
                p=map.get(arr[i]);
                p.freq++;
                p.end=i;
                map.put(arr[i],p);
            }
            else
            {
                p=new Pair(i,i,1);
                map.put(arr[i],p);
            }
            if(p.freq > gf)
            {
                gf=p.freq;
                gs=p.st;
                ge=p.end;
                
            }
            else if(p.freq==gf && (p.end-p.st+1)<(ge-gs+1))
            {
                gf=p.freq;
                gs=p.st;
                ge=p.end;
            }else if(p.freq==gf && (p.end-p.st+1)==(ge-gs+1) && p.st < gs){
                gf=p.freq;
                gs=p.st;
                ge=p.end;
            }
        }
        for(int i=gs;i<=ge;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    int n=Integer.parseInt(br.readLine());
		    String input[] = br.readLine().split(" ");
		    
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++)
		        arr[i]=Integer.parseInt(input[i]);
		    solve(arr);
		}
	}
}