class Solution {
    public int countConsec(int n) {
        if (n == 1) return 0; 
        if (n == 2) return 1; 

        int[] dp = new int[n + 1];
        dp[1] = 2; 
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        int totalBinaryStrings = (int) Math.pow(2, n);
        return totalBinaryStrings - dp[n];
    }
}