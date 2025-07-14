class Solution {
    public int cuts(String s) {
        Set<String> powerOf5Set = new HashSet<>();
        long power = 1;
        while (true) {
            String binary = Long.toBinaryString(power);
            if (binary.length() > s.length()) break;
            powerOf5Set.add(binary);
            power *= 5;
        }
        
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = n + 1;
        }
        dp[0] = 0; 
        
        for (int i = 1; i <= n; i++) {
            for (String binary : powerOf5Set) {
                int len = binary.length();
                if (i >= len && s.substring(i - len, i).equals(binary)) {
                    if (len == 1 || s.charAt(i - len) != '0') {
                        dp[i] = Math.min(dp[i], dp[i - len] + 1);
                    }
                }
            }
        }
        
        return dp[n] > n ? -1 : dp[n];
    }
}