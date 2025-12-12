class Solution {
public:
    int *par;
    int *ran;
    int find(int x)
    {
        if(par[x]==x)
            return x;
        int px=find(par[x]);
        par[x]=px;
        return px;
    }
    void merge(int xl,int yl)
    {
        if(ran[xl]<ran[yl])
            par[xl]=yl;
        else if(ran[yl]<ran[xl])
            par[yl]=xl;
        else
        {
            par[xl]=yl;
            ran[yl]++;
        }
    }
    bool isSimilar(string& s,string& t)
    {
        if(s==t)
            return true;
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s[i]!=t[i])
                count++;
            if(count>2)
                return false;
        }
        return true;
    }
    int numSimilarGroups(vector<string>& arr) {
        par=new int[arr.size()];
        ran=new int[arr.size()];
        for(int i=0;i<arr.size();i++)
        {
            par[i]=i;
            ran[i]=1;
        }
        int count=arr.size();
        for(int i=0;i<arr.size();i++)
        {
            for(int j=i+1;j<arr.size();j++)
            {
                if(isSimilar(arr[i],arr[j]))
                {
                    int xl=find(i);
                    int yl=find(j);
                    if(xl!=yl)
                    {
                        merge(xl,yl);
                        count--;   
                    }
                }
            }
        }
        return count;
    }
};