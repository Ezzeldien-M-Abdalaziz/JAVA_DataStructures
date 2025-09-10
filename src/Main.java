import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //**********************************************Array********************************************
        /*
        Array arr = new Array(6);
        arr.append(1);
        arr.append(2);
        arr.append(5);
//        arr.traverse();
        System.out.println(arr.search(3));
        System.out.println(arr.search(1));
        arr.append(2);
        arr.append(2);
//        arr.traverse();
        System.out.println(arr.getCount());
        arr.insert(2,20);
//        arr.traverse();
        arr.remove(0);
        arr.remove(1);
        arr.remove(2);
        arr.remove(3);
        arr.traverse();
*/
        //**********************************************LinkedList********************************************
//        LinkedList list = new LinkedList();
//        list.insertLast(10);
//        list.insertLast(20);
//        list.insertLast(30);
//        System.out.println(list.head.data);  //first
//        System.out.println(list.tail.data);  //last
//        list.printList();  // Output: 10 -> 20 -> 30 -> null
//
//        LinkedListNode node1 = list.find(30);
//        list.insertAfter(40, node1);
//
//        LinkedListNode node2 = list.find(40);
//        list.insertAfter(50, node2);
//
//        list.insertAfter(60 , list.tail);
//        list.insertAfter(70 , list.tail);
//        list.printList();
//        System.out.println(list.tail.data);
//
//        System.out.println(list.count());
//        System.out.println(list.findByIndex(0));
//
//        list.insertAfterEnhanced(80 , 6);
//        list.insertAfter(5 , list.head);
//
//        list.printList();
//
//        list.insertBefore(1,0);
//        list.insertBefore(-1,0);
//        list.printList();
//
//        list.insertBefore(200,10);
//        list.printList();
//
//        list.insertBefore(144,4);
//        list.printList();
//
//        list.deleteNode(1);
//        System.out.print('w');  list.deleteNode(4);
//        list.printList();
//
//        list.deleteNode(0);
//        list.printList();
//
//        list.deleteNode(list.count()-1);
//        list.printList();
//
//        LinkedList list2 = new LinkedList();
//        list2.insertLast(10);
//        list2.printList();
//        System.out.println(list2.head.data);
//        System.out.println(list2.tail.data);
//        list2.deleteNode(0);
//        list2.printList();
//
//        LinkedList list3 = new LinkedList();
//        list3.insertLast(10);
//        list3.insertLast(11);
//        list3.insertLast(12);
//        list3.insertLast(13);
//        list3.printList();
//        System.out.println(list3.length);
//        list3.deleteNode(0);
//        list3.deleteNode(0);
//        list3.deleteNode(0);
//        list3.deleteNode(0);
//        list3.printList();
//        System.out.println(list3.length);


        //**********************************************Doubly LinkedList********************************************

//        DoublyLinkedList list = new DoublyLinkedList();
//        list.insertLast(1);
//        list.insertLast(2);
//        list.insertLast(3);
//        System.out.println(list.head.data);
//        System.out.println(list.tail.data);
//        System.out.println(list.tail.back.data);
//        System.out.println(list.head.next.data);
//        System.out.println(list.count());
//        list.printList();
//        System.out.println(list.findByIndex(0));
//        System.out.println(list.findByIndex(1).data);
//        System.out.println(list.findByData(3));
//        System.out.println(list.count());
//        list.deleteNode(2);
//        list.deleteNode(1);
//        list.deleteNode(0);
//        list.printList();
//
//        list.insertBefore(4,1);
//        list.insertBefore(3,0);
//        list.insertBefore(2,0);
//        list.insertBefore(1,0);
//        list.insertBefore(0,0);
//
//        list.insertBefore(-1,2);
//
//        list.printList();

        //********************************************** linked list based Stack ********************************************

    //            Stack stack = new Stack();
    //            stack.push(1);
    //            stack.push(2);
    //            stack.push(3);
    //            stack.push(4);
    //            System.out.println(stack.size());
    //            System.out.println(stack.peek());
    //            stack.print();
    //            stack.pop();
    //            stack.pop();
    //            stack.print();
    //            System.out.println(stack.isEmpty());
    //            stack.pop();
    //            stack.pop();
    //            stack.print();
    //            System.out.println(stack.isEmpty());
    //            System.out.println(stack.size());

        //********************************************** array based Stack ********************************************

    //        ArrayBased_Stack arrayStack = new ArrayBased_Stack();
    //        System.out.println(arrayStack.isEmpty());
    //        arrayStack.push(1);
    //        arrayStack.push(2);
    //        arrayStack.push(3);
    //        arrayStack.push(4);
    //        arrayStack.push(5);
    //        System.out.println(arrayStack.isEmpty());
    //        System.out.println(arrayStack.size());
    //        System.out.println(arrayStack.peek());
    //        arrayStack.print();
    //        arrayStack.pop();
    //        arrayStack.pop();
    //        arrayStack.print();
    //        arrayStack.push(6);
    //        arrayStack.push(6);
    //        arrayStack.push(6);
    //        arrayStack.print();

    //********************************************** Queue ********************************************

