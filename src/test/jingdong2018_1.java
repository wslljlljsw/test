package test;

import java.util.*;

public class jingdong2018_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[][] dp = new int[s.length()][s.length()];
		
		for(int i = 0 ; i < s.length(); i++) {
			dp[i][i] = 1;
		}
		for(int i = 0 ; i < s.length()-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) dp[i][i+1] = 3;
			else dp[i][i+1] = 2;
				
		}

//		for(int i = 2)
		System.out.println(dp[0][s.length()-1]);
	}
}
