class Solution {
    int smallestDivisor(int[] arr, int k) {
        int left = 1;
        int right = getMax(arr); 
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = getSum(arr, mid);
            
            if (sum <= k) {
                answer = mid;
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        return answer;
    }
    int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }
    int getSum(int[] arr, int divisor) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor; 
        }
        return sum;
    }
}