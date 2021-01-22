#include<iostream>
#include<unordered_map>
using namespace std;

bool kAnagrams(string s1,string s2,int k)
{
    if(s1.length()!=s2.length())
        return false;
    int ans=0;
    unordered_map<char,int> map1;
    unordered_map<char,int> map2;
    for(int i=0;i<s1.length();i++)
    {
        map1[s1[i]]++;
        map2[s2[i]]++;
    }
    for(auto c:map1)
    {
        if(c.second>map2[c.first])
            ans+=c.second-map2[c.first];
    }
    if(ans<=k)
        return true;
    return false;
}

int main(int args,char **argv)
{
    string s1="anagram";
    string s2="grammar";
    int k=14;
    cout<<kAnagrams(s1,s2,k);
    return 0;
}