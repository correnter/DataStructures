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
		System.out.println("�������ĸ߶�"+tree.leftHeight());
		System.out.println("�������ĸ߶�"+tree.rightHeight());
		System.out.println("���ĸ߶�"+tree.height());
	}
	private AVLTreeNode root =null;
	/**
	 * ɾ������������С�ڵ�
	 * @param node �������ĸ��ڵ�
	 * @return ��������Сֵ�Ľ�㡣
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
	 * ɾ�������������ڵ�
	 * @param node �������ĸ��ڵ�
	 * @return ���������������ֵ��㡣
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
			//������õ���ɾ������������С�ڵ�
			
			int minVal=this.delMinRightNode(targetNode.right);
			targetNode.val=minVal;
			//�����������������ڵ�
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
			System.out.println("������Ϊ��");
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
		//������һ�����ĸ��ڵ㡣
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
			//�ҵ����һ�㣬�䷵��ֵΪ1��Ȼ���㷵�أ�ÿ��+1��
			return Math.max(this.left==null? 0 : this.left.height(), this.right==null? 0 : this.right.height())+1;
		}
		public void leftRotate() {
			//����һ���µĽ�㣬����ֵΪ��ǰ��㡣
			AVLTreeNode newNode=new AVLTreeNode(this.val);
			//���½ڵ�����ӽڵ�����Ϊ��ǰ�������ӽڵ�
			newNode.left=this.left;
			if(this.right!=null) {
				//���½ڵ�����ӽڵ�����Ϊ��ǰ�������ӽڵ�����ӽڵ�
				newNode.right=this.right.left;
				//����ǰ����ֵ����Ϊ��ǰ�������ӽڵ��ֵ
				this.val=this.right.val; 
				//����ǰ�������ӽڵ�����Ϊ��ǰ�������ӽڵ�����ӽڵ�
				this.right=this.right.right;
			}    
			//����ǰ�������ӽڵ�����Ϊ�½ڵ㡣
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
