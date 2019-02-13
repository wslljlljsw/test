package huya;

import java.util.HashMap;
import java.util.Scanner;

public class huya3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Integer> map = new HashMap<>();
		String s = sc.nextLine();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) continue;
			int value = map.getOrDefault(c, 0)+1;
			if(value == 3) {
				System.out.println(c);
				break;
			}
			map.put(c, value);
		}
	}
}
