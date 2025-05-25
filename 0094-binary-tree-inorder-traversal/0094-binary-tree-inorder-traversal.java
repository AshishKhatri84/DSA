class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> re=new ArrayList<>();
        helper(root,re);
        return re;
    }
    public void helper(TreeNode root, List<Integer> re){
        if(root != null){
            helper(root.left,re);
            re.add(root.val);
            helper(root.right,re);
        }
    }
}