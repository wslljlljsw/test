package toutiao;

import java.util.Scanner;

public class toutiaod3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if(s.length() < 4) {
			System.out.println(0);
			return;
		}
		int[][] dp = new int[s.length()][4];
		dp[0][1] = 1;
		if(s.charAt(0) != '0') dp[1][1] = 1;
		dp[1][2] = 1;
		StringBuilder cur = new StringBuilder(s.substring(0,2));
		for(int i = 2; i < s.length(); i++) {
			cur.append(s.charAt(i));
			if(cur.length() > 3) cur = cur.deleteCharAt(0);
			if(i <= 3) dp[i][1] = lessthan255(cur)? 1 : 0;
			dp[i][2] += dp[i-1][1];
			dp[i][3] += dp[i-1][2];
			if(s.charAt(i-2) != '0') {
				dp[i][2] = dp[i-2][1];
				dp[i][3] = dp[i-2][2];
			}
			if(i >= 3 &&s.charAt(i-3) != '0' &&  lessthan255(cur)) {
				dp[i][2] += dp[i-3][1];
				dp[i][3] += dp[i-3][2];
			}
		}
		
		int result = 0;
		result += dp[s.length()-2][3];
		if(s.charAt(s.length()-3) != '0') result += dp[s.length()-3][3];
		if(s.charAt(s.length()-4) != '0' && lessthan255(cur)) result += dp[s.length()-4][3];
		System.out.println(result);
		
	}
	
	public static boolean lessthan255(StringBuilder s) {
		if(Integer.valueOf(s.toString()) <= 255) return true;
		return false;
	}
}
