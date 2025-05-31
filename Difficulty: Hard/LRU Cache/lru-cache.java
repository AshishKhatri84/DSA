class LRUCache {
    static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static Map<Integer, Node> cache;
    static int capacity;
    static Node head, tail;

    LRUCache(int cap) {
        capacity = cap;
        cache = new HashMap<>();
        head = new Node(0, 0); 
        tail = new Node(0, 0); 
        head.next = tail;
        tail.prev = head;
    }

    public static int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public static void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        if (cache.size() == capacity) {
            remove(tail.prev); 
        }

        Node newNode = new Node(key, value);
        insertToFront(newNode);
    }

    private static void remove(Node node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static void insertToFront(Node node) {
        cache.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}