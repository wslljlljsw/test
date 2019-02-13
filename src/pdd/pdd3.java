package pdd;

import java.util.Arrays;
import java.util.Scanner;

public class pdd3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] count = new int[26];
		for(int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		Arrays.sort(count);
		int result = 0;
		for(int i = 0; i < 24; i++) {
			result += Math.pow(count[i], 2);
		}
		result += Math.pow(count[24]+count[25],2);
		System.out.println(result);
	}
}
