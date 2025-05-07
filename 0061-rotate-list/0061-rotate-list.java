class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode first=head;
        int len=0;
        while(first!=null){
            len++;
            first=first.next;
        }
        first=head;
        k=k%len;
        if(k==0 || len==0) return head;
        for(int i=0;i<k;i++){
            first=first.next;
        }
        if(first==null) return head;
        ListNode second=head;
        while(first!=null && first.next!=null){
            second=second.next;
            first=first.next;
        }
        ListNode dummy=new ListNode(0,second.next);
        ListNode temp=dummy;
        while(temp.next!=null){
            temp=temp.next;
        }
        second.next=null;
        temp.next=head;
        return dummy.next;
    }
}