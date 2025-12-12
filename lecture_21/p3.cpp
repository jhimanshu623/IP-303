#include<iostream>
#include<vector>
#include<queue>
#include<limits>
using namespace std;

// 80ms
int maximumProduct(vector<int>& arr) {
    priority_queue<int> maxpq;
    priority_queue<int,vector<int>,greater<int>> minpq;
    maxpq.push(arr[0]);
    maxpq.push(arr[1]);
    minpq.push(arr[0]);
    minpq.push(arr[1]);
    minpq.push(arr[2]);
    for(int i=2;i<arr.size();i++)
    {
        if(maxpq.top()>arr[i])
        {
            maxpq.pop();
            maxpq.push(arr[i]);
        }
        if(i>=3)
        {
            if(minpq.top()<arr[i])
            {
                minpq.pop();
                minpq.push(arr[i]);
            }   
        }
    }
    int max3=minpq.top();minpq.pop();
    int max2=minpq.top();minpq.pop();
    int max1=minpq.top();minpq.pop();
    int min2=maxpq.top();maxpq.pop();
    int min1=maxpq.top();maxpq.pop();
    int ans=max(max1*max2*max3,min1*min2*max1);
    return ans;
}

// 92ms
int maximumProduct2(vector<int>& arr) {
    int min1=numeric_limits<int>::max();
    int min2=numeric_limits<int>::max();      
    int max1=numeric_limits<int>::min();   
    int max2=numeric_limits<int>::min();   
    int max3=numeric_limits<int>::min();   
    for(int i=0;i<arr.size();i++)
    {
        if(arr[i]<min1)
        {
            min2=min1;
            min1=arr[i];
        }
        else if(arr[i]<min2)
        {
            min2=arr[i];
        }
        if(arr[i]>max1)
        {
            max3=max2;
            max2=max1;
            max1=arr[i];
        }
        else if(arr[i]>max2)
        {
            max3=max2;
            max2=arr[i];
        }
        else if(arr[i]>max3)
            max3=arr[i];
    }
    int ans=max(max1*max2*max3,min1*min2*max1);
    return ans;
}
int main(int args,char** argv)
{
    vector<int> arr={9,1,5,6,7,2};
    cout<<maximumProduct(arr)<<endl;
    cout<<maximumProduct2(arr)<<endl;
    return 0;
}