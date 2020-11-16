package BinaryHeap;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :
 * @url :
 * @create :2020-11-15
 */

/**
 * 一个优先级队列就实现了，插入和删除元素的时间复杂度为 O(logK)，
 * K 为当前二叉堆（优先级队列）中的元素总数。因为我们时间复杂度主
 * 要花费在 sink 或者 swim 上，而不管上浮还是下沉，最多也就树
 * （堆）的高度，也就是 log 级别。
 * @param <Key>
 */
public class MaxPQ<Key extends  Comparable<Key>> {
    /**
     * 父节点的索引
     */
    int parent(int root) {
        return root / 2;
    }
    /**
     * 左孩子的索引
     */
    int left(int root) {
        return root * 2;
    }
    /**
     *  右孩子的索引
    */
    int right(int root) {
        return root * 2 + 1;
    }
    /**
     * 存储元素的数组
     */
    private Key[] pq;
    /**
     * 当前 Priority Queue 中的元素个数
     */
    private int N = 0;
    public MaxPQ ( int cap) {
        // 索引 0 不用，所以多分配一个空间
        pq = (Key[]) new Comparable[cap + 1];
    }
    /* 返回当前队列中最大元素 */
    public Key max() {
        return pq[1];
    }

    /**
     * 如果某个节点 A 比它的子节点（中的一个）小，那么 A 就不
     * 配做父节点，应该下去，下面那个更大的节点上来做父节点，这就是对 A 进行下沉。
     * 如果某个节点 A 比它的父节点大，那么 A 不应该做子节点，
     * 应该把父节点换下来，自己去做父节点，这就是对 A 的上浮。
     * @param k 上浮k，以维护最大堆
     */
    private void swim(int k) {
        // 如果浮到堆顶，就不能再上浮了
        while (k > 1 && less(parent(k), k)) {
            // 如果第 k 个元素比上层大
            // 将 k 换上去
            exch(parent(k), k);
            k = parent(k);
        }
    }

    /**
     * 插入的元素添加到堆底的最后，然后让其上浮到正确位置
     * @param e 插入元素e
     */
    public void insert(Key e) {
        N++;
        // 先把新元素加到最后
        pq[N] = e;
        // 然后让它上浮到正确的位置
        swim(N);
    }

    /**
     * 方法先把堆顶元素 A 和堆底最后的元素 B 对调，然后删除 A，最后让 B 下沉到正确位置。
     * 删除并返回当前队列中最大元素
     */
    public Key delMax() {
// 最大堆的堆顶就是最大元素
        Key max = pq[1];
        // 把这个最大元素换到最后，删除之
        exch(1, N);
        pq[N] = null;
        N--;
        // 让 pq[1] 下沉到正确位置
        sink(1);
        return max;
    }


    /**
     *
     * @param k 下沉第 k 个元素，以维护最大堆性质
     */
    private void sink(int k) {
        // 如果沉到堆底，就沉不下去了
        while (left(k) <= N) {
            // 先假设左边节点较大
            int older = left(k);
            // 如果右边节点存在，比一下大小
            if (right(k) <= N && less(older, right(k)))
                older = right(k);
            // 结点 k 比俩孩子都大，就不必下沉了
            if (less(older, k)) break;
            // 否则，不符合最大堆的结构，下沉 k 结点
            exch(k, older);
            k = older;
        }
    }

    /**
    * 交换数组的两个元素
    */
    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * pq[i] 是否比 pq[j] 小？
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /* 还有 left, right, parent 三个方法 */
}
