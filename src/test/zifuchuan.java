package test;

import java.util.Scanner;

public class zifuchuan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String t = sc.nextLine();
		int length = s.length() - t.length();
		int result = 0;
		for(int i = 0; i <= length ;i++) {
			result = result + string_compare(s.substring(i, i+t.length()), t);
		}
		System.out.println(result);
//		System.out.println(s.substring(0,s.length()));
	}
	
	public static int string_compare(String s,String t){
		int result = 0;
		char[] schar = s.toCharArray();
		char[] tchar = t.toCharArray();
		for(int i = 0; i < schar.length; i++) {
			if(schar[i] != tchar[i]) result++;
		}
		return result;
	}
}
