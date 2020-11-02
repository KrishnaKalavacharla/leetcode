class ConstructTreePreOrderInorder{
    
    Map<Integer,Integer> inOrderMap = new HashMap();
    int preIndex = 0;
    TreeNode result;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length==0) return null;

        for(int i = 0; i<inorder.length; i++){
            inOrderMap.put(inorder[i],i);
        }



        return buildTree(0,preorder.length,preorder);
    }

    private TreeNode buildTree(int left, int right,int[] preorder){
        if(preIndex>=preorder.length) return null;
        if(left==right) return null;


        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        int inOrderIndex = inOrderMap.get(root.val);
        root.left = buildTree(left,inOrderIndex,preorder);
        root.right = buildTree(inOrderIndex+1,right,preorder);

        return root;
    }

}
