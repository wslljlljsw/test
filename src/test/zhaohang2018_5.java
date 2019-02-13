package test;

import java.util.*;

public class zhaohang2018_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.valueOf(sc.nextLine());
		while(t > 0) {
			t--;
			int n = Integer.valueOf(sc.nextLine());
			String[] s = sc.nextLine().split(" ");
			int[] people = new int[n];
			for (int i = 0; i < people.length; i++) {
				people[i] = Integer.valueOf(s[i]);
			}
			
			if(n == 1) {
				System.out.println(people[0]);
				continue;
			}
			if(n == 2) {
				System.out.println(Math.max(people[0], people[1]));
				continue;
			}
			
			int[][] dp = new int[n][5];
			dp[0][0] = 0;
			dp[0][1] = people[0];
			dp[0][3] = 0;
			dp[0][4] = 1;
			for(int i = 1; i < people.length-1; i++) {
				dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
				if(dp[i-1][0] > dp[i-1][1]) {
					dp[i][0] = dp[i-1][0];
					dp[i][3] = dp[i-1][3];
				}
				else if(dp[i-1][0] < dp[i-1][1]) {
					dp[i][0] = dp[i-1][1];
					dp[i][3] = dp[i-1][4];
				}
				else {
					dp[i][0] = dp[i-1][0];
					dp[i][3] = Math.min(dp[i-1][3], dp[i-1][4]);
				}
				dp[i][1] = dp[i-1][0]+people[i];
				dp[i][4] = dp[i-1][3];
			}
			int result1 = dp[people.length-2][1];
			int result2 = 0;
			if(dp[people.length-2][3] == 0) {
				result2 = dp[people.length-2][0]+people[people.length-1];
			}
			else {
				result2 = dp[people.length-2][0]+people[people.length-1]-people[0];
			}
			System.out.println(Math.max(result1, result2));
		}
	}
}
