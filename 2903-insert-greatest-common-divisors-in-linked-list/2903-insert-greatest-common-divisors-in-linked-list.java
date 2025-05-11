class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null || head == null){
            return head;
        }
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        while(temp2 != null){
            int g = gcd(temp1.val , temp2.val);
            ListNode gd = new ListNode(g);
            temp2 = temp1.next;
            gd.next = temp2;
            temp1.next = gd;
            temp1 = temp2;
            temp2 = temp2.next;
        }
        return head;
    }
    public int gcd(int a , int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}