#include<iostream>
#include<vector>
#include<limits>
using namespace std;

class T
{
    public:
        float max_val;
        float min_val;
        string max_str;
        string min_str;
        T()
        {
            this->max_str="";
            this->min_str="";
            this->max_val=numeric_limits<float>::min();
            this->min_val=numeric_limits<float>::max();
        }
};

T* optimalDivision2_(int s,int e,vector<int>& nums,vector<vector<T*>>& strg)
{
    if(strg[s][e]!=nullptr)
        return strg[s][e];
    T* t=new T();
    if(s==e)
    {
        t->max_val=nums[s];
        t->min_val=nums[s];
        t->max_str=to_string(nums[s]);
        t->min_str=to_string(nums[s]);
        strg[s][e]=t;
        return t;
    }
    for(int i=s;i<e;i++)
    {
        T* left=optimalDivision2_(s,i,nums,strg);
        T* right=optimalDivision2_(i+1,e,nums,strg);
        T* temp=new T();
        temp->max_val=left->max_val/right->min_val;
        temp->min_val=left->min_val/right->max_val;
        temp->max_str=left->max_str+"/"+((i+1)!=e?"(":"")+right->min_str+((i+1)!=e?")":"");
        temp->min_str=left->min_str+"/"+((i+1)!=e?"(":"")+right->max_str+((i+1)!=e?")":"");
        if(t->max_val<temp->max_val)
        {
            t->max_val=temp->max_val;
            t->max_str=temp->max_str;
        }
        if(t->min_val>temp->min_val)
        {
            t->min_val=temp->min_val;
            t->min_str=temp->min_str;
        }
    }
    strg[s][e]=t;
    return t;
}

// O(n3)
// 8ms using memorization
// 512ms using recursion
string optimalDivision2(vector<int>& nums)
{
    vector<vector<T*>> strg(nums.size(),vector<T*>(nums.size(),nullptr));
    T* t=optimalDivision2_(0,nums.size()-1,nums,strg);
    return t->max_str;
}

// O(n)
// 4ms
string optimalDivision(vector<int>& nums) {
    string ans="";
    ans+=to_string(nums[0]);
    if(nums.size()==1)
        return ans;
    else if(nums.size()==2)
        return ans+"/"+to_string(nums[1]);
    else 
    {
        ans=ans+"/(";
        for(int i=1;i<nums.size();i++)
        {
            ans+=to_string(nums[i])+"/";
        }
        ans[ans.length()-1]=')';
    }
    return ans;
}

int main(int args,char** argv)
{
    vector<int> arr={1000,100,20,10,5};
    cout<<optimalDivision(arr)<<endl;
    cout<<optimalDivision2(arr)<<endl;
    return 0;
}