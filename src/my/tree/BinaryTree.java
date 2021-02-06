package my.tree;

public class BinaryTree {
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		TreeNode root=new TreeNode(1,"荒天帝");
		TreeNode node1=new TreeNode(2,"叶凡");
		TreeNode node2=new TreeNode(3,"无终");
		TreeNode node3=new TreeNode(4,"狠人");
		TreeNode node4=new TreeNode(5,"虚空");
		root.setLeft(node1);
		root.setRight(node2);
		node2.setLeft(node3);
		node2.setRight(node4);
		tree.setRoot(root);
	//	TreeNode result=tree.frontSearch(5);
	//	TreeNode result=tree.midSearch(4);
	//	System.out.println(result.toString());
		
		tree.frontList();
		tree.delTreeNode(5);
		tree.frontList();
		
//		tree.beforeList(root);
		
//		tree.frontList();
//		tree.midList();
//		tree.afterList();
	}
	
	private TreeNode root;
	
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	public TreeNode getRoot() {
		return root;
	}
	
//	public void beforeList(TreeNode node) {
//		if(node==null) {
//			System.out.println("二叉树为空");
//		}
//		System.out.println(node);
//		if(node.left!=null) {
//			this.beforeList(node.left);
//		}
//		if(node.right!=null) {
//			this.beforeList(node.right);
//		}
//	}
//	
	public void frontList() {
		if(root==null) {
			System.out.println("二叉树为空");
			return;
		}
		this.root.frontList();
	}
	public void midList() {
		if(root==null) {
			System.out.println("二叉树为空");
			return;
		}
		this.root.midList();
	}
	public void afterList() {
		if(root==null) {
			System.out.println("二叉树为空");
			return ;
		}
		this.root.afterList();
	}
	public TreeNode frontSearch(int id) {
		return this.root.frontSearch(id);
	}
	public TreeNode midSearch(int id) {
		return this.root.midSearch(id);
	}
	public TreeNode afterSearch(int id) {
		return this.root.afterSearch(id);
	}
	public void delTreeNode(int id) {
		if(this.root==null) {
			System.out.println("二叉树为空");
			return;
		}
		
		if(this.root.id==id) {
			this.root=null;
			return;
		}else {
			this.root.delTreeNode(id);
		}
		
	}
	public static class TreeNode{
		private int id;
		private String name;
		private TreeNode left;
		private TreeNode right;
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
		@Override
		public String toString() {
			return "TreeNode [id=" + id + ", name=" + name + "]";
		}
		
	}
}
