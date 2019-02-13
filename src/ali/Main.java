package ali;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		int[][] dp = new int[n+1][2];
		if(n >= 1) dp[1][1] = 1;
		if(n >= 2) dp[2][0] = 1;
		if(n >= 3) {
			dp[3][0] = 2;
			dp[3][1] = 1;
		}
		for(int i = 4; i <= n; i++) { 
			dp[i][1] = dp[i-1][0];
			if(i >= 2) {
				dp[i][0] += dp[i-2][0]+dp[i-2][1];
			}
			if(i >= 3) {
				dp[i][0] += dp[i-3][0]+dp[i-3][1];
			}
		}
		System.out.println(dp[n][0]+dp[n][1]);
		
//		for(int[] d : dp) {
//			System.out.println(d[0]+" "+d[1]);
//		}
	}
}
