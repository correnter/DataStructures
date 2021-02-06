package my.avltree;



public class AVLTree {
	public static void main(String[] args) {
		AVLTree tree=new AVLTree();
		int[] arr= {
				10,12,8,9,7,6
		};
		tree.insert(arr);
		tree.midOrder(); 
		System.out.println("--------------------------------");
		System.out.println("左子树的高度"+tree.leftHeight());
		System.out.println("右子树的高度"+tree.rightHeight());
		System.out.println("树的高度"+tree.height());
	}
	private AVLTreeNode root =null;
	/**
	 * 删除右子树的最小节点
	 * @param node 右子树的根节点
	 * @return 右子树最小值的结点。
	 */
	public int delMinRightNode(AVLTreeNode node) {
		AVLTreeNode temp=node;
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
	public int delMaxLeftNode(AVLTreeNode node) {
		AVLTreeNode temp=node;
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
		AVLTreeNode parent=searchParent(val);
		AVLTreeNode targetNode=search(val);
		
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
	public AVLTreeNode search(int val) {
		if(root==null) {
			return null;
		}  
		return this.root.search(val);
	}
	public AVLTreeNode searchParent(int val) {
		if(root==null) {
			return null;
		}
		return this.root.searchParent(val);
	}
	public void insert(int[] arr) {
		for(int data : arr) {
			this.insert(new AVLTreeNode(data));
		}
	}
	public void insert(AVLTreeNode node) {
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
	public int leftHeight() {
		if(root==null) {
			return 0;
		}
		return this.root.leftHeight(root);
	}
	public int rightHeight() {
		if(root==null) {
			return 0;
		}
		return this.root.rightHeight(root);
	}
	public int height() {
		if(root==null) {
			return 0;
		}
		return this.root.height();
	}
	public static class AVLTreeNode{
		int val;
		AVLTreeNode left;
		AVLTreeNode right;
		public AVLTreeNode(int val) { 
			this.val = val;
		}
		//传过来一科树的根节点。
		public int leftHeight(AVLTreeNode node) {
			if(node.left==null) {
				return 0;
			}
			return this.left.height();
		}
		public int rightHeight(AVLTreeNode node) {
			if(node.right==null) {
				return 0;
			}
			return this.right.height();
		}
		
		public int height() {
			//找到最后一层，其返回值为1，然后层层返回，每层+1；
			return Math.max(this.left==null? 0 : this.left.height(), this.right==null? 0 : this.right.height())+1;
		}
		public void leftRotate() {
			//创建一个新的结点，结点的值为当前结点。
			AVLTreeNode newNode=new AVLTreeNode(this.val);
			//将新节点的左子节点设置为当前结点的左子节点
			newNode.left=this.left;
			if(this.right!=null) {
				//将新节点的右子节点设置为当前结点的右子节点的左子节点
				newNode.right=this.right.left;
				//将当前结点的值设置为当前结点的右子节点的值
				this.val=this.right.val; 
				//将当前结点的右子节点设置为当前结点的右子节点的右子节点
				this.right=this.right.right;
			}    
			//将当前结点的左子节点设置为新节点。
			this.left=newNode;
		}
		public void rightRotate() {
			AVLTreeNode newNode=new AVLTreeNode(this.val);
			newNode.right=this.right;
			newNode.left=this.left.right;
			this.val=this.left.val;
			this.left=this.left.left;
			this.right=newNode;
		}
		public void insert(AVLTreeNode node) {
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
			
			if(this.rightHeight(this)-this.leftHeight(this) > 1) {
				if(this.right!=null &&  this.right.leftHeight(this.right) >this.right.rightHeight(this.right)) {
					this.rightRotate();
				}
				this.leftRotate();
				return ;
			}
			if(this.leftHeight(this)- this.rightHeight(this) > 1) {
				if(this.left!=null && this.left.rightHeight(this.left) > this.left.leftHeight(this.left)) {
					this.leftRotate();
				}
				this.rightRotate();
				
			}
		}
		public AVLTreeNode search(int val) {
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
		public AVLTreeNode searchParent(int val) {
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
			return "AVLTreeNode [val=" + val + "]";
		}
	}
}
