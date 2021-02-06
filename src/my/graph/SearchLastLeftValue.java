package my.graph;

import java.util.LinkedList;

public class SearchLastLeftValue {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

	}
	
	public int findBottomLeftValue(TreeNode root) {
		return bfs(root);
	}

	public int bfs(TreeNode node) {
		int val = 0;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.addLast(node);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.removeFirst();
				if (i == size - 1) {
					val = temp.val;
				}
				if (temp.right != null) {
					queue.addLast(temp.right);
				}
				if (temp.left != null) {
					queue.addLast(temp.left);
				}
			}

		}
		return val;
	}

}
