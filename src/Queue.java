public class Queue {
    private LinkedList dataList ;
    int length ;

    public Queue() {
        dataList = new LinkedList();
        length = 0;
    }

    void enqueue(int data) {
        this.dataList.insertLast(data);
        this.length++;
    }


    int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return 0;
        }
        LinkedListNode head = this.dataList.head;
        this.dataList.deleteHead();
        this.length--;
        return head.data;
    }

    int peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return 0;
        }
        return this.dataList.head.data;
    }
    int size() {
        return this.length;
    }

    boolean isEmpty() {
        return this.dataList.head == null;
    }
    void print(){
        this.dataList.printList();
    }

















}
