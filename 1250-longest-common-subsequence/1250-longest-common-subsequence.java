class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text1.length()];
        int size = 0;
        for(char ch : text2.toCharArray()){
            int cur = 0;
            for(int i = 0; i < dp.length; i++){
                if(cur < dp[i])
                    cur = dp[i];
                else if(ch == text1.charAt(i)){
                    dp[i] = cur + 1;
                    size = Math.max(size, cur + 1);
                }
            }
        }
        return size;
    }
}