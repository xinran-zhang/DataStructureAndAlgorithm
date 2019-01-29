package grace.shuati;

public class Rehashing {
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
    }
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable.length <= 0) {
            return null;
        }
        int newCap = hashTable.length * 2;
        ListNode[] newHash = new ListNode[newCap];
        for (int i = 0; i < hashTable.length; i++) {
            while (hashTable[i] != null) {
                int newIndex = (hashTable[i].val % newCap + newCap) % newCap;
                if (newHash[newIndex] == null) {
                    newHash[newIndex] = new ListNode(hashTable[i].val);
                } else {
                    ListNode dummy = newHash[newIndex];
                    while (dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        return newHash;
    }
}
