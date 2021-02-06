package my.binarysorttree;

public class BinarySortTree {
	public static void main(String[] args) {
		int[] arr= {
				7,3,10,12,5,1,9,2
		};
		
		BinarySortTree tree=new BinarySortTree();
		tree.insert(arr);
		tree.midOrder(); 
		System.out.println("--------------------------------");
		tree.delete(7);
		tree.delete(3);
		tree.delete(10);
		tree.delete(12);
		tree.delete(5);
		tree.delete(1);
		tree.delete(9);
		tree.delete(2);
		tree.midOrder();
	}
	private TreeNode root =null;
	/**
	 * 删除右子树的最小节点
	 * @param node 右子树的根节点
	 * @return 右子树最小值的结点。
	 */
	public int delMinRightNode(TreeNode node) {
		TreeNode temp=node;
		while(temp.left!=null) {
			temp=temp.left;
		}
		delete(temp.val);
		return temp.val;
	}
	/**
	 * 删除左子树的最大节点
	 * @param node 左子树的根节点
	 * @return 返回左子树的最大值结点。
	 */
	public int delMaxLeftNode(TreeNode node) {
		TreeNode temp=node;
		while(temp.right!=null) {
			temp=temp.right;
		}
		delete(temp.val);
		return temp.val;
	}
	public void delete(int val) {
		if(root==null) {
			return ;
		}
		TreeNode parent=searchParent(val);
		TreeNode targetNode=search(val);
		
		if(targetNode.left==null && targetNode.right==null) {
			if(parent!=null) {
				if(parent.left!=null && parent.left.val==val) {
					parent.left=null;
				}else if(parent.right!=null &&parent.right.val==val) {
					parent.right=null;
				}	
			}else {
				this.midOrder();
				root=null;
			}

		}else if(targetNode.left!=null && targetNode.right!=null) { 
			//这里采用的是删除右子树的最小节点
			
			int minVal=this.delMinRightNode(targetNode.right);
			targetNode.val=minVal;
			//这里是左子树的最大节点
			//int maxVal=this.delMaxLeftNode(targetNode.left);
			//targetNode.val=maxVal;
		}else {
			if(targetNode.left!=null) {
				if(parent!=null) {
					if(parent.left!=null && parent.left.val==val) {
						parent.left=targetNode.left;
					}else if(parent.right!=null && parent.right.val==val){
						parent.right=targetNode.right;
					}
				}else {
					parent=targetNode;
				}
		
			}else {
				if(parent!=null) {
					if(parent.left!=null && parent.left.val==val) {
						parent.left=targetNode.left;
					}else if(parent.right!=null && parent.right.val==val) {
						parent.right=targetNode.right;
					}
				}else {
					parent=targetNode;
				}
			
			}
		}
	}
	public TreeNode search(int val) {
		if(root==null) {
			return null;
		}  
		return this.root.search(val);
	}
	public TreeNode searchParent(int val) {
		if(root==null) {
			return null;
		}
		return this.root.searchParent(val);
	}
	public void insert(int[] arr) {
		for(int data : arr) {
			this.insert(new TreeNode(data));
		}
	}
	public void insert(TreeNode node) {
		if(root==null) {
			root=node;
			return;
		}
		this.root.insert(node);
	}
	public void midOrder() {
		if(root==null) {
			System.out.println("二叉树为空");
			return;
		}
		this.root.midOrder();
	}
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			super();
			this.val = val;
		}
		public void insert(TreeNode node) {
			if(node==null) {
				return;
			}
			if(this.val>node.val) {
				if(this.left==null) {
					this.left=node;
				}else {
					this.left.insert(node);
				}
			}else {
				if(this.right==null) {
					this.right=node;
				}else {
					this.right.insert(node);
				}
			}
		}
		public TreeNode search(int val) {
			 if(this.val==val) {
				 return this;
			 }
			 else if(this.val>val) {
				 if(this.left!=null) {
					 return this.left.search(val);
				 }else {
					 return null;
				 }
			 }else {
				 if(this.right!=null) {
					 return this.right.search(val);
				 }else {
					 return null;
				 }
			 }
			
		}
		public TreeNode searchParent(int val) {
			if((this.left!=null && this.left.val==val) || (this.right!=null && this.right.val==val)) {
				return this;
			}else {
				if(this.left!=null && this.val>val) {
					return this.left.searchParent(val);
				}else if(this.right!=null && this.val<=val) {
					return this.right.searchParent(val);
				}
			}
			return null;
		}
		public void midOrder() {
			if(this.left!=null) {
				this.left.midOrder();
			}
			System.out.println(this);
			
			if(this.right!=null) {
				this.right.midOrder();
			}
		}
		@Override
		public String toString() {
			return "TreeNode [val=" + val + "]";
		}
		
	}
}
