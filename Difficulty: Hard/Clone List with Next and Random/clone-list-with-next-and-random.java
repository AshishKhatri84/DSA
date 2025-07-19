class Solution {
    public Node cloneLinkedList(Node head) {
        if (head == null) {
            return null; // If the list is empty, return null
        }

        // Step 1: Create a copy of each node and insert it right next to the original node
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.data);
            copy.next = current.next;
            current.next = copy;
            current = copy.next; // Move to the next original node
        }

        // Step 2: Assign the random pointers for the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next; // Set the random pointer of the copied node
            }
            current = current.next.next; // Move to the next original node
        }

        // Step 3: Separate the copied nodes from the original list
        current = head;
        Node copiedHead = head.next; // The head of the copied list
        Node copyCurrent = copiedHead;

        while (current != null) {
            current.next = current.next.next; // Restore the original list
            if (copyCurrent.next != null) {
                copyCurrent.next = copyCurrent.next.next; // Link the copied nodes
            }
            current = current.next; // Move to the next original node
            copyCurrent = copyCurrent.next; // Move to the next copied node
        }

        return copiedHead; // Return the head of the copied linked list
    }
}