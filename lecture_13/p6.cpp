#include<iostream>
#include<unordered_map>
#include<unordered_set>
using namespace std;

bool solve(string s)
{
    unordered_map<char,int> map;
    for(char ch:s)
        map[ch]++;
    vector<int> f;
    for(auto c:map)
    {
        if(f.size()<3){
            f.push_back(c.second);
            map.erase(c.first);
        }
        else
            break;
    }
    if(f.size()<=1)
        return true;
    else if(f.size()==2)
    {
        if(f[0]==1 || f[1]==1 || abs(f[0]-f[1])<=1)
            return  true;
    }
    else
    {
        int f1;
        int f2;
        if(f[0]==f[1] && f[0]==f[2])
            return true;
        else if(f[0]!=f[1] && f[1]!=f[2])
            return false
        else if(f[0]==f[1])
        {
            f1=f[0];
            f2=f[2];
        }
        else if(f[0]==f[2])
        {
            f1=f[0];
            f2=f[1];
        }
        else if(f[1]==f[2])
        {
            f1=f[1];
            f2=f[0];
        }
        for(auto c:map)
        {
            if(c.second!=f1)
                return false;
        }
        if(f2==1 || abs(f1-f2)==1)
            return true;
        return false;
    }
}

int main(int args,char **argv)
{
    string s="keqykmunl";
    cout<<solve(s)<<endl;
    return 0;
}