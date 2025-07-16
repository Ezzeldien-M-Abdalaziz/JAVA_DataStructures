public class Stack<T> {
    private LinkedList<T> dataList;

    public Stack() {
        this.dataList = new LinkedList<>();
    }

    public void push(T data) {
        this.dataList.insertFirst(data);
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        T headData = this.dataList.head.data;
        this.dataList.deleteHead();
        return headData;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return this.dataList.head.data;
    }

    public boolean isEmpty() {
        return this.dataList.length <= 0;
    }

    public void print() {
        this.dataList.printList();
    }

    public int size() {
        return this.dataList.length;
    }
}
