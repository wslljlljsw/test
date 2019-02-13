package test;

import java.util.*;

public class webank2018_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = Long.valueOf(sc.nextLine());
		String s = Long.toBinaryString(n);
		int[] result = new int[s.length()+1];
		for(int i = 0; i <= s.length(); i++) {
			if(i == 0) result[i] = 0;
			if(i == 1) result[i] = 2;
			if(i == 2) result[i] = 1;
			if(i == 3) result[i] = 2;
			if(i > 3) result[i] = result[i-2]*2;
		}
		for(int i:result) {
			System.out.println(i);
		}
		
		String s1 = s.substring(1, (s.length()+1)/2);
//		String s1 = "100";
		int n1 = Integer.parseInt(s1, 2);
		System.out.println(n1);
		for(int i = 0; i < s.length()-1; i++) {
			n1 += result[i];
		}
		System.out.println(n1);
	}
}
