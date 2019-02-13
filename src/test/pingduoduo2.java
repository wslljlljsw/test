package test;

import java.util.Scanner;

public class pingduoduo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		int count = 0;
		for(int i = 1; i < s.length(); i++) {
			int left = count(s.substring(0, i));
			//System.out.println(s.substring(0, i));
			int right = count(s.substring(i));
			//System.out.println(s.substring(i));
			count += left*right;
		}
		
		System.out.println(count);
	}
	
	static int count(String s) {
		if(s.length() == 1) return 1;
		if(s.charAt(0) != '0' && s.charAt(s.length()-1) != '0') return s.length();
		else if(s.charAt(0) == '0' && s.charAt(s.length()-1) != '0') return 1;
		else if(s.charAt(0) != '0' && s.charAt(s.length()-1) == '0') return 1;
		else return 0;
	}
}
