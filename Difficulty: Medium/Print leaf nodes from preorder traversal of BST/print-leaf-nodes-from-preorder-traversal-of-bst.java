class Solution {
    public ArrayList<Integer> leafNodes(int[] preorder) {
        ArrayList<Integer> result = new ArrayList<>();
        helper(preorder, 0, preorder.length - 1, result);
        return result;
    }

    private void helper(int[] preorder, int start, int end, ArrayList<Integer> result) {
        if (start > end) return;

        // If there is only one element, it is a leaf
        if (start == end) {
            result.add(preorder[start]);
            return;
        }

        int root = preorder[start];

        // Find index where right subtree starts
        int rightStart = start + 1;
        while (rightStart <= end && preorder[rightStart] < root) {
            rightStart++;
        }

        // Recur for left and right subtrees
        helper(preorder, start + 1, rightStart - 1, result);  // Left
        helper(preorder, rightStart, end, result);            // Right
    }
}
