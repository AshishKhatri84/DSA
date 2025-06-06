class Solution {
    public boolean isPalindrome(String s) {
        int l = s.length();
        s = s.toLowerCase();
        String original = "", reverse = "";
        for (int i = 0; i < l; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))==true) {
                original = original + s.charAt(i);
                reverse = s.charAt(i) + reverse;
            }

        }
        return original.equals(reverse);
    }
}