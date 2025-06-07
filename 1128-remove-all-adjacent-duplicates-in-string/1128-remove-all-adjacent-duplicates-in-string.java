class Solution {
    public String removeDuplicates(String chars) {
        if (chars.length() == 1) return chars;
        Stack<Character> s = new Stack<>();
        for (char ch : chars.toCharArray()) {
            if (s.isEmpty() || s.peek() != ch) {
                s.push(ch);
            } else {
                s.pop();
            }
           
        }
        String res = "";
        while (!s.isEmpty()) {
            res = s.pop() + res;
        }
        return res;
    }
}