package test;

import java.util.*;

public class huawei2018_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String s = sc.nextLine();
			String sc_n = sc.nextLine();
			int n = Integer.valueOf(sc_n);
			int count = n;
			String result = "";
			for(int i = 0; i < n; i++) {
				if(count <= 0) break;
				if(isNum(s.charAt(i))) continue;
				if(isChinese(s.charAt(i))&& count >= 2) {
					result += s.charAt(i);
					count = count - 2;
					continue;
				}
				else if(isChinese(s.charAt(i))&& count < 2) break;
				result += s.charAt(i);
				count--;
			}
			System.out.println(result);
		}
	}
	
	public static boolean isChinese(char c) {
		return c >= 0x4E00 &&  c <= 0x9FA5;
	}
	
	public static boolean isNum(char c) {
		return c >= '0'&& c <= '9';
	}
}
