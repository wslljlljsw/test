package toutiao;

import java.util.HashMap;
import java.util.Scanner;

public class toutiaod5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int index = 0;
		int cur_max = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if(map.containsKey(temp)){
//				System.out.println(i+" "+index);
				cur_max = Math.max(cur_max, i-index);
				index = Math.max(index,map.get(temp)+1);
			}
			map.put(temp,i);
		}
		cur_max = Math.max(cur_max, s.length()-index);
		System.out.println(cur_max);
	}
}
