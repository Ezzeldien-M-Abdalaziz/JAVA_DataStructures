public class Queue<T> {
    private LinkedList<T> dataList;
    int length;

    public Queue() {
        dataList = new LinkedList<>();
        length = 0;
    }

    void enqueue(T data) {
        this.dataList.insertLast(data);
        this.length++;
    }

    T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        T data = this.dataList.head.data;
        this.dataList.deleteHead();
        this.length--;
        return data;
    }

    T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return this.dataList.head.data;
    }

    int size() {
        return this.length;
    }

    boolean isEmpty() {
        return this.dataList.head == null;
    }

    void print() {
        this.dataList.printList();
    }
}
