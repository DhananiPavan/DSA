class Solution {
    public int[] searchRange(int[] nums, int target) {
    int fst=first(nums,target);
    if(  fst==nums.length || nums[fst] != target ){
        int[] a={-1,-1};
        return a;
    }
    int lst=last(nums,target);
    int[] a={fst,lst};
    return a; 
    
        
    }

 int first(int [] arr, int x) {
        int n = arr.length; // size of the array
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
    int last(int [] arr, int x) {
        int n = arr.length; // size of the array
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }
        return ans-1;
    }
}