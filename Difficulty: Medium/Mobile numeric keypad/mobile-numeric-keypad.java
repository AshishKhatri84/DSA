class Solution {
    public int getCount(int n) {
        int[][] moves = {
            {0, 8},       
            {1, 2, 4},    
            {2, 1, 3, 5}, 
            {3, 2, 6},    
            {4, 1, 5, 7}, 
            {5, 2, 4, 6, 8},
            {6, 3, 5, 9},  
            {7, 4, 8},     
            {8, 5, 7, 0, 9},
            {9, 6, 8}      
        };
        
        int[][] dp = new int[n + 1][10];
        
        for (int j = 0; j < 10; j++) {
            dp[1][j] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int move : moves[j]) {
                    dp[i][j] += dp[i - 1][move];
                }
            }
        }
        
        int totalCount = 0;
        for (int j = 0; j < 10; j++) {
            totalCount += dp[n][j];
        }
        return totalCount;
    }
}