class Solution {
    public int kokoEat(int[] arr, int k) {
        int low = 1, high = 0;

        for (int pile : arr) {
            high = Math.max(high, pile);
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFinish(arr, k, mid)) {
                answer = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }
        return answer;
    }

    private boolean canFinish(int[] arr, int k, int s) {
        int hours = 0;
        for (int pile : arr) {
            hours += (pile + s - 1) / s; 
        }
        return hours <= k;
    }
}