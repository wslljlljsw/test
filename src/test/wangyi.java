package test;

import java.util.Scanner;

public class wangyi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char first = '0';
		char second = '0';
		boolean third = false;
		for (int i = 0; i < s.length(); i++) {
			if(first == '0' || first == s.charAt(i)) {
				first = s.charAt(i);
			}
			else if(second == '0' || second == s.charAt(i)) {
				second = s.charAt(i);
			}
			else {
				third = true;
				break;
			}
		}
		if(third == true || (first == '0' && second == '0')) {
			System.out.println(0);
		}
		else if(first != '0' && second != '0') {
			System.out.println(2);
		}
		else {
			System.out.println(1);
		}
	}

}
