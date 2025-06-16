class Solution {
    public int minCost(int[] heights, int[] cost) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int h : heights) {
            low = Math.min(low, h);
            high = Math.max(high, h);
        }

        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            int cost1 = getTotalCost(heights, cost, mid1);
            int cost2 = getTotalCost(heights, cost, mid2);

            ans = Math.min(ans, Math.min(cost1, cost2));

            if (cost1 < cost2) {
                high = mid2 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return ans;
    }

    private int getTotalCost(int[] heights, int[] cost, int targetHeight) {
        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += Math.abs(heights[i] - targetHeight) * cost[i];
        }
        return total;
    }
}
