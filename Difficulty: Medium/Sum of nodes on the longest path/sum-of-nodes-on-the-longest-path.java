class Solution {
    class Result {
        int maxLen;
        int maxSum;
    }

    public int sumOfLongRootToLeafPath(Node root) {
        Result res = new Result();
        dfs(root, 0, 0, res);
        return res.maxSum;
    }

    private void dfs(Node node, int currLen, int currSum, Result res) {
        if (node == null) return;
        currSum += node.data;
        currLen += 1;
        if (node.left == null && node.right == null) {
            if (currLen > res.maxLen) {
                res.maxLen = currLen;
                res.maxSum = currSum;
            } else if (currLen == res.maxLen) {
                res.maxSum = Math.max(res.maxSum, currSum);
            }
        }
        dfs(node.left, currLen, currSum, res);
        dfs(node.right, currLen, currSum, res);
    }
}