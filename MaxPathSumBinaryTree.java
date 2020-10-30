class MaxPathSumBinaryTree{
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root); 
        return maxSum;
    }
    
    
    private int maxPath(TreeNode root){
         if(root==null) return 0; 
        int leftMax = Math.max(maxPath(root.left),0); 
        int rightMax = Math.max(maxPath(root.right),0); 
        maxSum = Math.max(maxSum, root.val + leftMax + rightMax); 
        return root.val + Math.max(leftMax,rightMax);
    }
}
