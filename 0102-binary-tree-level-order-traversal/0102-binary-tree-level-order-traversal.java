class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if( root == null )
            return ans;
        func( root , 1 , ans );
        return ans;
    }

    private void func( TreeNode root , int level , List<List<Integer>> ans )
    {
        if( root == null ) return;
        if( level > ans.size() )
            {
                List<Integer> level_values = new ArrayList<>();
                ans.add(level_values);
            }
        ans.get(level-1).add(root.val);
        func( root.left , level + 1 , ans );
        func( root.right ,  level+1 , ans );
    }
}