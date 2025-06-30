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
//        System.out.println(list2.head.data);
//        System.out.println(list2.tail.data);

        //**********************************************Doubly LinkedList********************************************

        DoublyLinkedList list = new DoublyLinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        System.out.println(list.head.data);
        System.out.println(list.tail.data);
        System.out.println(list.tail.back.data);
        System.out.println(list.head.next.data);
        System.out.println(list.count());
        list.printList();
        System.out.println(list.findByIndex(0));
        System.out.println(list.findByIndex(1).data);
        System.out.println(list.findByData(3));
        System.out.println(list.count());
        list.deleteNode(2);
        list.deleteNode(1);
        list.deleteNode(0);
        list.printList();

    }
}
