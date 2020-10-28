class KDistanceNodes{

    List<Integer> result = new ArrayList();
    Map<TreeNode,List<TreeNode>> graph = new HashMap();
    Set<TreeNode> visited = new HashSet();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        prepGraph(root,null);
        if(!graph.containsKey(target)) return result;

        Queue<TreeNode> queue = new LinkedList();

        queue.add(target);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size; i++){
                TreeNode current = queue.poll();
                if(K==0) result.add(current.val);
                visited.add(current);

                List<TreeNode> neighbors = graph.get(current);
                for(TreeNode n: neighbors){
                    if(!visited.contains(n)) queue.add(n);
                }


            }

            K--;
        }

        return result;

    }

    private void prepGraph(TreeNode node,TreeNode parent){

        List<TreeNode> currentList;
        if(graph.containsKey(node)){
            currentList = graph.get(node);
        }else{
            currentList = new ArrayList();
        }

        if(parent!=null) currentList.add(parent);
        if(node.left!=null) currentList.add(node.left);
        if(node.right!=null) currentList.add(node.right);
        graph.put(node,currentList);

        if(node.left!=null) prepGraph(node.left,node);
        if(node.right!=null) prepGraph(node.right,node);

    }


}
