package test;

import java.util.*;

public class meituan2018_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		int[] nine = new int[10];
		nine[0] = 0;
		for (int i = 1; i < nine.length; i++) {
			nine[i] = nine[i-1]*10+9;
		}
		long[] num = new long[9];
		for (int i = 0; i < num.length; i++) {
			num[i] = (long) (9*Math.pow(10, i)*(i+1));
		}
		String s;
		int temp;
		long result;
		for(int i = 0; i < n; i++) {
			s = String.valueOf(Integer.valueOf(sc.nextLine()));
			result = 0;
			for(int j = 0; j < s.length()-1; j++) {
				result += num[j];
			}
			result += (Integer.valueOf(s)-nine[s.length()-1])*s.length();
			System.out.println(result);
			
			result = 0;
			for(int j = 1; j <= Integer.valueOf(s); j++) {
				result += String.valueOf(j).length();
			}
			System.out.println(result);
		}
	}
}
