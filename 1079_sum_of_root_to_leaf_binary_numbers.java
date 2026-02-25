class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,0);
    }
    private int dfs(TreeNode node,int c){
        if(node==null){
            return 0;
        }
        c=c*2+node.val;
        if(node.left==null && node.right==null){
            return c;
        }
        return dfs(node.left,c)+dfs(node.right,c);
    }
}