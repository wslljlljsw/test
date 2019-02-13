package test;

import java.util.*;

import org.xml.sax.HandlerBase;

public class yonghuxihao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		String[] s = sc.nextLine().split(" ");
		
		Map<Integer,List<Integer>> map= new HashMap<>();
		int cur_num;
		for(int i = 0; i < s.length; i++) {
			cur_num = Integer.valueOf(s[i]);
			if(!map.containsKey(cur_num)) {
				List<Integer> list = new ArrayList<>();
				list.add(i+1);
				map.put(cur_num, list);
			}
			else {
				map.get(cur_num).add(i);
			}
		}
		
		int m = Integer.valueOf(sc.nextLine());
		String[] ss;
		int start,end,num;
		List<Integer> resultlist;
		for(int i = 0; i < m; i++) {
			ss = sc.nextLine().split(" ");
			start = Integer.valueOf(ss[0]);
			end = Integer.valueOf(ss[1]);
			num = Integer.valueOf(ss[2]);
			resultlist = map.get(num);
			int count = 0;
			for(int j = 0; j < resultlist.size(); j++) {
				if(resultlist.get(j) >= start && resultlist.get(j) <= end) count++;
				if(resultlist.get(j) > end) break;
			}
			System.out.println(count);
//			resultlist.add(start);
//			resultlist.add(end);
//			Collections.sort(resultlist);
//			System.out.println(resultlist.lastIndexOf(end) - resultlist.indexOf(start)-1);
//			resultlist.remove(resultlist.indexOf(start));
//			resultlist.remove(resultlist.indexOf(end));
		}
		
//		long[] xihao = new long[n+1];
//		for(int i = 0; i < s.length; i++) {
//			xihao[i+1] = Integer.valueOf(s[i]);
//		}
//		
//		int m = Integer.valueOf(sc.nextLine());
//		String[] ss;
//		int[] start = new int[m],end = new int[m],xihao_num = new int[m];
//		int[] count = new int[m];
//		for(int i = 0; i < m; i++) {
//			ss = sc.nextLine().split(" ");
//			start[i] = Integer.valueOf(ss[0]);
//			end[i] = Integer.valueOf(ss[1]);
//			xihao_num[i] = Integer.valueOf(ss[2]);
//		}
//		for(int i = 1; i < xihao.length; i++) {
//			for(int j = 0; j < m; j++) {
//				if(start[j] <= i && end[j] >= i && xihao_num[j] == xihao[i])
//					count[j]++;
//			}
//		}
//		for(int i = 0; i < count.length; i++) {
//			System.out.println(count[i]);
//		}
		
//		int m = Integer.valueOf(sc.nextLine());
//		String[] ss;
//		int start,end,xihao_num;
//		int count;
//		for(int i = 0; i < m; i++) {
//			count = 0;
//			ss = sc.nextLine().split(" ");
//			start = Integer.valueOf(ss[0]);
//			end = Integer.valueOf(ss[1]);
//			xihao_num = Integer.valueOf(ss[2]);
//			for(int j = start; j <= end; j++) {
//				if(xihao_num == xihao[j]) {
//					count++;
//				}
//			}
//			System.out.println(count);
//		}
	}
}
