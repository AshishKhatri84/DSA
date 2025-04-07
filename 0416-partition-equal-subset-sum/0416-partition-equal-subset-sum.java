class Solution {
    public boolean findSubset(Boolean[] dp, int[] nums, int start, int subsetSum){
        if(subsetSum < 0) return false;
        if(subsetSum == 0) return true;
        if(start == 0) return subsetSum == nums[0];

        if(dp[subsetSum] != null) return dp[subsetSum];

        dp[subsetSum] = (findSubset(dp, nums, start - 1, subsetSum - nums[start]) || findSubset(dp, nums, start - 1, subsetSum));
        return dp[subsetSum];
    }
    public boolean canPartition(int[] nums) {
        int total = 0;
        int n = nums.length;
        for(int i = 0; i < n; ++i){
            total += nums[i];
        }
        if(total % 2 == 1) return false;

        int subsetSum = total / 2;
        Boolean[] dp = new Boolean[subsetSum + 1];
        return findSubset(dp, nums, n - 1, subsetSum);
    }
}