class Solution {
    public int splitArray(int[] arr, int k) {
        int left = 0, right = 0;
        for (int num : arr) {
            left = Math.max(left, num); 
            right += num; 
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(arr, mid, k)) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        
        return left; 
    }
    
    private boolean canSplit(int[] arr, int maxSum, int k) {
        int currentSum = 0;
        int count = 1; 
        
        for (int num : arr) {
            currentSum += num;
            if (currentSum > maxSum) {
                count++;
                currentSum = num; 
                if (count > k) {
                    return false; 
                }
            }
        }
        return true;
    }
}