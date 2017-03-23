package Leetcode;

import java.util.*;

/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Jan 13, 2015
 Problem:    Clone Graph
 Difficulty: Medium
 Source:     http://oj.leetcode.com/problems/clone-graph/
 Notes:
 Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

 OJ's undirected graph serialization:
 Nodes are labeled from 0 to N - 1, where N is the total nodes in the graph.
 We use # as a separator for each node, and , as a separator for each neighbor of the node.
 As an example, consider the serialized graph {1,2#2#2}.
 The graph has a total of three nodes, and therefore contains three parts as separated by #.
 Connect node 0 to both nodes 1 and 2.
 Connect node 1 to node 2.
 Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:
 1
 / \
 /   \
 0 --- 2
 / \
 \_/
 Solution: 1. DFS. 2. BFS.
 */
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}

public class CloneGraph {
	public static void main(String[] args) {
		UndirectedGraphNode newnode1 = new UndirectedGraphNode(1);
		UndirectedGraphNode newnode0 = new UndirectedGraphNode(0);
		UndirectedGraphNode newnode2 = new UndirectedGraphNode(2);
		newnode0.neighbors.add(newnode2);
		newnode0.neighbors.add(newnode1);
		newnode1.neighbors.add(newnode2);
		newnode2.neighbors.add(newnode2);

		cloneGraph_1(newnode0);

	}

	public static UndirectedGraphNode cloneGraph_1(UndirectedGraphNode node) {
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		return cloneGraphRe(node, map);
	}

	public static UndirectedGraphNode cloneGraphRe(UndirectedGraphNode node,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (node == null)
			return null;
		if (map.containsKey(node))
			return map.get(node);
		UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
		map.put(node, newnode);
		for (UndirectedGraphNode cur : node.neighbors) {
			newnode.neighbors.add(cloneGraphRe(cur, map));
		}
		return newnode;
	}

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		if (node == null)
			return null;
		queue.offer(node);
		map.put(node, new UndirectedGraphNode(node.label));
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			for (UndirectedGraphNode neighbor : cur.neighbors) {
				if (map.containsKey(neighbor) == false) {
					UndirectedGraphNode newnode = new UndirectedGraphNode(neighbor.label);
					map.put(neighbor, newnode);
					queue.offer(neighbor);
				}
				map.get(cur).neighbors.add(map.get(neighbor));
			}
		}
		return map.get(node);
	}


}
