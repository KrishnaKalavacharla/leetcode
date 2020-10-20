class BinaryTreePaths{
    List<String> result = new ArrayList();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null) return result;

        prepPaths(root,"");

        return result;
    }


    private void prepPaths(TreeNode root, String s){
        if(root==null) return;

        s = s.concat(String.valueOf(root.val));
        if(root.left==null && root.right==null){

            result.add(s);
        }else{
            s = s.concat("->");
        }

        prepPaths(root.left,s);
        prepPaths(root.right,s);

    }
}
