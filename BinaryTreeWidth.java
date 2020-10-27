class BinaryTreeWidth{
    Queue<Pair<Integer,TreeNode>> queue;
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        if(root==null) return maxWidth;

        if(root.left == null && root.right == null) return maxWidth+1;

        queue = new LinkedList();
        queue.add(new Pair(1,root));

        while(!queue.isEmpty()){
            int size = queue.size();
            int leftMost = queue.peek().getKey();
            int rightMost = 0;

            for(int i = 0; i<size; i++){
                Pair<Integer,TreeNode> currentPair = queue.poll();
                rightMost = currentPair.getKey();

                TreeNode current = currentPair.getValue();
                if(current.left!=null) {
                    int leftid = rightMost*2;
                    queue.add(new Pair(leftid,current.left));
                }
                if(current.right!=null){
                    int rightId = 1+(rightMost*2);
                     queue.add(new Pair(rightId,current.right));
                }

            }

            maxWidth = Math.max(maxWidth,1+rightMost-leftMost);

        }

        return maxWidth;
    }
}
