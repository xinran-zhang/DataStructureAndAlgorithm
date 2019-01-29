package grace.shuati;
import java.util.*;

public class MergeKSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
              this.val = val;
              this.next = null;
        }
     }


    public ListNode mergeKLists(List<ListNode> lists) {
        // add list to a priority queue
        if (lists == null || lists.size() == 0) {
            return null;
        }
        Queue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                pq.offer(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode head = pq.poll();
            tail.next = head;
            tail = head;
            if (head.next != null) {
                pq.offer(head.next);
            }
        }

        return dummy.next;
    }
}
