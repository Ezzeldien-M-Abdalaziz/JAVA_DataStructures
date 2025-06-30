
//LinkedListNode class
class LinkedListNode{
 public int data;
 public LinkedListNode next;

  LinkedListNode(int _data) {
   this.data = _data;
   this.next = null;
  }
}


//LinkedListIterator class
class LinkedListIterator{
    private LinkedListNode currentNode;

    LinkedListIterator() {
        currentNode = null;
    }

    LinkedListIterator(LinkedListNode node) {
        currentNode = node;
    }

    int data(){
        return this.currentNode.data;
    }

    LinkedListIterator next(){
        this.currentNode = this.currentNode.next;
        return this;
    }

    LinkedListNode current(){
        return this.currentNode;
    }
}


//linked list class
class LinkedList {
   public LinkedListNode head = null;
   public LinkedListNode tail = null;

    LinkedListIterator begin(){
       LinkedListIterator itr = new LinkedListIterator(this.head);
       return itr;
   }

   void printList(){
        if(this.head == null){
            System.out.println("[]");
        }
        for (LinkedListIterator itr = this.begin(); itr.current() != null; itr = itr.next()){
            System.out.print(itr.data() + " -> ");
        }
        System.out.println();
   }

   void insertLast(int _data) {
       LinkedListNode newNode = new LinkedListNode(_data);
       if(this.head == null){
           this.head = newNode; // head becomes the newNode
           this.tail = newNode; //also the tail since it's the only node for now
       }else{
           this.tail.next = newNode;    //exp 10 -> 20 "tail" -> null   becomes 10 -> 20 "tail" -> 30
           this.tail = newNode;   //exp 10 -> 20 "tail" -> 30 becomes 10 -> 20 -> 30 "tail"
       }
   }

   void insertAfter(int _data, LinkedListNode node) {
        //validation
        if(node == null){
            System.out.println("Node is null");
            return;
        }
        LinkedListNode newNode = new LinkedListNode(_data);  //create new node
          newNode.next = node.next;  //make the new node pointer same as the chosen node pointer
          node.next = newNode;  //make the node pointer is the new node
            if(this.tail == node){
                this.tail = newNode;
            }
   }

   LinkedListNode find(int _data) {
        for (LinkedListIterator itr = this.begin(); itr.current() != null; itr = itr.next()){
            if(itr.data() == _data){
                return itr.current();
            }
        }
        return null;
    }

    int findByIndex(int index) {
        //validation
        if(index > this.count() || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        int count = 0;
        for (LinkedListIterator itr = this.begin(); itr.current() != null; itr = itr.next()){
            if(count == index){
                return itr.data();
            }
            count++;
        }
        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    LinkedListNode findParent(LinkedListNode node) {
        for (LinkedListIterator itr = this.begin(); itr.current() != null; itr = itr.next()){
            if(itr.current().next == node){
                return itr.current();
            }
        }
        return null;
    }

    int count(){
        int count = 0;
        for (LinkedListIterator itr = this.begin(); itr.current() != null; itr = itr.next()){
            count++;
        }
        return count;
    }

    void insertAfterEnhanced(int _data, int index) {
        //validation
        if(index > this.count() || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        LinkedListNode node =  this.find(this.findByIndex(index));    //this gets the node of the index
        if(node == null){
            System.out.println("node is null");
            return;
        }
        LinkedListNode newNode = new LinkedListNode(_data);  //create new node
        newNode.next = node.next;  //make the new node pointer same as the chosen node pointer
        node.next = newNode;  //make the node pointer is the new node
        if(this.tail == node){
            this.tail = newNode;
        }
    }

    //insert before a node
    void insertBefore(int _data, int index) {
        //validation
        if(index > this.count() || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        LinkedListNode node =  this.find(this.findByIndex(index));    //this gets the node of the index
        if(node == null){
            System.out.println("node is null");
            return;
        }
        LinkedListNode newNode = new LinkedListNode(_data);  //create new node

        if(this.tail == null) {
            this.tail = newNode;
            return;
        }

        if(node == this.head){
            this.head = newNode;
            newNode.next = node;
        }else{
            LinkedListNode parent = this.findParent(node)  ;//get the prev node of the one i want to insert before
            newNode.next = node;
            parent.next = newNode;
        }

    }

    void deleteNode(int index){
        //validation
        if(index > this.count() || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        LinkedListNode toDelete =  this.find(this.findByIndex(index));    //this gets the node of the index
        if(toDelete == null){
            System.out.println("node is null");
            return;
        }

        // delete head
        if(index == 0){
            this.head = this.head.next;
            if(this.head == null) {
                this.tail = null; // list is now empty
            }
            return;
        }

        LinkedListNode parent = this.findParent(toDelete);

        if (toDelete == this.tail) {
            if (parent != null) {
                parent.next = null;
            }
            this.tail = parent;
            return;
        }

        parent.next = toDelete.next;
    }





}


















