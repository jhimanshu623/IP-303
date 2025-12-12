class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        if(nums1.size()>nums2.size())
        {
            vector<int> temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int n1=nums1.size();
        int n2=nums2.size();
        int i1=0;
        int j1=n1;
        // int gl=ceil((n1+n2)/2.0);
        int gl=(n1+n2+1)/2;
        double ans=0.0;
        while(i1<=j1)
        {
            int mid1=(i1+j1)/2;
            int mid2=gl-mid1;
            if(mid2-1>=0 && mid1<n1 && nums2[mid2-1] > nums1[mid1])
                i1=mid1+1;
            else if(mid1-1>=0 && mid2<n2 && nums1[mid1-1] > nums2[mid2])
                j1=mid1-1;
            else
            {
                int m1=0;
                int m2=0;
                if(mid1-1>=0 && mid2-1>=0)
                    m1=max(nums1[mid1-1],nums2[mid2-1]);
                else if(mid1-1>=0)
                    m1=nums1[mid1-1];
                else if(mid2-1>=0)
                    m1=nums2[mid2-1];
                
                if(mid1<n1 && mid2<n2)
                    m2=min(nums1[mid1],nums2[mid2]);
                else if(mid1<n1)
                    m2=nums1[mid1];
                else if(mid2<n2)
                    m2=nums2[mid2];
                
                if((n1+n2)%2 == 0)
                    ans=(m1+m2)/2.0;
                else
                    ans=m1;
                return ans;
            }
        }
        return 0;   
    }
};