#include<iostream>
#include<unordered_map>
#include<vector>
using namespace std;


// TLE
vector<int> gridIllumination(int n, vector<vector<int>>& lamps, vector<vector<int>>& queries) {
    unordered_map<int,int> mrow;
    unordered_map<int,int> mcol;
    unordered_map<int,int> md45;
    unordered_map<int,int> md135;
    unordered_map<string,bool> grid;
    for(int i=0;i<lamps.size();i++)
    {
        int r=lamps[i][0];
        int c=lamps[i][1];
        string s=to_string(r)+","+to_string(c);
        grid[s]=true;
        mrow[r]++;
        mcol[c]++;
        md45[r+c]++;
        md135[r-c]++;
    }
    vector<int> res(queries.size(),0);
    vector<vector<int>> dir={
        {-1,0},
        {-1,1},
        {0,1},
        {1,1},
        {1,0},
        {1,-1},
        {0,-1},
        {-1,-1}
    };
    for(auto c:md45)
        cout<<c.first<<" -> "<<c.second<<endl;
    for(int i=0;i<queries.size();i++)
    {
        int r=queries[i][0];
        int c=queries[i][1];
        if(mrow[r]>=1 || mcol[c]>=1 || md45[r+c]>=1 || md135[r-c]>=1)
            res[i]=1;
        string s=to_string(r)+","+to_string(c);
        if(grid[s]==true)
        {
            mrow[r]--;
            mcol[c]--;
            md45[r+c]--;
            md135[r-c]--;
            grid[s]=false;
        }
        for(int d=0;d<dir.size();d++)
        {
            int nr=r+dir[d][0];
            int nc=c+dir[d][1];
            string s=to_string(nr)+","+to_string(nc);
            if(grid[s]==true)
            {
                mrow[nr]--;
                mcol[nc]--;
                md45[nr+nc]--;
                md135[nr-nc]--;
                grid[s]=false;
            }
        }
    }
    
    return res;
}

// 1428 ms
class Solution {
public:
    vector<int> gridIllumination(int n, vector<vector<int>>& lamps, vector<vector<int>>& queries) {
    unordered_map<int,int> mrow;
    unordered_map<int,int> mcol;
    unordered_map<int,int> md45;
    unordered_map<int,int> md135;
    map<pair<int,  int>,bool> grid;
    for(int i=0;i<lamps.size();i++)
    {
        int r=lamps[i][0];
        int c=lamps[i][1];
        grid[{r,c}]=true;
        mrow[r]++;
        mcol[c]++;
        md45[r+c]++;
        md135[r-c]++;
    }
    vector<int> res(queries.size(),0);
    vector<vector<int>> dir={
        {-1,0},
        {-1,1},
        {0,1},
        {1,1},
        {1,0},
        {1,-1},
        {0,-1},
        {-1,-1},
        {0,0}
    };
    for(int i=0;i<queries.size();i++)
    {
        int r=queries[i][0];
        int c=queries[i][1];
        if(mrow[r]>=1 || mcol[c]>=1 || md45[r+c]>=1 || md135[r-c]>=1)
            res[i]=1;
        for(int d=0;d<dir.size();d++)
        {
            int nr=r+dir[d][0];
            int nc=c+dir[d][1];
            if(grid[{nr,nc}]==true)
            {
                mrow[nr]--;
                mcol[nc]--;
                md45[nr+nc]--;
                md135[nr-nc]--;
                grid[{nr,nc}]=false;
            }
        }
    }
    
    return res;
}
};


