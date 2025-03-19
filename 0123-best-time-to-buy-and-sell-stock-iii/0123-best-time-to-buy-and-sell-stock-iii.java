class Solution {
    public int maxProfit(int[] prices) {
        int[] buy = new int[3];
        int[] sell = new int[3];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for(int p : prices) {
            for(int i = 1; i <= 2; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - p);
                sell[i] = Math.max(sell[i], buy[i] + p);
            }
        }
        return sell[2];
    }
}