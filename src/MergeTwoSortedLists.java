public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public String toString() {
            return "Val: " + this.val;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) {
            while (list1 != null) {
                curr.next = list1;
                list1 = list1.next;
                curr = curr.next;
            }
        }

        if (list2 != null) {
            while (list2 != null) {
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(4);
        ListNode ln4 = new ListNode(1);
        ListNode ln5 = new ListNode(3);
        ListNode ln6 = new ListNode(4);
        ListNode ln7 = new ListNode();
        ListNode ln8 = new ListNode();
        ListNode ln9 = new ListNode();
        ListNode ln10 = new ListNode(0);

        ListNode dummy1 = new ListNode(-1);
        dummy1.next = ln1;
        ln1.next = ln2;
        ln2.next = ln3;

        ListNode dummy2 = new ListNode(-1);
        dummy2.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;

        ListNode sorted1 = mergeTwoLists(dummy1.next, dummy2.next);
        System.out.println("New Sorted List 1:");
        while (sorted1 != null) {
            System.out.println(sorted1.toString());
            sorted1 = sorted1.next;
        }
        System.out.println();

        ListNode dummy3 = new ListNode(-1);
        dummy3.next = ln7;

        ListNode dummy4 = new ListNode(-1 );
        dummy4.next = ln8;

        ListNode sorted2 = mergeTwoLists(dummy3.next, dummy4.next);
        System.out.println("New Sorted List 2:");
        while (sorted2 != null) {
            System.out.println(sorted2.toString());
            sorted2 = sorted2.next;
        }
        System.out.println();

        ListNode dummy5 = new ListNode(-1);
        dummy5.next = ln9;

        ListNode dummy6 = new ListNode(-1);
        dummy6.next = ln10;

        ListNode sorted3 = mergeTwoLists(dummy5.next, dummy6.next);
        System.out.println("New Sorted List3:");
        while (sorted3 != null) {
            System.out.println(sorted3.toString());
            sorted3 = sorted3.next;
        }

    }
}