//        Queue queue = new Queue();
//        queue.enqueue(8);
//        queue.enqueue(16);
//        queue.enqueue(32);
//        queue.enqueue(64);
//
//        System.out.println(queue.isEmpty());
//
//        while(!queue.isEmpty()){
//            System.out.println("peek:"+ queue.peek());
//            System.out.println("dequeue:"+ queue.dequeue());
//            System.out.println("size:"+ queue.size());
//            queue.print();
//            System.out.println("-----");
//        }
//
//        System.out.println(queue.isEmpty());

    //********************************************** Dictionary ********************************************

//        Dictionary <Integer, String> dictionary= new Dictionary<>();
//        System.out.println(dictionary.size());
//
//        dictionary.printAll();
//
//        dictionary.set(1,"c++");
//        dictionary.set(2,"java");
//        dictionary.set(3,"php");
//        dictionary.set(4,"js");
//        dictionary.set(5,"python");
//
//        dictionary.printAll();
//
//        dictionary.remove(2);
//
//        dictionary.print();
//        dictionary.set(6,"ts");
//        dictionary.set(7,"rust");
//        dictionary.set(8,"go");
//        dictionary.printAll();
//
//        System.out.println(dictionary.get(3));
//        System.out.println(dictionary.get(2));


        //********************************************** Hash Function ********************************************

    //        HashFunctions hf = new HashFunctions();
    //        System.out.println(hf.hash32("This is Original Text"));



        //********************************************** Hash table ********************************************

//        HashTable<String, String> hashTable = new HashTable<>();
//        hashTable.print();
//        hashTable.set("Sinar" , "sinar@gmail.com");
//        hashTable.set("Elvis" , "elvis@gmail.com");
//        hashTable.set("Tane" , "tane@gmail.com");
//        hashTable.print();
//        System.out.println(hashTable.get("tane"));
//        hashTable.set("ezz" , "sinar@gmail.com");
//        hashTable.set("ahmed" , "elvis@gmail.com");
//        hashTable.set("omar" , "tane@gmail.com");
//        hashTable.print();


        //********************************************** Binary Tree ********************************************



//        BinaryTree<Character> tree = new BinaryTree<>();
//        tree.Insert('A');
//        tree.Insert('B');
//        tree.Insert('C');
//        tree.Insert('D');
//        tree.Insert('E');
//        tree.Insert('F');
//        tree.Insert('G');
//        tree.Insert('H');
//        tree.Insert('I');
//        tree.Insert('j');
//        tree.Insert('k');
//        tree.Insert('l');
//      tree.Insert('m');
//        tree.Insert('n');
//        tree.Insert(17);
//        tree.Insert(18);
//
//
//        tree.printTree();
//
//       System.out.println("Height : " + tree.height());
//
//        System.out.print("pre order Traversal : ");
//        tree.preOrderTraversal();
//        System.out.print("in order Traversal : ");
//        tree.inOrderTraversal();
//        System.out.print("post order Traversal : ");
//        tree.postOrderTraversal();
//
//
//        BinaryTree.TreeNode<Character> nodeToDelete = tree.find('D');
//        tree.deleteNode(nodeToDelete);
//
//        tree.printTree(); // after deletion


//********************************************** Binary Search Tree ********************************************

    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(4);
        bst.insert(6);
        bst.insert(7);
        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);

        bst.printTree();

        System.out.println(bst.isExist(5));
        System.out.println(bst.isExist(50));

        bst.delete(4);
        bst.printTree();

        bst.delete(6);
        bst.printTree();

        bst.delete(3);
        bst.printTree();


    }
}


























