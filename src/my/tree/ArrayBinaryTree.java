package my.tree;

public class ArrayBinaryTree {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7};
		ArrayBinaryTree tree=new ArrayBinaryTree(arr);
		tree.afterList();
		
	}
	private int[] arr;
	public ArrayBinaryTree(int[] arr) { 
		this.arr = arr;
	}
	public void setArr(int[] arr) {
		this.arr = arr;
	}
	public ArrayBinaryTree(int size) {
		this.arr=new int[size];
	}
	public void frontList(int[] arr) {
		this.setArr(arr);
		this.frontList();
	}
	public void midList(int[] arr) {
		this.setArr(arr);
		this.midList();
	}
	public void afterList(int[] arr) {
		this.setArr(arr);
		this.afterList();
	}
	public void frontList() {
		this.frontList(0);
	}
	public void midList() {
		this.midList(0);
	}
	public void afterList() {
		this.afterList(0);
	}
	//Ë³Ðò¶þ²æÊ÷µÄÇ°Ðò±éÀú
	public void frontList(int index) {
		if(arr==null  || arr.length==0) {
			System.out.println("Ë³Ðò¶þ²æÊ÷Îª¿Õ");
		}
		System.out.println(this.arr[index]);
		if(2*index+1 < arr.length) {
			this.frontList(2*index+1);
		}
		if(2*index+2 < arr.length) {
			this.frontList(2*index+2);
		}
	}
	public void midList(int index) {
		if(arr==null  || arr.length==0) {
			System.out.println("Ë³Ðò¶þ²æÊ÷Îª¿Õ");
		}
		if(2*index+1 < arr.length) {
			this.frontList(2*index+1);
		}
		System.out.println(this.arr[index]);
		if(2*index+2 < arr.length) {
			this.frontList(2*index+2);
		}
	}
	public void afterList(int index) {
		if(arr==null  || arr.length==0) {
			System.out.println("Ë³Ðò¶þ²æÊ÷Îª¿Õ");
		}
		if(2*index+1 < arr.length) {
			this.frontList(2*index+1);
		}
		if(2*index+2 < arr.length) {
			this.frontList(2*index+2);
		}
		System.out.println(this.arr[index]);
	}
}
