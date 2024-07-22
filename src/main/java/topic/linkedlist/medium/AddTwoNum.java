package topic.linkedlist.medium;

public class AddTwoNum {
    //I was initially doing reverse and adding but it was simple just add two from front no need to compensate for unit places
    //Many edge cases, check for carry condition, It can be further optimised by removing the if condition
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;

        while (temp1 != null || temp2 != null) {
            int data1 = 0;
            int data2 = 0;
            if (temp1 != null) {
                data1 = temp1.val;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                data2 = temp2.val;
                temp2 = temp2.next;
            }
            int sum = data1 + data2 + carry;
            if (sum > 9) {
                dummy.next = new ListNode(sum - 10);
                carry = 1;
            } else {
                dummy.next = new ListNode(sum);
                carry = 0;
            }
            dummy = dummy.next;
        }
        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            dummy.next = newNode;
        }

        return ans.next;
    }
    public ListNode addTwoNumbersNoIf(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;

        while (temp1 != null || temp2 != null) {
            int data1 = 0;
            int data2 = 0;
            if(temp1 != null){
                data1 = temp1.val;
                temp1 = temp1.next;
            }
            if(temp2 != null){
                data2 = temp2.val;
                temp2 = temp2.next;
            }

            int sum = carry + data1 + data2;

            carry = sum/10;
            sum = sum%10;
            dummy.next = new ListNode(sum);

            dummy = dummy.next;
        }
        if(carry == 1){
            ListNode newNode =new ListNode(1);
            dummy.next = newNode;
        }

        return ans.next;
    }
}
