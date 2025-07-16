public class BinaryTree<Tdata> {
    TreeNode<Tdata> Root;

    public void Insert(Tdata _data) {
        TreeNode<Tdata> newNode = new TreeNode(_data);
        if(this.Root == null) {
            this.Root = newNode;
        }

        Queue<TreeNode> q = new Queue();
        q.enqueue(this.Root);
        while(!q.isEmpty()) {

        }

    }





    public static class TreeNode<Tdata>{
        public Tdata Data;
        public TreeNode Left;
        public TreeNode Right;

        public TreeNode(Tdata _data) {
            this.Data = _data;
        }
    }
}
