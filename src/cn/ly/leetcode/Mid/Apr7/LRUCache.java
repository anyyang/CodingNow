package cn.ly.leetcode.Mid.Apr7;

class LRUCache {
    Node head = new Node();
    int capaticy = 0;

    public LRUCache(int capacity) {
        this.capaticy = capacity;
        head.isHeader = true;
    }

    public int get(int key) {
        Node finder = head.next;
        if(finder!=null ){
            if( finder.key==key){
                return finder.value;
            }
        }
        while (finder != null) {
            if (finder.key == key) {
                break;
            }
            finder=finder.next;
        }
        if (finder == null) {
            return -1;
        }
        finder.pre.next = finder.next;  //  旧位置前后切割
        if(finder.next!=null){
            finder.next.pre = finder.pre;
        }

        finder.next = head.next;        //前后焊接
        finder.pre = head;
        head.next = finder;

        return finder.value;
    }

    public void put(int key, int value) {
        if (Node.count == capaticy) {
            Node temp = head.next;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.pre.next = null;//删除最后一个元素
        } else {
            Node.count++;
        }
        Node node = new Node(key, value);
        if (head.next == null) {
            head.next = node;
            node.pre = head;
        } else {
            head.next.pre = node;
            node.next = head.next;
            node.pre = head;
            head.next = node;
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
        lru.put(4, 4);
        System.out.println( lru.get(4));
        System.out.println( lru.get(2));
        System.out.println( lru.get(3));

    }
}

class Node {
    public Node() {

    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public boolean isHeader = false;
    public int key;
    public int value;
    public static volatile int count;
    Node next;
    Node pre;
}