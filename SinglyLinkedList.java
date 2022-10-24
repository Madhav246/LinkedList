public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        //Constructor :
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    // print elements of Linked List:
    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + "--> ");
            current = current.next;
        }
        System.out.print("null");
    }

    //------------------------------------------------------------------------------------------------------------------
    // Find the length :
    public int length() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Insert at the beginning :
    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);

        newNode.next = head;
        head = newNode;
    }

    //------------------------------------------------------------------------------------------------------------------
    //Insert at the end :
    public void insertEnd(int value) {
        ListNode newNode = new ListNode(value);
        ListNode current = head;

        if (head == null) {
            head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //Insert node at given position :
    public void insertPos(int value, int position) {
        ListNode newNode = new ListNode(value);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode previous = head;
            int count = 1;

            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    // Delete first Node :
    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Delete Last Node :
    public ListNode deleteLast() {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;
        return current;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Delete Node from a given position :
    public void deletePos(int position) {
        if (position == 1) {
            head = head.next;
        } else {
            ListNode previous = head;
            int count = 1;

            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    // Remove a given key from the Singly LinkedList :
    public void deleteKey(int key) {
        ListNode current = head;
        ListNode temp = null;

        if (current != null && current.data == key) {
            head = current.next;
        }

        while (current != null && current.data != key) {
            temp = current;
            current = current.next;
        }
        if (current == null) {
            return;
        }
        temp.next = current.next;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Insert a node in a sorted Singly LinkedList :
    public void insertInSortedList(int value) {
        ListNode newNode = new ListNode(value);
        ListNode current = head;

        if (head == null || head.data > newNode.data) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode temp = null;
            while (current != null && current.data < newNode.data) {
                temp = current;
                current = current.next;
            }
            newNode.next = current;
            temp.next = newNode;
            return;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    // Remove Duplicates from a sorted Singly LinkedList :
    public void removeDuplicates() {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    //Remove Duplicates from an unsorted SinglyLinkedList :
    public void removeDuplicatesUnSorted() {
        ListNode current = head;
        ListNode ptr1 = null;

        while (current != null && current.next != null) {
            ptr1 = current;

            while (ptr1.next != null) {
                if (current.data == ptr1.next.data) {
                    ptr1.next = ptr1.next.next;
                } else {
                    ptr1 = ptr1.next;
                }
            }
            current = current.next;
        }
    }
    /* public Node removeDuplicates(Node head)
    {
         // Your code here
         HashSet<Integer> hs = new HashSet<>();

        Node current = head;
        Node prev = null;
        while (current != null) {                                          //Faster
            int curval = current.data;

            if (hs.contains(curval)) {
                prev.next = current.next;
            }
            else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
    *  */

    //------------------------------------------------------------------------------------------------------------------
    // Reverse a Singly LinkedList :
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public void display1(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.data + "--> ");
            current = current.next;
        }
        System.out.print("null");
    }

    //------------------------------------------------------------------------------------------------------------------
    // Reverse List in 'K' groups :
    ListNode reverseKgroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }

        if (next != null) {
            head.next = reverseKgroup(next, k);
        }
        return previous;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Find the middle node in Singly LinkedList:
    public ListNode getMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Find the nth node from the end :
    public ListNode findNthFromEnd(int n) {
        if (head == null) {
            return null;
        }

        if (n <= 0) {
            throw new IllegalArgumentException("Invalid node");
        }
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;

        while (count < n) {
            if (refPtr == null) {
                throw new IllegalArgumentException(n + " is greater than the number of nodes in the LinkedList");
            }
            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Detect loop in a Singly LinkedList :
    public boolean detectLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Find the starting node of the loop in Singly LinkedList :
    public ListNode detectStartingOfLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }

    public ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = head;

        while (slowPtr != temp) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Remove loop from a Singly LinkedList :
    public void removeLoop(ListNode head) {
        ListNode temp = head;
        ListNode slowPtr = getStartingNode(head);
        while (slowPtr.next != temp) {
            temp = temp.next;
        }
        slowPtr.next = null;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Check palindrome :
    public boolean checkPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        ListNode current = slowPtr;
        ListNode next = null;
        ListNode previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        fastPtr = head;
        while (previous != null) {
            if (fastPtr.data != previous.data) {
                return false;
            }

            fastPtr = fastPtr.next;
            previous = previous.next;
        }
        return true;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Sort 0, 1, 2 :
    public ListNode sortZeroOneTwo(ListNode head) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        ListNode current = head;

        while (current != null) {
            if (current.data == 0) {
                zeroCount++;
            } else if (current.data == 1) {
                oneCount++;
            } else if (current.data == 2) {
                twoCount++;
            }
            current = current.next;
        }

        current = head;

        while (current != null) {
            if (zeroCount != 0) {
                current.data = 0;
                zeroCount--;
            } else if (oneCount != 0) {
                current.data = 1;
                oneCount--;
            } else if (twoCount != 0) {
                current.data = 2;
                twoCount--;
            }
            current = current.next;
        }
        return head;
    }

    /* Change Links :   (Correct but not working properly GFG)
    static void insert(Node tail, Node current){
        tail.next = current;
        tail = current;
    }

    static Node segregate(Node head)
    {
        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;

        Node oneHead = new Node(-1);
        Node oneTail = oneHead;

        Node twoHead = new Node(-1);
        Node twoTail = twoHead;

        Node current = head;

        while(current != null){
            int value = current.data;

            if(value == 0){
                insert(zeroTail, current);
            }

            else if(value == 1){
                insert(oneTail, current);
            }

            else if(value == 2){
                insert(twoTail, current);
            }

            current = current.next;
        }

        //Merge List :
        if(oneHead.next != null){
            zeroTail.next = oneHead.next;
        }
        else {
             zeroTail.next = twoHead.next;
        }

         oneTail.next = twoHead.next;
         twoTail.next = null;

         head = zeroHead.next;

         return head;
    } */

    //------------------------------------------------------------------------------------------------------------------
    // Merge two Sorted LinkedList :
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head.next;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Add two numbers represented by LinkedList :
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int carry = 0;

        while (a != null || b != null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;

            int sum = carry + x + y;
            carry = sum / 10;

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Rotate LinkedList :
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode current = head;
        int length = 1;

        while (current.next != null) {
            length++;
            current = current.next;
        }

        current.next = head;
        k = k % length;
        k = length - k;                          //For left rotate don't change the value k (length-k)

        while (k > 0) {
            current = current.next;
            k--;
        }

        head = current.next;
        current.next = null;

        return head;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Merge Sort in LinkedList :
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head.next;
        ListNode slow = head;

        // Find the mid-point of the list
        while (fast != null && fast.next != null) { // iterate at least once
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list
        ListNode second = slow.next;
        slow.next = null;

        // Sort each half
        head = sortList(head);
        second = sortList(second);

        // Merge
        return merge(head, second);
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode result = new ListNode(0);
        ListNode head = result;

        while (first != null && second != null) {
            if (first.data < second.data) {
                result.next = first;
                first = first.next; // move forward
            } else {
                result.next = second;
                second = second.next;
            }
            result = result.next;
        }

        if (first != null) {
            result.next = first;
            result = result.next;
        }

        if (second != null) {
            result.next = second;
            result = result.next;
        }

        return head.next;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Flatten a LinkedList :
    /*
    Node merge(Node a, Node b) {
        Node temp = new Node(0);
        Node result = temp;

        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        if (a != null) {
            temp.bottom = a;
        } else {
            temp.bottom = b;
        }

        return result.bottom;
    }

    Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }

        root.next = flatten(root.next);

        root = merge(root, root.next);

        return root;

    } */


    //------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(5);
        ListNode second = new ListNode(6);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(2);

        ListNode sixth = new ListNode(12);


        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        // sixth.next = third;

        // sll.insertFirst(1);
        // sll.insertEnd(1);
        // sll.insertPos(1, 7);
        sll.display();
        System.out.println();

      /*  System.out.println("First Node to be removed:" + sll.deleteFirst().data);
        sll.display();
        System.out.println();

        System.out.println("Last Node to be removed:" + sll.deleteLast().data);
        sll.display();
        System.out.println();

        sll.deletePos(3);
        sll.display();
        System.out.println();

        sll.deleteKey(8);
        sll.display();
        System.out.println();*/

        // sll.insertInSortedList(4);
        //  sll.removeDuplicatesUnSorted();
        // sll.display();
        //System.out.println();

        //sll.head = sll.reverseList(sll.head);
        //sll.display1(sll.head);

        System.out.println("Middle Node: " + sll.getMiddle(sll.head).data);
        // System.out.println("Nth node from end is: " + sll.findNthFromEnd(3).data);
        // System.out.println(sll.detectStartingOfLoop().data);
        System.out.println(sll.checkPalindrome(sll.head));
        //sll.head = sll.reverseKgroup(sll.head, 2);
        //sll.display1(sll.head);
        System.out.println();
        //sll.head =  sll.sortList(sll.head);
        // sll.display1(sll.head);

        System.out.println("Length :" + " " + sll.length());
    }
}
