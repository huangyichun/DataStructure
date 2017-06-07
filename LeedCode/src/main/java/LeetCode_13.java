/**
 * A linked list is given such that each node contains an additional
 * random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class LeetCode_13 {

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null || (head.next == null && head.random == null)) {
            return head;
        }
        RandomListNode preNode = head;
        while (preNode != null) {
            RandomListNode copyNode = new RandomListNode(preNode.label);
            copyNode.next = preNode.next;
            copyNode.random = preNode.random;
            preNode.next = copyNode;
            preNode = preNode.next.next;
        }
        preNode = head.next;
        RandomListNode nextNode = head.next;
        while (nextNode != null) {
            if (nextNode.next != null) {
                nextNode.next = nextNode.next.next;
            }
            if (nextNode.random != null) {
                nextNode.random = nextNode.random.next;
            }
            nextNode = nextNode.next;
        }
        return preNode;
    }
}
