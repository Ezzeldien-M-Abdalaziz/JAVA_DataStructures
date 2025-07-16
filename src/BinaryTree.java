public class BinaryTree<Tdata> {






    public static class TreeNode<Tdata>{
        public Tdata Data;
        public TreeNode Left;
        public TreeNode Right;

        public TreeNode(Tdata _data) {
            this.Data = _data;
        }
    }
}
