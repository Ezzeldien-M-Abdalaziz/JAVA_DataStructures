
class LinkedListNode{
 public int data;
 public LinkedListNode next;

  LinkedListNode(int _data) {
   this.data = _data;
   this.next = null;
  }
}



class LinkedListIterator{
a
}


class LinkedList {
   public LinkedListNode head = null;
   public LinkedListNode tail = null;

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


















