package binarytree;

/**
 * @author jiaxiong
 * @date 2019-03-28 19:27
 */
public class Pair {
    /**
     * 树的高度
     */
    int height;
    /**
     * 是否是个满树
     */
    boolean isFull;

    public Pair(int height, boolean isFull) {
        this.height = height;
        this.isFull = isFull;
    }

    public boolean equalsTo(Pair obj) {
        return this.height == obj.height && this.isFull == obj.isFull;
    }
}
