package test;

import java.util.*;

public class huawei2018_1_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Set<Character> set = new LinkedHashSet();
		for(char c : s.toCharArray()) {
			set.add(c);
		}
		StringBuilder result = new StringBuilder("");
		for(char c : set) {
			result.append(c);
		}
		System.out.println(Integer.valueOf(result.reverse().toString()));
	}
}
