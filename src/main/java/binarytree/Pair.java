package binarytree;

/**
 * Created by jiaxiong on 2019-03-28 19:27
 */
public class Pair {
    int height;                // 树的高度
    boolean isFull;        // 是否是个满树

    public Pair(int height, boolean isFull) {
        this.height = height;
        this.isFull = isFull;
    }

    public boolean equalsTo(Pair obj) {
        return this.height == obj.height && this.isFull == obj.isFull;
    }
}
