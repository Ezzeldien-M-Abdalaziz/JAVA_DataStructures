public class Stack {
    private LinkedList dataList;
    Stack() {
        this.dataList = new LinkedList();
    }

    void push(int data) {
        this.dataList.insertFirst(data);
    }

    int pop() {
        int head_data = this.dataList.head.data;
        this.dataList.deleteHead();
        return head_data;
    }

    int peek(){
        return this.dataList.head.data;
    }

    boolean isEmpty(){
        return this.dataList.length <= 0;
    }

    void print(){
        this.dataList.printList();
    }
}













