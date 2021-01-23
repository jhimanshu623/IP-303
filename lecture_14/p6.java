int findLength(int arr[], int n)  
    { 
        int max_len = 1;  // Initialize result 
        for (int i = 0; i < n - 1; i++)  
        { 
            // Initialize min and max for all subarrays starting with i 
            int mn = arr[i], mx = arr[i]; 
  
            // Consider all subarrays starting with i and ending with j 
            for (int j = i + 1; j < n; j++)  
            { 
                // Update min and max in this subarray if needed 
                mn = min(mn, arr[j]); 
                mx = max(mx, arr[j]); 
  
                // If current subarray has all contiguous elements 
                if ((mx - mn) == j - i) 
                    max_len = max(max_len, mx - mn + 1); 
            } 
        } 
        return max_len;  // Return result 
    }