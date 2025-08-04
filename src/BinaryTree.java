import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree<Tdata> {
    TreeNode<Tdata> Root;

    //insert
    public void Insert(Tdata _data) {
        TreeNode<Tdata> newNode = new TreeNode<>(_data);

        if (this.Root == null) {
            this.Root = newNode;
            return;
        }

        Queue<TreeNode<Tdata>> q = new Queue<>();
        q.enqueue(this.Root);

        // this loop will keep going till it finds free space in the tree.
        while (q.hasData()) {   //walk through the whole tree till we find null
            TreeNode<Tdata> currentNode = q.dequeue();   //current node == this.root

            //this keeps adding nodes to the queue til it finds a free place

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

    //chatgpt print pretty methods
    public void printTree() {
        int maxLevel = height();
        printNodeInternal(Collections.singletonList(this.Root), 1, maxLevel);
    }

    private void printNodeInternal(List<TreeNode<Tdata>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printSpaces(firstSpaces);

        List<TreeNode<Tdata>> newNodes = new ArrayList<>();
        for (TreeNode<Tdata> node : nodes) {
            if (node != null) {
                System.out.print(node.Data);
                newNodes.add(node.Left);
                newNodes.add(node.Right);
            } else {
                System.out.print(" ");
                newNodes.add(null);
                newNodes.add(null);
            }

            printSpaces(betweenSpaces);
        }
        System.out.println();

        // Draw connectors
        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printSpaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printSpaces(edgeLines * 2 + i + 1);
                    continue;
                }

                if (nodes.get(j).Left != null)
                    System.out.print("/");
                else
                    System.out.print(" ");

                printSpaces(i * 2 - 1);

                if (nodes.get(j).Right != null)
                    System.out.print("\\");
                else
                    System.out.print(" ");

                printSpaces(edgeLines * 2 - i);
            }

            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private boolean isAllElementsNull(List<TreeNode<Tdata>> list) {
        for (TreeNode<Tdata> node : list) {
            if (node != null) return false;
        }
        return true;
    }
    //end of print pretty methods



    //height
    public int height() {
        return this.internalHeight(this.Root);
    }

    // recursion to get the max height of the node
    private int internalHeight(TreeNode<Tdata> node){
        if (node == null) return -1;
        return 1 + Math.max(internalHeight(node.Left), internalHeight(node.Right));
    }
    //end height


    //preOrderTraversal   "*Depth-First*"
    public void preOrderTraversal(){
        internalPreOrderTraversal(this.Root);
        System.out.println();
    }

    public void internalPreOrderTraversal(TreeNode<Tdata> node){
        if (node == null) return;
        System.out.print(node.Data + " -> ");
        internalPreOrderTraversal(node.Left);
        internalPreOrderTraversal(node.Right);
    }
    //end preOrderTraversal


    //inOrderTraversal   "*Depth-First*"
    public void inOrderTraversal(){
        internalInOrderTraversal(this.Root);
        System.out.println();
    }

    public void internalInOrderTraversal(TreeNode<Tdata> node){
        if (node == null) return;
        internalInOrderTraversal(node.Left);
        System.out.print(node.Data + " -> ");
        internalInOrderTraversal(node.Right);
    }
    //end inOrderTraversal


    //postOrderTraversal   "*Depth-First*"
    public void postOrderTraversal(){
        internalPostOrderTraversal(this.Root);
        System.out.println();
    }

    public void internalPostOrderTraversal(TreeNode<Tdata> node){
        if (node == null) return;
        internalPostOrderTraversal(node.Left);
        internalPostOrderTraversal(node.Right);
        System.out.print(node.Data + " -> ");
    }
    //end postOrderTraversal


    //get most-right last node
    public void getLastNode(TreeNode<Tdata> node){
        if (node == null) return;
        if (node.Right == null) {
            System.out.println("Last (rightmost) node: " + node.Data);
            return;
        }
        getLastNode(node.Right);
    }






    //delete
    //replace the deleted node with the right-most node in the tree
//    public void deleteNode(TreeNode<Tdata> node){
//        if (node == null) return;
//        //get the last node
//        TreeNode<Tdata> lastNode =
//    }





    public static class TreeNode<Tdata>{
        public Tdata Data;
        public TreeNode<Tdata> Left;
        public TreeNode<Tdata> Right;

        public TreeNode(Tdata _data) {
            this.Data = _data;
        }
    }
}
