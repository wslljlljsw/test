package pdd;

import java.util.Scanner;

public class pdd4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		s1 = standardize(s1);
		s2 = standardize(s2);
		int result = s1.compareTo(s2);
		if(result < 0) System.out.println(-1);
		else if(result > 0) System.out.println(1);
		else System.out.println(0);
	}
	
	private static String standardize(String s) {
		while(s.length() > 2 && s.lastIndexOf(".0") == s.length()-2) s = s.substring(0, s.length()-2);
		return s;
	}
}
