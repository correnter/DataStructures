package my.huffmantree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HuffmanCode {
	private String msg;
	private HashMap<Byte,String> huffmanMap=new HashMap<Byte,String>();
	private StringBuilder stringBuffered=new StringBuilder();
	
	public HuffmanCode(String msg) {
		this.msg=msg;
	}
	
	public HuffmanCode() {
	}
	
	public void getCodes(TreeNode node,String code,StringBuilder stringBuilder) {
		//因为传递的时候，stringBuilder指向的是同一个对象，不创建新对象，那么就会引用同一个对象。
		//下面涉及到append插入的时候，会在原来的基础上进行操作。
		StringBuilder stringBuilder2=new StringBuilder(stringBuilder); 
		if(node==null) {
			return ;
		}else {
			stringBuilder2.append(code);
			//判断是否为叶子结点
			if(node.val==null) {
				//如果不是叶子结点，继续向左递归，在向右递归。
				if(node.left!=null) {
					getCodes(node.left,"0",stringBuilder2);
				}
				if(node.right!=null) {
					getCodes(node.right,"1",stringBuilder2);
				}
				
			}else {
				//如果是叶子结点，则stringbuilder就是其对应的霍夫曼编码值。使用Map进行存储。
				huffmanMap.put(node.val, stringBuilder2.toString());
			}
		}
		
	}
	//重载方法encode
	public byte[] encode(String msg) {
		byte[] bytes=msg.getBytes();
		byte[] finalBytes=encode(bytes);
		return finalBytes;
	}
	public void decodeZipFile(String srcFile,String dstFile) {
		InputStream in=null;
		ObjectInputStream objIn=null;
		OutputStream out=null;
		try {
			//读取文件
			in=new FileInputStream(srcFile);
			objIn=new ObjectInputStream(in);
			//读取压缩后的字节数组以及霍夫曼编码表
			byte[] huffmanBytes=(byte[]) objIn.readObject();
			Map<Byte,String> huffmanMap2=(Map<Byte, String>) objIn.readObject();
			this.huffmanMap=(HashMap<Byte, String>) huffmanMap2;
			byte[] dstBytes=decode(huffmanBytes);
			out=new FileOutputStream(dstFile);
			out.write(dstBytes);
	
		} catch (Exception e) {
			System.out.println("-----"+e.getMessage());
			// TODO: handle exception
		}finally {
			try {
				out.close();
				objIn.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	public void zipFile(String srcFile,String dstFile) {
		FileInputStream in=null;
		FileOutputStream out=null;
		ObjectOutputStream objOut=null;
		try {
			//创建流
			in=new FileInputStream(srcFile);
			out=new FileOutputStream(dstFile);
			objOut=new ObjectOutputStream(out);
			//创建与源文件大小相同的字节数组
			byte[] data=new byte[in.available()];
			//将数据读取到data中
			in.read(data);
			//压缩
			byte[] dstBytes=encode(data);
			objOut.writeObject(dstBytes);
			objOut.writeObject(huffmanMap);
			//关闭io流
			in.close();
			out.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			try {
				in.close();
				out.close();
				objOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 解压方法
	 * @param encode 压缩后的字节数组
	 * @return 返回原字符串的字节数组。
	 */
	public byte[] decode(byte[] encode) {
		//将解压后的字节数组转化为二进制字符串
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<encode.length;i++) {
			boolean flag=(i==encode.length-1); 
			sb.append(byteToBitString(!flag, encode[i]));
		}
		//将霍夫曼编码表反转；
		Map<String,Byte> map=new HashMap<>();
		for(Map.Entry<Byte, String> entry: huffmanMap.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		//遍历解压后的二进制字符串 sb, 将得到的每个字节的值存入List
		System.out.println("1");
		List<Byte> resList=new ArrayList<>();
		System.out.println(sb.length());
		for(int i=0;i<sb.length();) {
			System.out.println("i="+i);
			int count=1;
			Byte b=null;
			boolean flag=true;
			while(flag) {
				String key=sb.substring(i, i+count);
			 
				b=map.get(key);
				if(b==null) {
					count++;
				}else {
					flag=false;
				}
			}
			resList.add(b);
			i=i+count;
		}
		System.out.println("2");
		//将resList转化原字符串对应的byte[]
		byte[] result=new byte[resList.size()];
		for(int i=0;i<resList.size();i++) {
			result[i]=resList.get(i);
		}
		
		return result;
		
	}
	public static String byteToBitString(boolean flag,byte b) {
		int temp=b;
		if(flag) {
			temp|=256;
		}
		String str=Integer.toBinaryString(temp);
		if(flag) {
			return str.substring(str.length()-8);
		}else {
			return str;
		}
	}
	//压缩方法
	public byte[] encode(byte[] bytes) {
		List<TreeNode> nodes=this.countNum(bytes); 
		TreeNode root=this.createHuffmanTree(nodes);
		getCodes(root, "", new StringBuilder());
		byte[] finalVal=zip(bytes);
		return finalVal;
	}
	public byte[] zip(byte[] bytes) {
		StringBuilder stringBuilder=new StringBuilder();
		//将字符串字节数组转化为霍夫曼编码。
		for(byte b: bytes) {
			stringBuilder.append(huffmanMap.get(b));
		}
		System.out.println(stringBuilder.toString());
		//计算 转化为byte 的长度，byte每8位为一组。
		int size=0;
		if(stringBuilder.length()%8==0) {
			size=stringBuilder.length()/8;
		}else {
			size=stringBuilder.length()/8 + 1;
		}
		//将stringBuilder二进制字符串转化为字节数组
		byte[] code=new byte[size];
		int index=0;
		for(int i=0;i<stringBuilder.length();i+=8) {
			String itemByte="";
			//因为stringBuilder不一定是8的整数，如果最后剩下不足8位数，则需要分别处理
			if(i+8>stringBuilder.length()) {
				 itemByte=stringBuilder.substring(i);
			}else {
				 itemByte=stringBuilder.substring(i,i+8);
			} 
			byte item=(byte)Integer.parseInt(itemByte, 2);
			code[index]=item;	
			index++;
		}
		return code;
		
	}
	
	public List<TreeNode>  countNum(byte[] bytes) {
		Map<Byte,Integer> map=new HashMap<Byte,Integer>();
		for(Byte b: bytes) {
			Integer count=map.get(b);
			if(count==null) {
				map.put(b, 1);
			}else {
				map.put(b, count+1);
			}
		}
		
		List<TreeNode> nodes=new ArrayList<TreeNode>();
		for(Map.Entry<Byte, Integer> entry : map.entrySet()) {
			TreeNode node=new TreeNode(entry.getKey(),entry.getValue());
			nodes.add(node);
		}
		 
		return nodes;
	}
	private TreeNode createHuffmanTree(List<TreeNode> nodes) {
		while(nodes.size()>1) {
			 Collections.sort(nodes);
			 
			 TreeNode leftNode=nodes.get(0);
			 TreeNode rightNode=nodes.get(1);
			 
			 TreeNode parent=new TreeNode(null,leftNode.num+rightNode.num);
			 parent.left=leftNode;
			 parent.right=rightNode;
			 
			 nodes.remove(leftNode);
			 nodes.remove(rightNode);
			 
			 nodes.add(parent);
			 
		}
		return nodes.get(0);
		
	}
	public static class TreeNode implements Comparable<TreeNode>{
		Byte val;
		int num;
		TreeNode left;
		TreeNode right;
		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", num=" + num + "]";
		}
		public TreeNode(Byte val, int num) {
			super();
			this.val = val;
			this.num = num;
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
		public int compareTo(TreeNode o) {
			// TODO Auto-generated method stub
			return this.num-o.num;
		}
	}
	
	public static void main(String[] args) {
//		String msg="i like like like java do you like a java";
		HuffmanCode code=new HuffmanCode();
//		//压缩后的字节数组
//		byte[] bytes=code.encode(msg);
//		//解压
//		byte[] deBytes=code.decode(bytes);
//		
//		System.out.println(new String(deBytes));
		//压缩
//		String src="D://src.bmp";
//		String dst="D://hello6.zip";
//		code.zipFile(src, dst);
//		System.out.println("退出...");
		String src="D://hello6.zip";
		String dst="D://sec2.bmp";
		code.decodeZipFile(src, dst);
		System.out.println("退出...");
	}
}
