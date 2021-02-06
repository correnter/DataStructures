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
		//转化为稀疏数组
		int[][] sparseArr=toSparseArray(org);
		
		//存到磁盘上
		String address=saveSparseArrayToDisk(sparseArr);
		
		//可能会把该稀疏的存到磁盘上，再把地址写入数据库
		//插入数据库操作.....
		
		//从磁盘上取出来。。
		//int[][] dstSparseArr=getSparseArrayFromDisk(address);
		for (int[] row : sparseArr) { 
			for (int data : row) { 
				System.out.printf("%d\t", data); 
			}
			System.out.println();
		}
		
		//转化为二维数组
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
		System.out.println("已写入磁盘");
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
	//传输一个原来的二维数组
	private static int[][] toSparseArray(int[][] org) {
		//获取有效值以及总行数，总列数
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
		//对稀疏数组第一行进行赋值，包括有效值，总列数，总行数
		int[][] sparseArr=new int[sum+1][3];
		sparseArr[0][0]=rowCount;
		sparseArr[0][1]=colCount;
		sparseArr[0][2]=sum;
		//记录原二维数组有效值的位置。
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
