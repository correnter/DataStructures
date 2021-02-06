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
		//��Ϊ���ݵ�ʱ��stringBuilderָ�����ͬһ�����󣬲������¶�����ô�ͻ�����ͬһ������
		//�����漰��append�����ʱ�򣬻���ԭ���Ļ����Ͻ��в�����
		StringBuilder stringBuilder2=new StringBuilder(stringBuilder); 
		if(node==null) {
			return ;
		}else {
			stringBuilder2.append(code);
			//�ж��Ƿ�ΪҶ�ӽ��
			if(node.val==null) {
				//�������Ҷ�ӽ�㣬��������ݹ飬�����ҵݹ顣
				if(node.left!=null) {
					getCodes(node.left,"0",stringBuilder2);
				}
				if(node.right!=null) {
					getCodes(node.right,"1",stringBuilder2);
				}
				
			}else {
				//�����Ҷ�ӽ�㣬��stringbuilder�������Ӧ�Ļ���������ֵ��ʹ��Map���д洢��
				huffmanMap.put(node.val, stringBuilder2.toString());
			}
		}
		
	}
	//���ط���encode
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
			//��ȡ�ļ�
			in=new FileInputStream(srcFile);
			objIn=new ObjectInputStream(in);
			//��ȡѹ������ֽ������Լ������������
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
			//������
			in=new FileInputStream(srcFile);
			out=new FileOutputStream(dstFile);
			objOut=new ObjectOutputStream(out);
			//������Դ�ļ���С��ͬ���ֽ�����
			byte[] data=new byte[in.available()];
			//�����ݶ�ȡ��data��
			in.read(data);
			//ѹ��
			byte[] dstBytes=encode(data);
			objOut.writeObject(dstBytes);
			objOut.writeObject(huffmanMap);
			//�ر�io��
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
	 * ��ѹ����
	 * @param encode ѹ������ֽ�����
	 * @return ����ԭ�ַ������ֽ����顣
	 */
	public byte[] decode(byte[] encode) {
		//����ѹ����ֽ�����ת��Ϊ�������ַ���
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<encode.length;i++) {
			boolean flag=(i==encode.length-1); 
			sb.append(byteToBitString(!flag, encode[i]));
		}
		//�������������ת��
		Map<String,Byte> map=new HashMap<>();
		for(Map.Entry<Byte, String> entry: huffmanMap.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		//������ѹ��Ķ������ַ��� sb, ���õ���ÿ���ֽڵ�ֵ����List
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
		//��resListת��ԭ�ַ�����Ӧ��byte[]
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
	//ѹ������
	public byte[] encode(byte[] bytes) {
		List<TreeNode> nodes=this.countNum(bytes); 
		TreeNode root=this.createHuffmanTree(nodes);
		getCodes(root, "", new StringBuilder());
		byte[] finalVal=zip(bytes);
		return finalVal;
	}
	public byte[] zip(byte[] bytes) {
		StringBuilder stringBuilder=new StringBuilder();
		//���ַ����ֽ�����ת��Ϊ���������롣
		for(byte b: bytes) {
			stringBuilder.append(huffmanMap.get(b));
		}
		System.out.println(stringBuilder.toString());
		//���� ת��Ϊbyte �ĳ��ȣ�byteÿ8λΪһ�顣
		int size=0;
		if(stringBuilder.length()%8==0) {
			size=stringBuilder.length()/8;
		}else {
			size=stringBuilder.length()/8 + 1;
		}
		//��stringBuilder�������ַ���ת��Ϊ�ֽ�����
		byte[] code=new byte[size];
		int index=0;
		for(int i=0;i<stringBuilder.length();i+=8) {
			String itemByte="";
			//��ΪstringBuilder��һ����8��������������ʣ�²���8λ��������Ҫ�ֱ���
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
//		//ѹ������ֽ�����
//		byte[] bytes=code.encode(msg);
//		//��ѹ
//		byte[] deBytes=code.decode(bytes);
//		
//		System.out.println(new String(deBytes));
		//ѹ��
//		String src="D://src.bmp";
//		String dst="D://hello6.zip";
//		code.zipFile(src, dst);
//		System.out.println("�˳�...");
		String src="D://hello6.zip";
		String dst="D://sec2.bmp";
		code.decodeZipFile(src, dst);
		System.out.println("�˳�...");
	}
}
