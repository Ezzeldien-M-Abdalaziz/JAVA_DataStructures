public class Main {
    public static void main(String[] args) {

        //**********************************************Array********************************************

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

        //**********************************************LinkedList********************************************
        LinkedList list = new LinkedList();
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);

        list.printList();  // Output: 10 -> 20 -> 30 -> null
    }
}
