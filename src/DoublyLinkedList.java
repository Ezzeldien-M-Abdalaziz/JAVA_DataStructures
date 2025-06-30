class DoublyLinkedListNode{
    int data ;
    DoublyLinkedListNode next;
    DoublyLinkedListNode back;

    DoublyLinkedListNode(int data){
        this.data = data;
        this.next = null;
        this.back = null;
    }
}


class DoublyLinkedListIterator{
    private DoublyLinkedListNode currentNode;

    DoublyLinkedListIterator() {
        currentNode = null;
    }

    DoublyLinkedListIterator(DoublyLinkedListNode node) {
        currentNode = node;
    }

    int data(){
        return this.currentNode.data;
    }

    DoublyLinkedListIterator next(){
        this.currentNode = this.currentNode.next;
        return this;
    }

    DoublyLinkedListNode current(){
        return this.currentNode;
    }
}




class DoublyLinkedList {
    public DoublyLinkedListNode head = null;
    public DoublyLinkedListNode tail = null;

    void insertAfter(DoublyLinkedListNode node , int data){
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);  //create new node from the data
        newNode.next = node.next;
        newNode.back = node;
        node.next = newNode;

        if(newNode.next == null){
            this.tail = newNode;
        }else{
            newNode.next.back = newNode;
        }
    }

    void insertLast(int data){
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);  //create new node from the data
        if(this.tail ==null){
            this.head = newNode;
        }else{
            this.tail.next = newNode;
            newNode.back = this.tail;
        }
        this.tail = newNode;
    }

    void insertFirst(int data){
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);  //create new node from the data
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.head.back = newNode;
            this.head = newNode;
            newNode.next = this.head;
        }
    }

    DoublyLinkedListIterator begin(){
        DoublyLinkedListIterator itr = new DoublyLinkedListIterator(this.head);
        return itr;
    }

    void printList(){
        if(this.head == null){
            System.out.println("[]");
        }
        for (DoublyLinkedListIterator itr = this.begin(); itr.current() != null; itr = itr.next()){
            System.out.print(itr.data() + " -> ");
        }
        System.out.println();
    }

    int count(){
        int count = 0;
        for (DoublyLinkedListIterator itr = this.begin(); itr.current() != null; itr = itr.next()){
            count++;
        }
        return count;
    }

    DoublyLinkedListNode findByIndex(int index) {
        //validation
        if(index > this.count() || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        int count = 0;
        for (DoublyLinkedListIterator itr = this.begin(); itr.current() != null; itr = itr.next()){
            if(count == index){
                return itr.current();
            }
            count++;
        }
        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    int findByData(int _data) {
        int count = 0;
        for (DoublyLinkedListIterator itr = this.begin(); itr.current() != null; itr = itr.next()){
            if(itr.data() == _data){
                return count;
            }
            count++;
        }
        throw new IndexOutOfBoundsException("data not found: " + _data);
    }

    void deleteNode(int index){
        DoublyLinkedListNode node =  this.findByIndex(index);

        if (node == this.head && node == this.tail){
            this.head = null;
            this.tail = null;
            return;
        }

        if(this.head == node){
            this.head = node.next;
            this.head.back = null;
            return;
        }

        if(this.tail == node){
            this.tail = node.back;
            tail.next = null;
            return;
        }
        node.next.back = node.back;
        node.back.next = node.next;
    }

    void insertBefore(int data , int index){
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);  //create new node from the data

        //there are no nodes case
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        DoublyLinkedListNode node =  this.findByIndex(index);  //index node

        //node is head case
        if(node == this.head){
            node.back = newNode;
            newNode.next = node;
            this.head = newNode;
            return;
        }

        //other cases
            node.back.next = newNode;
            newNode.back = node.back;
            node.back = newNode;
            newNode.next = node;
    }

}









