// 1176 ms
class Solution {
public:
    vector<int> gridIllumination(int n, vector<vector<int>>& lamps, vector<vector<int>>& queries) {
    unordered_map<int,int> mrow;
    unordered_map<int,int> mcol;
    unordered_map<int,int> md45;
    unordered_map<int,int> md135;
    unordered_map<long long int,bool> grid;
    for(int i=0;i<lamps.size();i++)
    {
        int r=lamps[i][0];
        int c=lamps[i][1];
        long long int hash = (long long int)r*(long long int)101 + (long long int)c*(long long int)97;
        grid[hash]=true;
        mrow[r]++;
        mcol[c]++;
        md45[r+c]++;
        md135[r-c]++;
    }
    vector<int> res(queries.size(),0);
    vector<vector<int>> dir={
        {-1,0},
        {-1,1},
        {0,1},
        {1,1},
        {1,0},
        {1,-1},
        {0,-1},
        {-1,-1},
        {0,0}
    };
    for(int i=0;i<queries.size();i++)
    {
        int r=queries[i][0];
        int c=queries[i][1];
        if(mrow[r]>=1 || mcol[c]>=1 || md45[r+c]>=1 || md135[r-c]>=1)
            res[i]=1;
        for(int d=0;d<dir.size();d++)
        {
            int nr=r+dir[d][0];
            int nc=c+dir[d][1];
            long long int hash = (long long int)nr*(long long int)101 + (long long int)nc*(long long int)97;
            if(grid[hash]==true)
            {
                mrow[nr]--;
                mcol[nc]--;
                md45[nr+nc]--;
                md135[nr-nc]--;
                grid[hash]=false;
            }
        }
    }
    
    return res;
}
};

// also can use this as hashing ,by seeing 2d array as 1d
// m5.put(N*x + y, true);

class Solution {
public:
    vector<int> gridIllumination(int n, vector<vector<int>>& lamps, vector<vector<int>>& queries) {
    unordered_map<int,int> mrow;
    unordered_map<int,int> mcol;
    unordered_map<int,int> md45;
    unordered_map<int,int> md135;
    unordered_map<long long int,bool> grid;
    for(int i=0;i<lamps.size();i++)
    {
        int r=lamps[i][0];
        int c=lamps[i][1];
       // string s=to_string(r)+","+to_string(c);
        //  r1* +  c1*97 =  r2*101 + c2*97
        // (r1-r2)*101 = (c2-c1)*97
        // r1-r2==91017*2  r1 = 98  r2 = 1
        //  c2-c1 == (101)*2 = c2 = 102 c1 = 1
        
        long long int hash = (long long int)r*(long long int)(1e9+7) + (long long int)c*(long long int)97;
        grid[hash]=true;
        mrow[r]++;
        mcol[c]++;
        md45[r+c]++;
        md135[r-c]++;
    }
    vector<int> res(queries.size(),0);
    vector<vector<int>> dir={
        {-1,0},
        {-1,1},
        {0,1},
        {1,1},
        {1,0},
        {1,-1},
        {0,-1},
        {-1,-1},
        {0,0}
    };
    for(int i=0;i<queries.size();i++)
    {
        int r=queries[i][0];
        int c=queries[i][1];
        if(mrow[r]>=1 || mcol[c]>=1 || md45[r+c]>=1 || md135[r-c]>=1)
            res[i]=1;
        for(int d=0;d<dir.size();d++)
        {
            int nr=r+dir[d][0];
            int nc=c+dir[d][1];
          //  string s=to_string(nr)+","+to_string(nc);
             long long int hash = (long long int)nr*(long long int)(1e9+7) + (long long int)nc*(long long int)97;
            if(grid[hash]==true)
            {
                mrow[nr]--;
                mcol[nc]--;
                md45[nr+nc]--;
                md135[nr-nc]--;
                grid[hash]=false;
            }
        }
    }
    
    return res;
}
};

int main(int args,char** argv)
{
    int n=5;
    vector<vector<int>> lamps={
      {0,0},
      {0,4}  
    };
    vector<vector<int>> queries={
        {0,4},
        {0,1},
        {1,4}
    };
    vector<int> res=gridIllumination(n,lamps,queries);
    for(int i:res)
        cout<<i<<"  ";
    cout<<endl;
    return 0;
}