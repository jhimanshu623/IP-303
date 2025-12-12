#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;

vector<int> partitionLabels(string s) {
    vector<int> res;
    int map[26];
    for(int i=0;i<s.length();i++)
    {
        char c=s[i];
        map[c-'a']=i;
    }
    int j=0;
    int end=-1;
    for(int i=0;i<s.length();i++)
    {
        char c=s[i];
        end=max(end,map[c-'a']);
        if(i==end){
            res.push_back(i-j+1);
            j=i+1;
        }
    }
    return res;
}

int main(int args,char** argv)
{
    string s="ababcbacadefegdehijhklij";
    vector<int> res=partitionLabels(s);
    for(int i:res)
        cout<<i<<" ";
    cout<<endl;
    return 0;
}