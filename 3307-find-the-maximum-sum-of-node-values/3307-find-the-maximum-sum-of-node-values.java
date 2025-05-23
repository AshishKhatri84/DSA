class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        int[] netChange = new int[n];
        long nodeSum = 0;

        for (int i = 0; i < n; i++) {
            netChange[i] = (nums[i] ^ k) - nums[i];
            nodeSum += nums[i];
        }
        
        Arrays.sort(netChange);
        for (int i = 0; i < n / 2; i++) {
            int temp = netChange[i];
            netChange[i] = netChange[n - 1 - i];
            netChange[n - 1 - i] = temp;
        }

        for (int i = 0; i < n; i += 2) {
            if (i + 1 == n) {
                break;
            }
            long pairSum = netChange[i] + netChange[i + 1];
            if (pairSum > 0) {
                nodeSum += pairSum;
            }
        }
        return nodeSum;
    }
}