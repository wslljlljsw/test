package toutiao;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class toutiao2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		
		TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO 自动生成的方法存根
				return o1-o2;
			}
		});
		
		for(int i = 0; i < n; i++) {
			String[] s = sc.nextLine().split(",|;");
			for(int j = 0; j < s.length; j = j+2) {
				int start = Integer.valueOf(s[j]);
				int end = Integer.valueOf(s[j+1]);
				
				while(map.ceilingKey(start) != null && end >= map.get(map.ceilingKey(start))) {
					map.remove(map.ceilingKey(start));
				}
				
				int first = start;
				int second = end;
				if(map.floorKey(start) != null && start <= map.get(map.floorKey(start))) first = map.floorKey(start);
				if(map.ceilingKey(start) != null && end >= map.ceilingKey(start)) {
					second = map.get(map.ceilingKey(start));
					map.remove(map.ceilingKey(start));
				}
				map.put(first,second);
			}
		}
		
		for(Integer i : map.keySet()) {
			if(i != map.lastKey())System.out.print(i+","+map.get(i)+";");
			else System.out.print(i+","+map.get(i));
		}
	}
}
