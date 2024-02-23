import java.util.ArrayList;

class MyHashMap {

    static class Node {
        public int key;
        public int value;
        public int hashCode;
        public Node next;

        public Node(int key, int value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }
    }

    private ArrayList<Node> bucketArray;
    private int numBuckets;
    private int size;

    public MyHashMap() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }

    public void put(int key, int value) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        Node head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.key == key && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucketArray.get(bucketIndex);
        Node newNode = new Node(key, value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        // for loadfactor
        if ((1.0 * size) / numBuckets >= 0.7) {
            ArrayList<Node> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);

            for (Node node : temp) {
                while (node != null) {
                    put(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }

    public int get(int key) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        Node head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.key == key && head.hashCode == hashCode)
                return head.value;
            head = head.next;
        }

        return -1;
    }

    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        Node head = bucketArray.get(bucketIndex);
        Node prev = null;

        while (head != null) {

            if (head.key == key && head.hashCode == hashCode)
                break;

            prev = head;
            head = head.next;
        }

        if (head == null)
            return;

        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        size--;
    }

    private int size() {
        return size;
    }

    private boolean isEmpty() {
        return (size == 0);
    }

    private int getBucketIndex(int key) {
        int hashCode = hashCode(key);
        int index = hashCode % numBuckets;

        index = index < 0 ? index * -1 : index;
        return index;
    }

    private int hashCode(int key) {
        // Use a simple hash function
        return key % numBuckets;
    }
}
