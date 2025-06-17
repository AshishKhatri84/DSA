class Solution {
    public int minimumCoins(int[] arr, int k) {
        int maxValue = 10000;
        int[] freq = new int[maxValue + 1];

        for (int coin : arr) {
            freq[coin]++;
        }

        long[] coinPrefixSum = new long[maxValue + 2];
        long[] countPrefixSum = new long[maxValue + 2];

        for (int i = 1; i <= maxValue; i++) {
            coinPrefixSum[i] = coinPrefixSum[i - 1] + (long) i * freq[i];
            countPrefixSum[i] = countPrefixSum[i - 1] + freq[i];
        }

        long totalCoins = coinPrefixSum[maxValue];

        long minRemoved = Long.MAX_VALUE;

        for (int x = 0; x <= maxValue; x++) {
            int upper = x + k;
            if (upper > maxValue) upper = maxValue;

            long removedLeft = coinPrefixSum[x - 1 >= 0 ? x - 1 : 0];

            long totalRightCoins = coinPrefixSum[maxValue] - coinPrefixSum[upper];
            long rightPileCount = countPrefixSum[maxValue] - countPrefixSum[upper];
            long keptRight = rightPileCount * (long) (x + k);
            long removedRight = totalRightCoins - keptRight;

            long totalRemoved = removedLeft + removedRight;
            minRemoved = Math.min(minRemoved, totalRemoved);
        }
        return (int) minRemoved;
    }
}