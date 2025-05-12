class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        while (curr != null){
            if (curr.next!=null && curr.val == curr.next.val){
                while (curr.next!= null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                prev.next = curr.next;
            }
            else{
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}