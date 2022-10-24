import java.util.NoSuchElementException;

public class DoublyLinkedListDS {
    private ListNode head;
    private ListNode tail;
    private int length;

    public class ListNode {
        private ListNode next;
        private ListNode previous;
        private int data;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public DoublyLinkedListDS() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    //------------------------------------------------------------------------------------------------------------------
    public void displayForward() {
        if (head == null) {
            return;
        }
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        if (tail == null) {
            return;
        }
        ListNode temp = tail;

        while (temp != null) {
            System.out.print(temp.data + " -->");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    //------------------------------------------------------------------------------------------------------------------
    //Insert at the beginning :
    public void insertAtBeginning(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    //------------------------------------------------------------------------------------------------------------------
    //Insert at the end :
    public void insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    //------------------------------------------------------------------------------------------------------------------
    //Insert at given position :
    public void insertAt(int value, int position) {
        ListNode newNode = new ListNode(value);
        ListNode temp = head;
        int count = 1;

        while (count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp.next == null) {
            insertAtEnd(value);
        }

        newNode.next = temp.next;
        temp.next.previous = newNode;
        temp.next = newNode;
        newNode.next.previous = temp;
    }

    //------------------------------------------------------------------------------------------------------------------
    //Delete first node :
    public ListNode deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is Empty");
        }
        ListNode temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    //------------------------------------------------------------------------------------------------------------------
    //Delete last node :
    public ListNode deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is Empty");
        }
        ListNode temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        DoublyLinkedListDS dll = new DoublyLinkedListDS();
        dll.insertAtBeginning(5);
        dll.insertAtBeginning(4);
        dll.insertAtBeginning(3);
        dll.insertAtBeginning(2);
        dll.insertAtBeginning(1);

       dll.insertAtEnd(6);
       dll.insertAtEnd(7);

        System.out.println("Node " + dll.deleteFirst().data + " is deleted");

        System.out.println("Node " + dll.deleteLast().data + " is deleted");

        dll.insertAt(55, 6);

        dll.displayForward();

        dll.displayBackward();
    }
}
