
//LinkedListNode class
class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;

    LinkedListNode(T _data) {
        this.data = _data;
        this.next = null;
    }
}



//LinkedListIterator class
class LinkedListIterator<T> {
    private LinkedListNode<T> currentNode;

    LinkedListIterator() {
        currentNode = null;
    }

    LinkedListIterator(LinkedListNode<T> node) {
        currentNode = node;
    }

    T data() {
        return this.currentNode.data;
    }

    LinkedListIterator<T> next() {
        this.currentNode = this.currentNode.next;
        return this;
    }

    LinkedListNode<T> current() {
        return this.currentNode;
    }
}


//linked list class
class LinkedList<T> {
    public LinkedListNode<T> head = null;
    public LinkedListNode<T> tail = null;
    public int length;

    LinkedListIterator<T> begin() {
        return new LinkedListIterator<>(this.head);
    }

    void printList() {
        if (this.head == null) {
            System.out.println("[]");
            return;
        }
        for (LinkedListIterator<T> itr = this.begin(); itr.current() != null; itr = itr.next()) {
            System.out.print(itr.data() + " -> ");
        }
        System.out.println();
    }

    void insertLast(T _data) {
        LinkedListNode<T> newNode = new LinkedListNode<>(_data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }

    void insertFirst(T _data) {
        LinkedListNode<T> newNode = new LinkedListNode<>(_data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    LinkedListNode<T> find(T _data) {
        for (LinkedListIterator<T> itr = this.begin(); itr.current() != null; itr = itr.next()) {
            if (itr.data().equals(_data)) {
                return itr.current();
            }
        }
        return null;
    }

    T findByIndex(int index) {
        if (index >= this.count() || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        int count = 0;
        for (LinkedListIterator<T> itr = this.begin(); itr.current() != null; itr = itr.next()) {
            if (count == index) {
                return itr.data();
            }
            count++;
        }
        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    LinkedListNode<T> findParent(LinkedListNode<T> node) {
        for (LinkedListIterator<T> itr = this.begin(); itr.current() != null; itr = itr.next()) {
            if (itr.current().next == node) {
                return itr.current();
            }
        }
        return null;
    }

    void insertAfter(T _data, LinkedListNode<T> node) {
        if (node == null) {
            System.out.println("Node is null");
            return;
        }
        LinkedListNode<T> newNode = new LinkedListNode<>(_data);
        newNode.next = node.next;
        node.next = newNode;
        if (this.tail == node) {
            this.tail = newNode;
        }
        this.length++;
    }

    void insertAfterEnhanced(T _data, int index) {
        T targetData = this.findByIndex(index);
        LinkedListNode<T> node = this.find(targetData);
        if (node == null) {
            System.out.println("node is null");
            return;
        }
        insertAfter(_data, node);
    }

    void insertBefore(T _data, int index) {
        T targetData = this.findByIndex(index);
        LinkedListNode<T> node = this.find(targetData);
        if (node == null) {
            System.out.println("node is null");
            return;
        }
        LinkedListNode<T> newNode = new LinkedListNode<>(_data);

        if (this.tail == null) {
            this.tail = newNode;
            return;
        }

        if (node == this.head) {
            this.head = newNode;
            newNode.next = node;
        } else {
            LinkedListNode<T> parent = this.findParent(node);
            newNode.next = node;
            parent.next = newNode;
        }
        this.length++;
    }

    void deleteNode(int index) {
        if (index >= this.count() || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        T toDeleteData = this.findByIndex(index);
        LinkedListNode<T> toDelete = this.find(toDeleteData);
        if (toDelete == null) {
            System.out.println("node is null");
            return;
        }

        if (index == 0) {
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
            this.length--;
            return;
        }

        LinkedListNode<T> parent = this.findParent(toDelete);
        if (toDelete == this.tail) {
            if (parent != null) {
                parent.next = null;
            }
            this.tail = parent;
        } else {
            parent.next = toDelete.next;
        }
        this.length--;
    }

    void deleteHead() {
        if (this.head == null) {
            System.out.println("head is null");
            return;
        }
        this.head = this.head.next;
        this.length--;
    }

    int count() {
        int count = 0;
        for (LinkedListIterator<T> itr = this.begin(); itr.current() != null; itr = itr.next()) {
            count++;
        }
        return count;
    }
}



















