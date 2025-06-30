class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        for (int height : arr) {
            left = Math.min(left, height);
            right = Math.max(right, height);
        }
        right += k;
        
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(arr, k, w, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int[] arr, int k, int w, int target) {
        int[] temp = arr.clone();
        int days = 0;
        
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < target) {
                int needed = target - temp[i];
                for (int j = i; j < temp.length && j < i + w; j++) {
                    temp[j] += needed;
                }
                days += needed;
                if (days > k) {
                    return false;
                }
            }
        }
        return true;
    }
}