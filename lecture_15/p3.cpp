#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;

string simpleFraction(int n,int k)
{
    if(n%k==0)
        return to_string(n/k);
    string ans=to_string(n/k)+".";
    string str="";
    int rem=n%k;
    unordered_map<int,int> map;
    while(rem!=0)
    {
        if(map.count(rem)!=0)
        {
           str=str.substr(0,map[rem])+"("+str.substr(map[rem])+")";
           return ans+str; 
        }
        map[rem]=str.length();
        str+=to_string((rem*10)/k);
        rem=(rem*10)%k;
    }
    return ans+str;
}

int main(int args,char** argv)
{
    int n=11;
    int k=6;
    cout<<simpleFraction(n,k);
    return 0;
}