class Solution {
public:
    unordered_map<char,char> par;
    unordered_map<char,int> rank;
    char find(char x)
    {
        if(par[x]==x)
            return x;
        char px=find(par[x]);
        par[x]=px;
        return px;
    }
    void merge(char x,char y)
    {
        char xl=find(x);
        char yl=find(y);
        if(xl!=yl)
        {
            if(rank[xl]<rank[yl])
                par[xl]=yl;
            else if(rank[yl]<rank[xl])
                par[yl]=xl;
            else
            {
                par[xl]=yl;
                rank[yl]++;
            }
        }
    }
    bool equationsPossible(vector<string>& equations) {
        for(int i=0;i<equations.size();i++)
        {
            if(equations[i][1]=='!')
                continue;
            char x=equations[i][0];
            char y=equations[i][3];
            if(par.count(x)==0)
            {
                par[x]=x;
                rank[x]=1;
            }
            if(par.count(y)==0)
            {
                par[y]=y;
                rank[y]=1;
            }
            merge(x,y);
        }
        for(int i=0;i<equations.size();i++)
        {
            if(equations[i][1]=='=')
                continue;
            char x=equations[i][0];
            char y=equations[i][3];
            if(par.count(x)==0)
            {
                par[x]=x;
                rank[x]=1;
            }
            if(par.count(y)==0)
            {
                par[y]=y;
                rank[y]=1;
            }
            char xl=find(x);
            char yl=find(y);
            if(xl==yl)
                return false;
        }
        return true;
    }
};