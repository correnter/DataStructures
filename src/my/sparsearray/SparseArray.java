package my.sparsearray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class SparseArray {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[][] org=new int[11][11];
		org[1][2]=1;
		org[2][3]=2;
		//ת��Ϊϡ������
		int[][] sparseArr=toSparseArray(org);
		
		//�浽������
		String address=saveSparseArrayToDisk(sparseArr);
		
		//���ܻ�Ѹ�ϡ��Ĵ浽�����ϣ��ٰѵ�ַд�����ݿ�
		//�������ݿ����.....
		
		//�Ӵ�����ȡ��������
		//int[][] dstSparseArr=getSparseArrayFromDisk(address);
		for (int[] row : sparseArr) { 
			for (int data : row) { 
				System.out.printf("%d\t", data); 
			}
			System.out.println();
		}
		
		//ת��Ϊ��ά����
		int[][] dst=toCommonArray(sparseArr);
		

	}
//	private static int[][] getSparseArrayFromDisk(String address) throws Exception {
//		InputStream in=new FileInputStream(address);
//		byte[] data=new byte[8092];
//		in.read(data);
//		String jsonStr=new String(data);
//		System.out.println(jsonStr);
//		JSONObject jobj=JSONObject.parseObject(jsonStr);
//		System.out.println(jobj.toString());
//		JSONArray dst=jobj.getJSONArray("sparseArr");
//		return (int[][]) dst.toArray();
//	}
	private static String saveSparseArrayToDisk(int[][] sparseArr) throws Exception {
	
		File diskFile=
				new File("E:\\tmp\\map.json");
		
		JSONObject json=new JSONObject();
		json.put("sparseArr", sparseArr); 
		
		OutputStream out=new FileOutputStream(diskFile);
		out.write(json.toString().getBytes());
		System.out.println("��д�����");
		out.close();
		return diskFile.getAbsolutePath();
	}
	private static int[][] toCommonArray(int[][] sparseArr) {
		int[][] dst=new int[sparseArr[0][0]][sparseArr[0][1]];
		for(int i=1;i<sparseArr[0][2]+1;i++) {
			dst[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
		}
		return dst;
	}
	//����һ��ԭ���Ķ�ά����
	private static int[][] toSparseArray(int[][] org) {
		//��ȡ��Чֵ�Լ���������������
		int sum=0;
		int rowCount=0;
		int colCount=0;
		for(int[] row : org) {
			rowCount++;
			for(int data : row) {
				if(data!=0) {
					sum++;
				}
			}
			colCount++;
		} 
		//��ϡ�������һ�н��и�ֵ��������Чֵ����������������
		int[][] sparseArr=new int[sum+1][3];
		sparseArr[0][0]=rowCount;
		sparseArr[0][1]=colCount;
		sparseArr[0][2]=sum;
		//��¼ԭ��ά������Чֵ��λ�á�
		int valCount=0;
		for(int i=0;i<rowCount;i++)
			for(int j=0;j<colCount;j++) {
				if(org[i][j]!=0) {
					valCount++;
					sparseArr[valCount][0]=i;
					sparseArr[valCount][1]=j;
					sparseArr[valCount][2]=org[i][j];
				}
			} 
		return sparseArr;
	}

}
