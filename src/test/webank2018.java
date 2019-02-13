package test;

import java.util.*;
public class webank2018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		int men_num = Integer.valueOf(s[0]);
		int women_num = Integer.valueOf(s[1]);
		int[] men = new int[men_num+1];
		int[] women = new int[women_num+1];
		int max = 0;
		for(int i = 0; i < men_num; i++) {
			s = sc.nextLine().split(" ");
			max = max > s.length-1? max:s.length-1;
			if(s[0].equals("0")) continue;
			else {
				for(int j = 1; j < s.length;j++) {
					women[Integer.valueOf(s[j])]++;
				}
			}
		}
		for(int i = 0; i < women_num; i++) {
			s = sc.nextLine().split(" ");
			max = max > s.length-1? max:s.length-1;
			if(s[0].equals("0")) continue;
			else {
				for(int j = 1; j < s.length;j++) {
					men[Integer.valueOf(s[j])]++;
				}
			}
		}
		
		for(int i: men) {
			max = max > i? max:i;
		}
		for(int i: women) {
			max = max > i? max:i;
		}
		System.out.println(max);
	}
}

