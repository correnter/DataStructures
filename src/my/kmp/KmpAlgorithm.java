package my.kmp;

import java.util.Arrays;

public class KmpAlgorithm {
	public static void main(String[] args) {
//		String str1 = "πËπËπ» …–πËπ»ƒ„…–πË …–πËπ»ƒ„…–πËπ»ƒ„…–πËƒ„∫√";
//		String str2 = "…–πËπ»ƒ„…–πËƒ„";
//		int index = violenceMatch(str1, str2);
//		System.out.println("index=" + index);
//		String str1 = "BBC ABCDAB ABCDABCDABDE";
//		String str2 = "ABCDABA"; 
		// String str2 = "BBC"; 
//		int[] next = kmpNext("ABCDABD"); //[0, 1, 2, 0
//		System.out.println("next=" + Arrays.toString(next));
//		int index = kmp(str1, str2, next); 
//		System.out.println("index=" + index);
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD"; 
		int[] next=setPrefix(str2);
		int index = kmp(str1, str2, next); 
		System.out.println("index=" + index);
		System.out.println(Arrays.toString(next));
	}

	public static int kmp(String str1, String str2, int[] next) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		int len1 = ch1.length;
		int len2 = ch2.length;
		for (int i = 0, j = 0; i < len1; i++) {
			while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j - 1];
			}
			if (str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			if (j == len2) {
				return i - j + 1;
			}
		}
		return -1;
	}

	public static int[] kmpNext(String dest) {
		int[] next = new int[dest.length()];
		next[0] = 0;
		for (int i = 1, j = 0; i < dest.length(); i++) {
			while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = next[j - 1];
			}
			if (dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}

	public static int violenceMatch(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		int len1 = ch1.length;
		int len2 = ch2.length;
		int i = 0;
		int j = 0;
		while (true) {

			if (ch1[i] == ch2[j]) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
			if (i < len1 && j < len2) {
				continue;
			} else {
				break;
			}
		}
		if (j == len2) {
			return i - j;
		} else {
			return -1;
		}
	}
	public static int[] setPrefix(String pattern) {
		int[] prefix=new int[pattern.length()];
		char[] ch=pattern.toCharArray();
		int len=pattern.length();
		prefix[0]=0;
		for(int i=1;i<len;i++) {
			int k=prefix[i-1];
			while(ch[i]!=ch[k] && k!=0) {
				k=prefix[k-1];
			}
			if(ch[i]==ch[k]) {
				prefix[i]=k+1;
			}else {
				prefix[i]=0;
			} 
		}
		return prefix;
	}
}
