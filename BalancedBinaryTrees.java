class BalancedBinaryTrees{

    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight-height)>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }

    private int height(TreeNode root){
        if(root==null) return 0;
        return Math.max(height(root.left,root.right)) + 1;
    }




}
