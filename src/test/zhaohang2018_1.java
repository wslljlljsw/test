package test;

import java.util.Scanner;

public class zhaohang2018_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = "";
		String s3 = "";
		String[] ss;
		for(int i = 0; i < s1.length()-1; i++) {
			s2 = s2 + s1.charAt(i);
			ss = s1.split(s2);
			if(ss.length == 0) {
				s3 = s2;
			}
		}
		if(s3.equals("")) {
			System.out.println(false);
		}
		else {
			System.out.println(s3);
		}
	}
}
