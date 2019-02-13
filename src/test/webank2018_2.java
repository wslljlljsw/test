package test;

import java.util.*;
public class webank2018_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		if(n <= 1) {
			System.out.println(0);
			return;
		}
		int[] result = new int[n+1];
		for(int i = 2; i <= n; i++) {
			if(result[i] == 1) continue;
			result[i] = 1;
			for(int j = 2; j <= i/2; j++) {
				if(i%j == 0) {
					result[i] = 0;
					break;
				}
			}
			if(result[i] == 1) {
				int j = i*i;
				while(j <= n) {
					result[j] = 1;
					j = j*i;
				}
			}
		}
		
		for(int i = 2; i <= n; i++) {
			result[0] += result[i];
		}
		System.out.println(result[0]);
	}
}
