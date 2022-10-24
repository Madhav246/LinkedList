import java.util.NoSuchElementException;

public class CircularLinkedList {
    private ListNode last;
    private int length;

    public class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public CircularLinkedList() {
        length = 0;
        last = null;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void createCircularLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = first;

        last = sixth;
    }

    //------------------------------------------------------------------------------------------------------------------
    public void display() {
        if (last == null) {
            return;
        }

        ListNode first = last.next;

        while (first != last) {
            System.out.print(first.data + " -->");
            first = first.next;
        }
        System.out.print(first.data);
    }

    //------------------------------------------------------------------------------------------------------------------
    //Insert Node at the beginning :
    public void insertAtBeginning(int value) {
        ListNode newNode = new ListNode(value);
        if (last == null) {
            last = newNode;
        } else {
            newNode.next = last.next;
        }
        last.next = newNode;
        length++;
    }

    //------------------------------------------------------------------------------------------------------------------
    //Insert Node at the end :
    public void insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    //------------------------------------------------------------------------------------------------------------------
    //Delete first Node :
    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is Empty!");
        }
        ListNode temp = last.next;
        if (last.next == last) {
            last = null;
        } else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.createCircularLinkedList();
        cll.display();

    }

}
