import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree<Tdata extends Comparable<Tdata>> {
    TreeNode<Tdata> Root;

    public Boolean isExist(Tdata val) {
       return this.find(val) != null;
    }


    public void insert(Tdata _data) {
        TreeNode<Tdata> newNode = new TreeNode<>(_data);
        if (this.Root == null) {
            this.Root = newNode;
            return;
        }
        TreeNode<Tdata> currentNode = this.Root;

        while (currentNode != null) {
            if(_data.compareTo(currentNode.Data) < 0){    //if the new node's data < current node's data then insert to the left of the node
                // new data is less → go left
                if(currentNode.Left == null){
                    currentNode.Left = newNode;
                    break;
                }else{
                    currentNode = currentNode.Left;
                }
            }else{  //if the new node's data > current node's data then insert to the right of the node
                if(currentNode.Right == null){
                    // new data is greater or equal → go right
                    currentNode.Right = newNode;
                    break;
                }else{
                    currentNode = currentNode.Right;
                }
            }
        }

    }


    private Tdata find(Tdata _data) {
        if (this.Root == null) return null;

        TreeNode<Tdata> currentNode = this.Root;
        while (currentNode != null) {
            int cmp = _data.compareTo(currentNode.Data);
            if (cmp == 0) {
                return currentNode.Data; // found
            }
            if (cmp < 0) {
                currentNode = currentNode.Left;  // go left
            } else {
                currentNode = currentNode.Right; // go right
            }
        }
        return null; // not found
    }


    public NodeAndParent<Tdata> FindNodeAndParent(Tdata _data) {
        TreeNode<Tdata> currentNode = this.Root;
        TreeNode<Tdata> parent = null;
        boolean isLeft = false;

        while (currentNode != null) {
            int cmp = _data.compareTo(currentNode.Data);
            if (cmp == 0) {
                NodeAndParent<Tdata> result = new NodeAndParent<>();
                result.Node = currentNode;
                result.Parent = parent;
                result.IsLeft = isLeft;
                return result; // found
            }
            parent = currentNode;
            if (cmp < 0) {
                isLeft = true;
                currentNode = currentNode.Left;  // go left
            } else {
                isLeft = false;
                currentNode = currentNode.Right; // go right
            }
        }

        return null; // not found
    }


    //begin delete functions
    public void delete(Tdata _data) {
        NodeAndParent<Tdata> nodeAndParentInfo = this.FindNodeAndParent(_data);
        if(nodeAndParentInfo == null) return;

        if(nodeAndParentInfo.Node.Left != null && nodeAndParentInfo.Node.Right != null){
            delete_Has_Childs(nodeAndParentInfo.Node);
        } else if (nodeAndParentInfo.Node.Left != null ^ nodeAndParentInfo.Node.Right != null) {   // ^ = XOR
            delete_has_one_child(nodeAndParentInfo.Node);
        }else{
            delete_leaf(nodeAndParentInfo);
        }
    }


    public void delete_Has_Childs(TreeNode<Tdata> nodeToDelete)  {
        TreeNode<Tdata> currentNode = nodeToDelete.Right;
        TreeNode<Tdata> parent = null;   //the smallest side's parent

        while(currentNode.Left != null){
            parent = currentNode;
            currentNode = currentNode.Left;
        }

        if(parent != null){
            parent.Left = currentNode.Right;
        }
        else{
            nodeToDelete.Right = currentNode.Right;
        }
        nodeToDelete.Data = currentNode.Data;
    }


    public void delete_has_one_child(TreeNode<Tdata> nodeToDelete) {
        TreeNode<Tdata> nodeToReplace = null;
        if(nodeToDelete.Left != null){
            nodeToReplace = nodeToDelete.Left;
        }else{
            nodeToReplace = nodeToDelete.Right;
        }
        nodeToDelete.Data = nodeToReplace.Data;
        nodeToDelete.Left = nodeToReplace.Left;
        nodeToDelete.Right = nodeToReplace.Right;
    }


    public void delete_leaf(NodeAndParent<Tdata> nodeAndParentInfo) {
        if(nodeAndParentInfo.Parent == null){
            this.Root = null;
        }else{
            if(nodeAndParentInfo.IsLeft){
                nodeAndParentInfo.Parent.Left = null;
            }else {
                nodeAndParentInfo.Parent.Right = null;
            }
        }
    }

    //end delete




    //balance function
    public void balance(){
        List<Tdata> nodes = new ArrayList<>();
        InOrderToArray(this.Root, nodes);
        this.Root = recursiveBalance(0 , nodes.size() - 1 , nodes);
    }

    void InOrderToArray(TreeNode<Tdata> node , List<Tdata> nodes){
        if(node == null){
            return;
        }
        InOrderToArray(node.Left, nodes);
        nodes.add(node.Data);
        InOrderToArray(node.Right, nodes);
    }


    public TreeNode<Tdata> recursiveBalance(int start , int end , List<Tdata> nodes){
        if(start > end) return null;

        int mid = (start + end)/2;
        TreeNode<Tdata> newNode = new TreeNode<>(nodes.get(mid));
        newNode.Left = recursiveBalance(start , mid - 1 , nodes);
        newNode.Right = recursiveBalance(mid + 1 , end , nodes);
        return newNode;
    }
    //end balance



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




    public static class TreeNode<Tdata>{
        public Tdata Data;
        public BinarySearchTree.TreeNode<Tdata> Left;
        public BinarySearchTree.TreeNode<Tdata> Right;

        public TreeNode(Tdata _data) {
            this.Data = _data;
        }
    }

    public static class NodeAndParent<Tdata>{
        public TreeNode<Tdata> Node;
        public TreeNode<Tdata> Parent;
        public boolean IsLeft;
    }
}
