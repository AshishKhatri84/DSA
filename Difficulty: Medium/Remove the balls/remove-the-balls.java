class Solution {
    public int findLength(int[] color, int[] radius) {
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < color.length; i++) {
            int[] current = new int[]{color[i], radius[i]};

            if (!stack.isEmpty()) {
                int[] top = stack.peek();
                if (top[0] == current[0] && top[1] == current[1]) {
                    stack.pop(); 
                    continue;
                }
            }
            stack.push(current);
        }
        return stack.size(); 
    }
}