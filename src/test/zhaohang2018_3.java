package test;

import java.util.*;

public class zhaohang2018_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long[] start = new long[4];
		start[0] = 0;
		start[1] = 1;
		start[2] = 2;
		start[3] = 3;
		if(n <= 3) {
			System.out.println(start[n]);
			return;
		}
		long[] result = new long[n+1];
		result[0] = 0;
		result[1] = 1;
		result[2] = 2;
		result[3] = 3;
		
		for(int i = 4; i <= n; i++) {
			result[i] = Math.max(result[i-2]*2, result[i-3]*3);
		}
		
		System.out.println(result[n]);
	}
}
