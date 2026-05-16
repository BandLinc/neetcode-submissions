class LRUCache {

    class Node {
        int key;
        int value;

        Node previous;
        Node next;

        Node (int key, int value) {
            this.key = key;
            this.value = value; 
        }
    }

    private int capacity;

    private Map<Integer,Node> cache; 

    private Node head;

    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node (0,0);
        tail = new Node (0,0);

        head.next = tail;
        tail.previous = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        remove (node);
        insertToFront (node);

        return node.value;
    }
    
    public void put(int key, int value) {

        if (cache.containsKey (key)) {
            Node existingNode = cache.get(key);
            remove(existingNode);
            cache.remove(key);
        }

        Node newNode = new Node (key,value);
        cache.put(key,newNode);
        insertToFront (newNode);

        if (cache.size() > capacity) {
            Node lru = tail.previous;
            remove (lru);
            cache.remove(lru.key);
        }
        
    }

    public void remove (Node node) {
        Node prev = node.previous;
        Node nextNode = node.next;

        nextNode.previous = prev;
        prev.next = nextNode;
    }

    public void insertToFront (Node node) {
        Node currentFirst = head.next; 

        head.next = node;
        node.previous = head;

        node.next = currentFirst;
        currentFirst.previous = node; 
    }
}
