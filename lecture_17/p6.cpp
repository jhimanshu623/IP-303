#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

string orderlyQueue(string str, int k) {
    if(k>=2){
        sort(str.begin(),str.end());
        return str;
    }
    string ans=str;
    string temp=str.substr(1)+string(1,str[0]);
    while(temp!=str)
    {
        if(temp.compare(ans)<0)
            ans=temp;
        temp=temp.substr(1)+string(1,temp[0]);
    }
    return ans;
}

int main(int args,char** argv)
{
    cout<<orderlyQueue("nhtq",1);
    return 0;
}