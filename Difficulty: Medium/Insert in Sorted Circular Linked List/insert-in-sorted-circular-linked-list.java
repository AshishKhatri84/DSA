class Solution {
    public Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node current = head;
        while (true) {
            Node next = current.next;
            if (current.data <= data && data <= next.data) {
                break;
            }
            if (current.data > next.data) {
                if (data >= current.data || data <= next.data) {
                    break;
                }
            }
            current = current.next;
            if (current == head) {
                break;
            }
        }
        newNode.next = current.next;
        current.next = newNode;
        return (data < head.data) ? newNode : head;
    }
}