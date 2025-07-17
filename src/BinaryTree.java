public class BinaryTree<Tdata> {
    TreeNode<Tdata> Root;

    public void Insert(Tdata _data) {
        TreeNode<Tdata> newNode = new TreeNode<>(_data);

        if (this.Root == null) {
            this.Root = newNode;
            return;
        }

        Queue<TreeNode<Tdata>> q = new Queue<>();
        q.enqueue(this.Root);

        while (q.hasData()) {
            TreeNode<Tdata> currentNode = q.dequeue();

            if (currentNode.Left == null) {
                currentNode.Left = newNode;
                return;
            } else {
                q.enqueue(currentNode.Left);
            }

            if (currentNode.Right == null) {
                currentNode.Right = newNode;
                return;
            } else {
                q.enqueue(currentNode.Right);
            }
        }
    }


    public void printTree() {
        printTree(this.Root, "", true);
    }

    private void printTree(TreeNode<Tdata> node, String prefix, boolean isLeft) {
        if (node == null) return;

        System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.Data);

        boolean hasLeft = node.Left != null;
        boolean hasRight = node.Right != null;

        if (hasLeft || hasRight) {
            printTree(node.Left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.Right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }







    public static class TreeNode<Tdata>{
        public Tdata Data;
        public TreeNode<Tdata> Left;
        public TreeNode<Tdata> Right;

        public TreeNode(Tdata _data) {
            this.Data = _data;
        }
    }
}
