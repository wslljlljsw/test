package test;

import java.util.Scanner;

public class pingduoduo3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		int n = Integer.valueOf(s[0]);
		int m = Integer.valueOf(s[1]);
		
		long[][] friend = new long[n][2];
		for(int i = 0; i < n; i++) {
			String[] people = sc.nextLine().split(" ");
			long value1 = 0;
			long value2 = 0;
			for(String p : people) {
				int t = Integer.valueOf(p);
				if(t < 60) value1 += 1L << t;
				else value2 += 1L << (t-60);
			}
//			System.out.println(Long.toBinaryString(value));
			friend[i][0] = value1;
			friend[i][1] = value2;
		}
		
		int max = 0;
		int best = -1;
		for(int i = 0; i < n; i++) {
			if(i != m && 
					((i < 60 && (friend[m][0] & (1L << i)) == 0)||
					(i >= 60 && (friend[m][1] & (1L << (i-60))) == 0))
					) {
				long num1 = friend[i][0] & friend[m][0];
				long num2 = friend[i][1] & friend[m][1];
				int count = Long.bitCount(num1)+Long.bitCount(num2);
				if(count > max) {
					max = count;
					best = i;
				}
			}
		}
		
		System.out.println(best);
	}
}
