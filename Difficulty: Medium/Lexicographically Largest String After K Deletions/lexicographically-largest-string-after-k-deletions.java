class Solution {
    public static String maxSubseq(String s, int k) {
        int n = s.length();
        int keep = n - k; 
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            while (stack.length() > 0 && 
                   stack.charAt(stack.length() - 1) < c && 
                   k > 0 && 
                   (stack.length() - 1 + (n - i)) >= keep) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }
        return stack.substring(0, keep);
    }
}