import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree<Tdata extends Comparable<Tdata>> {
    TreeNode<Tdata> Root;


    public void Insert(Tdata _data) {
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









    public static class TreeNode<Tdata>{
        public Tdata Data;
        public BinarySearchTree.TreeNode<Tdata> Left;
        public BinarySearchTree.TreeNode<Tdata> Right;

        public TreeNode(Tdata _data) {
            this.Data = _data;
        }
    }
}
