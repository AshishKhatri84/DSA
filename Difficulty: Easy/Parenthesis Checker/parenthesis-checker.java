import java.util.Stack;

class Solution {
    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // If closing bracket and stack is empty -> unbalanced
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // Check if the popped element matches the current closing bracket
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty at the end, it's balanced
        return stack.isEmpty();
    }
}
