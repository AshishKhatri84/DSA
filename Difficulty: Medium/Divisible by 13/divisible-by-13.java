class Solution {
    public boolean divby13(String s) {
        long remainder = 0;
        
        for (int i = 0; i < s.length(); i++) {
            remainder = (remainder * 10 + (s.charAt(i) - '0')) % 13;
        }
        
        return remainder == 0;
    }
}