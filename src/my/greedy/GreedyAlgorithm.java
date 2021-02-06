package my.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
	public static void main(String[] args) {
		HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
		HashSet<String> hashSet1 = new HashSet<>();
		hashSet1.add("����");
		hashSet1.add("�Ϻ�");
		hashSet1.add("���");
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("����");
		hashSet2.add("����");
		hashSet2.add("����");
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("�ɶ�");
		hashSet3.add("�Ϻ�");
		hashSet3.add("����");
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("�Ϻ�");
		hashSet4.add("���");
		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5.add("����");
		hashSet5.add("����");
		broadcasts.put("K1", hashSet1);
		broadcasts.put("K2", hashSet2);
		broadcasts.put("K3", hashSet3);
		broadcasts.put("K4", hashSet4);
		broadcasts.put("K5", hashSet5);
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.add("����");
		allAreas.add("�Ϻ�");
		allAreas.add("���");
		allAreas.add("����");
		allAreas.add("����");
		allAreas.add("�ɶ�");
		allAreas.add("����");
		allAreas.add("����");
		
		ArrayList<String> selects=new ArrayList<>();
		HashSet<String> tempSet=new HashSet<String>();
		String maxKey=null;
		while(allAreas.size()!=0) {
			maxKey=null;
			for(String key : broadcasts.keySet()) {
				tempSet.clear();
				HashSet<String> areas=broadcasts.get(key);
				tempSet.addAll(areas);
				tempSet.retainAll(allAreas);
				HashSet<String> max=new HashSet<>();
				if(maxKey!=null) {
					max =broadcasts.get(maxKey);
					max.retainAll(allAreas);
				}
		
				if(tempSet.size()>0 &&
						(maxKey==null || tempSet.size()> max.size())) {
					maxKey=key;
				}
			}
			if(maxKey!=null) {
				selects.add(maxKey);
				allAreas.removeAll(broadcasts.get(maxKey));
			} 
			System.out.println(selects.toString());
		}
	 
	}
}
