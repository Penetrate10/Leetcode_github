package Other_Data_Structures;
import java.util.HashMap;
/*
题目：实现一个LRU，完成要求的API
思路：要让 put 和 get 方法的时间复杂度为 O(1)，我们可以总结出 cache 这个数据结构必要的条件：
     1、显然 cache 中的元素必须有时序，以区分最近使用的和久未使用的数据，当容量满了之后要删除最久未使用的那个元素腾位置。
     2、我们要在 cache 中快速找某个 key 是否已存在并得到对应的 val；
     3、每次访问 cache 中的某个 key，需要将这个元素变为最近使用的，也就是说 cache 要支持在任意位置快速插入和删除元素。

     所以，需要使用LinkedHashMap，或自己写一个双向链表+使用HashMap。
     LRU 算法的核心数据结构是使用哈希链表 LinkedHashMap，首先借助链表的有序性使得链表元素维持插入顺序，同时借助哈希映射的快速访问能力使得我们可以在 O(1) 时间访问链表的任意元素。

     借助这个结构，我们来逐一分析上面的 3 个条件：
     1、如果我们每次默认从链表尾部添加元素，那么显然越靠尾部的元素就是最近使用的，越靠头部的元素就是最久未使用的。
     2、对于某一个 key，我们可以通过哈希表快速定位到链表中的节点，从而取得对应 val。
     3、链表显然是支持在任意位置快速插入和删除的，改改指针就行。只不过传统的链表无法按照索引快速访问某一个位置的元素，而这里借助哈希表，可以通过 key 快速映射到任意一个链表节点，然后进行插入和删除。

     详见：https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-daeca/suan-fa-ji-8674e/


     写LRU代码需要注意的三个技巧：
     1、不要企图上来就实现算法的所有细节，而应该自顶向下，逐步求精，先写清楚主函数的逻辑框架，然后再一步步实现细节。
     2、搞清楚映射关系，如果我们更新了某个key对应的value，那么就要同步修改map和cache，这样才不会出问题。
     3、画图！画图！画图！重要的话说三遍，把逻辑比较复杂的部分用流程图画出来，然后根据图来写代码，可以极大减少出错的概率。
*/

// 主类
class LRUCache {
    private int capacity;

    // key -> Node(key, val)
    private HashMap<Integer, Node> map;  // map存Node，而不是存value。因为后面对链表的操作需要直接定位node的地址，这个地址需要检索map获得，这样才能满足O(1)

    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    /* get和put 为顶层API，是题目要求完成的 */
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        // 将该条数据提升为最近使用的
        makeRecently(key);

        return map.get(key).value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){  // 如果已存在
            // 更新 value
            replace(key, value);
            return;
        }

        // 如果不存在
        if(capacity == cache.size()) {  // 如果已满
            // 删除最久未使用的元素
            removeLeastRecently();
        }
        // 添加为最近使用的元素
        addRecently(key, value);
    }


    /* 中层API。让上层API调用中层API，避免错误调用底层API，或直接调用底层API做一些不好的事。尽量让 LRU 的主方法 get 和 put 避免直接操作 map 和 cache 的细节。*/
    /* 中层API都是 private */
    // 将某个 key 提升为最近使用的
    private void makeRecently(int key) {
        Node n = map.get(key);
        cache.remove(n);
        cache.addLast(n);
    }

    // 更新已有元素的 value (这个API可以被下面的 delete + addRecently 替换)
    private void replace(int key, int value) {
        Node n = map.get(key);
        cache.remove(n);

        Node newNode = new Node(key, value);
        cache.addLast(newNode);
        map.put(key, newNode);
    }

    // 添加最近使用的元素
    private void addRecently(int key, int value) {
        Node newNode = new Node(key, value);
        cache.addLast(newNode);
        map.put(key, newNode);
    }

    // 删除某一个 key
    private void delete(int key) {
        Node n = map.get(key);
        cache.remove(n);
        map.remove(key);
    }

    // 删除最久未使用的元素
    private void removeLeastRecently() {
        Node n = cache.removeFirst();
        if(n != null) {
            int key = n.key;
            map.remove(key);
        }
    }


}

/* 不使用LinkedHashMap，自己写一个双向链表。 */
// 自定义的Node
class Node {
    public int key;
    public int value;
    public Node prev;
    public Node next;
    public Node (int key, int value) {
        this.key = key;
        this.value = value;
    }
}

// 自定义的双向链表，及其API（这里的API是底层API）
class DoubleList {
    // 头尾虚节点
    private Node head;
    private Node tail;

    // 链表元素数
    private int size;

    public DoubleList() {  // 初始化双向链表
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表尾部添加节点 n，时间 O(1)
    public void addLast(Node n) {
        n.prev = tail.prev;
        n.next = tail;
        tail.prev.next = n;
        tail.prev = n;
        size++;
    }

    // 删除链表中的 n 节点（n 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.prev = null;
        n.next = null;
        size--;
    }

    // 删除链表中第一个节点，并返回该节点，时间 O(1)
    public Node removeFirst() {
        if(head.next == tail) {
            return null;
        }

        Node n = head.next;
        remove(n);
        return n;
    }

    // 返回链表长度，时间 O(1)
    public int size() {
        return size;
    }
}
