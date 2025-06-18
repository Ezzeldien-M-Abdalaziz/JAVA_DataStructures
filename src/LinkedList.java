
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
        for (LinkedListIterator itr = this.begin(); itr.current() != null; itr = itr.next()){
            System.out.print(itr.data() + " -> ");
        }
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
}


















