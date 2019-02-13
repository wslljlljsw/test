package test;

import java.util.*;
public class tencent2018_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		long n = Long.valueOf(s[0]);
		long m = Long.valueOf(s[1]);
		
		long result = (n/(2*m))*m*m;
		System.out.println(result);
	}
}
