package my.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 

public class HuffmanTree {
	private TreeNode root; 
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	public  TreeNode createHuffmanTree(int[] arr) {
		List<TreeNode> tree=new ArrayList<TreeNode>();
		for(int i=0;i<arr.length;i++) {
			tree.add(new TreeNode(arr[i]));
		}
		Collections.sort(tree);
		while(tree.size()>1) {
			TreeNode leftNode=tree.get(0);
			TreeNode rightNode=tree.get(1);
			
			TreeNode root=new TreeNode(leftNode.val+rightNode.val);
			root.left=leftNode;
			root.right=rightNode;
			
			tree.remove(leftNode);
			tree.remove(rightNode);
			tree.add(root);
			Collections.sort(tree);
			
		}
		this.root=tree.get(0);
		return tree.get(0);
		
	}
	public void preOrder() {
		if(this.root==null) {
			System.out.println("树为空，无法遍历");
		}
		this.preOrder(root);
	}
	public void preOrder(TreeNode node) {
		System.out.println(node);
		if(node.left!=null) {
			this.preOrder(node.left);
		}
		if(node.right!=null) {
			this.preOrder(node.right);
		}
		
	}
	
	public  void frontList(TreeNode node) {
		if(node!=null) {
			node.frontList();
		}else {
			System.out.println("树为空");
		}
	}
	public static class TreeNode implements Comparable<TreeNode>{
		public int val;
		public TreeNode left; 
		public TreeNode right;
		public TreeNode(int val) { 
			this.val = val;
		}
		public void frontList() {
			System.out.println(this);
			if(this.left!=null) {
				this.left.frontList();
			}
			if(this.right!=null) {
				this.right.frontList();
			}
		}
		@Override
		public String toString() {
			return "TreeNode [val=" + val + "]";
		}
		@Override
		public int compareTo(TreeNode o) {
			// TODO Auto-generated method stub
			return this.val-o.val;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {
				13, 7, 8, 3, 29, 6, 1
		};
		HuffmanTree tree=new HuffmanTree();
		tree.createHuffmanTree(arr);  
		tree.preOrder();
	}
}
