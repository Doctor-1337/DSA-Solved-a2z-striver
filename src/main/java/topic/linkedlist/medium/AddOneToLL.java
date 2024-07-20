package topic.linkedlist.medium;

public class AddOneToLL {

    //It uses the concept of recursion reversal , we need to add from back

    public static Node addOneMultiPass(Node head) {
        //code here.
        Node newHead = rev(head);

        int carry = 1;
        Node temp = newHead;
        Node prev = null;
        while (carry == 1 && temp != null) {
            if (temp.data < 9) {
                temp.data++;
                carry = 0;
            } else {
                temp.data = 0;
                prev = temp;
            }
            temp = temp.next;
        }
        if (carry == 1)
            prev.next = new Node(1);

        return rev(newHead);

    }

    public static Node rev(Node head) {
        if (head == null || head.next == null)
            return head;

        Node newHead1 = rev(head.next);

        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead1;
    }

    //best solution, so many less iterations
    public static Node addOne(Node head) {
        //code here.

        int carry = addOneRec(head);

        if (carry == 1) {
            Node node = new Node(carry);
            node.next = head;
            return node;
        }
        return head;
    }

    public static int addOneRec(Node head) {

        if (head == null) {
            return 1;
        }

        int carry = addOneRec(head.next);

        if (carry == 1) {
            if (head.data == 9) {
                head.data = 0;
            } else {
                head.data++;
                carry = 0;
            }
        }
        return carry;


    }

}
