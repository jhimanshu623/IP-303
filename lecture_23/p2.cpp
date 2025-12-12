#include<iostream>
#include<vector>

using namespace std;

string multiply(string num1, string num2) {
    vector<int> ans(num1.length()+num2.length(),0);
    for(int j=num2.length()-1;j>=0;j--)
    {
        for(int i=num1.length()-1;i>=0;i--)
        {
            int idx1=i+j;
            int idx2=i+j+1;
            int p=(num2[j]-'0') * (num1[i]-'0') + ans[idx2];
            ans[idx2]=p%10;
            ans[idx1]+=p/10;
        }
    }
    string res="";
    int i=0;
    while(i<ans.size() && ans[i]==0)
        i++;
    while(i<ans.size()){
        res+=to_string(ans[i]);
        i++;
    }
    if(res=="")
        return "0";
    return res;
}

int main(int args,char** argv)
{
    string num1="123";
    string num2="45";
    cout<<multiply(num1,num2);
    return 0;
}