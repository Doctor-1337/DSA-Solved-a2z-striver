package topic.linkedlist.medium;

public class Sort012s {
    //Very tough pls revise
    static Node segregate(Node head) {
        Node dummyZero = new Node(-1);
        Node dummyOne = new Node(-1);
        Node dummyTwo = new Node(-1);
        Node startOne = dummyOne;
        Node startTwo = dummyTwo;
        Node startZero = dummyZero;
        Node temp = head;

        while (temp != null) {

            if (temp.data == 0) {
                dummyZero.next = temp;
                temp = temp.next;
                dummyZero = dummyZero.next;
            } else if (temp.data == 1) {
                dummyOne.next = temp;
                temp = temp.next;
                dummyOne = dummyOne.next;
            } else {
                dummyTwo.next = temp;
                temp = temp.next;
                dummyTwo = dummyTwo.next;
            }

        }

        //Most important part how to rejoin as required
        //dummyZero.next will be either null or Zero
        //StartOne will either be 1 or null, startTwo will either be null or 2;
        dummyZero.next = startOne.next != null ? startOne.next : startTwo.next;
        //It could be 1 or null,
        dummyOne.next = startTwo.next;

        dummyTwo.next = null;

        return startZero.next;


    }
}
