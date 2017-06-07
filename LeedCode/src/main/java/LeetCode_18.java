import java.util.HashMap;
import java.util.LinkedList;

/**
 * Clone an undirected graph.
 * Each node in the graph contains alabeland a list of itsneighbors.
 */
public class LeetCode_18 {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node, head);
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode neighborWaitCopy = queue.poll();
            for(UndirectedGraphNode waitCopyNode : neighborWaitCopy.neighbors) {
                if(!map.containsKey(waitCopyNode)) { //判断该节点是否遍历过
                    UndirectedGraphNode copyNode = new UndirectedGraphNode(waitCopyNode.label);
                    map.put(waitCopyNode, copyNode);
                    queue.offer(waitCopyNode);
                }
                map.get(neighborWaitCopy).neighbors.add(map.get(waitCopyNode));
            }
        }
        return head;
    }
}
