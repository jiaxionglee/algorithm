package linklist;

import java.util.Objects;

/**
 * @author jiaxiong
 * @date 2019-03-28 10:44
 */
public class ListNode {

    /**
     * 数据域
     */
    public int val;
    /**
     * 指针域
     */
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return next.equals(listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next);
    }
}
