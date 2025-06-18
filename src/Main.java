public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);

        list.printList();  // Output: 10 -> 20 -> 30 -> null
    }
}
