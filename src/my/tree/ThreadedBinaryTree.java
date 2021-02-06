package my.tree;

import my.tree.BinaryTree.TreeNode;

public class ThreadedBinaryTree {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1,"荒天帝");
		TreeNode node1=new TreeNode(2,"叶凡");
		TreeNode node2=new TreeNode(3,"无终");
		TreeNode node3=new TreeNode(4,"狠人");
		TreeNode node4=new TreeNode(5,"虚空");
		root.setLeft(node1);
		root.setRight(node2);
		node2.setLeft(node3);
		node2.setRight(node4);
		ThreadedBinaryTree tree=new ThreadedBinaryTree(root);
		tree.threadedTree();
		System.out.println("-------------------------");
		tree.midThreadedList();
		System.out.println("-------------------------2"); 
	}
	private TreeNode root;
	private TreeNode pre;
	public ThreadedBinaryTree(TreeNode root) { 
		this.root = root;
	}
	public void threadedTree() {
		this.threadedTree(root);
	}
	public void threadedTree(TreeNode node) {
		if(node==null) {
			return ;
		}
		this.threadedTree(node.getLeft());
		System.out.println(node);
		if(node.getLeft()==null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		if(pre!=null && pre.getRight()==null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		pre=node;
		
		this.threadedTree(node.getRight());
	}
	public void midThreadedList() {
		TreeNode node=root;
		while(node!=null) {
			//找到leftTpye=0的结点，
			while(node.getLeftType()==0) {
				node=node.getLeft();
			}
			//遍历完之后，打印该节点。
			System.out.println(node);
			while(node.getRightType()==1) {
				node=node.getRight();
				System.out.println(node);
			}
			node=node.getRight();
			
		}
	}
	public void frontThreadedTree(TreeNode node) {
		if(node==null) {
			return;
		}
		if(node.getLeft()==null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		if(pre!=null && pre.getRight()==null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		pre=node;
		
		this.frontThreadedTree(node.getLeft());
		this.frontThreadedTree(node.getRight());
	}
	public static class TreeNode{
		private int id;
		private String name;
		private TreeNode left;
		private TreeNode right;
		private int leftType;
		private int rightType;
		public TreeNode(int id, String name) { 
			this.id = id;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public TreeNode getLeft() {
			return left;
		}
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		public TreeNode getRight() {
			return right;
		}
		public void setRight(TreeNode right) {
			this.right = right;
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
		public void midList() {
			if(this.left!=null) {
				this.left.midList();
			}
			System.out.println(this);
			if(this.right!=null) {
				this.right.midList();
			}
		}
	 
		public void afterList() {
			if(this.left!=null) {
				this.left.midList();
			}
			if(this.right!=null) {
				this.right.midList();
			}
			System.out.println(this);
		}
		public TreeNode frontSearch(int id) {
			System.out.println("前序查找");
			if(this.id==id) {
				return this;
			}
			TreeNode node=null;
			if(this.left!=null) {
				node=this.left.frontSearch(id);
			}
			if(node!=null) {
				return node;
			}
			if(this.right!=null) {
				node=this.right.frontSearch(id);
			}
			return node;
		}
		public TreeNode midSearch(int id) {
		
			TreeNode node=null;
			if(this.left!=null) {
				node=this.left.midSearch(id);
			}
			if(node!=null) {
				return node;
			}
			System.out.println("中序遍历");
			if(this.id==id) {
				return this;
			}
			if(this.right!=null) {
				node=this.right.midSearch(id);
			}
			return node;
		}
		public TreeNode afterSearch(int id) {
			TreeNode node=null;
			if(this.left!=null) {
				node=this.left.afterSearch(id);
			}
			if(node!=null) {
				return node;
			}
			if(this.right!=null) {
				node=this.right.afterSearch(id);
			}
			if(node!=null) {
				return node;
			}
			if(this.id==id) {
				return this;
			}
			return node;
		}
		public void delTreeNode(int id) {
			if(this.left!=null && this.left.id==id) {
				this.left=null;
				return;
			}
			if(this.right!=null && this.right.id==id) {
				this.right=null;
				return;
			}
			if(this.left!=null) {
				this.left.delTreeNode(id);
			}
			if(this.right!=null) {
				this.right.delTreeNode(id);
			}
		}
		public boolean delNode(int id) { 
			if(this.left!=null && this.left.id==id) {
				this.left=null; 
				return true;
			}
			if(this.right!=null && this.right.id==id) {
				this.right=null;
				return true;
			}
			if(this.left!=null) {
				boolean temp=this.left.delNode(id);
				if(temp) {
					return true;
				}
			}
			if(this.right!=null) {
				boolean temp=this.right.delNode(id);
				if(temp) {
					return true;
				}
			}
			return false;
		}
		
		public int getLeftType() {
			return leftType;
		}
		public void setLeftType(int leftType) {
			this.leftType = leftType;
		}
		public int getRightType() {
			return rightType;
		}
		public void setRightType(int rightType) {
			this.rightType = rightType;
		}
		@Override
		public String toString() {
			return "TreeNode [id=" + id + ", name=" + name + "]";
		}
		
	}
}
