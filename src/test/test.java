package test;

import java.io.FileFilter;
import java.util.*;

public class test {
	public static void main(String[] args) {
		int[] A = new int[] {1,1,3,4};
		int[] B = new int[] {2,2,3,4};
		int[][] dp = new int[A.length+1][B.length+1];
		System.out.println(notebook(A, B, dp, A.length, B.length));
	}
	
	public static int notebook(int[] A,int[] B, int[][] dp,int i, int j) {
		if(i < 0 || j < 0) return Integer.MAX_VALUE;
		if(i == 0 && j == 0) return 0;
		int first = Integer.MAX_VALUE,second = Integer.MAX_VALUE,third = Integer.MAX_VALUE;
		if( i-2 >= 0) {
			if(dp[i-2][j] != 0) first = dp[i-2][j];
			else first = notebook(A,B,dp,i-2,j);
			if(first != Integer.MAX_VALUE) first += A[i-2]*A[i-1];	
		}
		if(i-1 >=0 && j-1 >= 0) {
			if(dp[i-1][j-1] != 0) second = dp[i-1][j-1];
			else second = notebook(A, B, dp, i-1, j-1);
			if(second != Integer.MAX_VALUE) second += A[i-1]*B[j-1];
		}
		if(j-2 >= 0) {
			if(dp[i][j-2] != 0) third = dp[i][j-2];
			else third = notebook(A, B, dp, i, j-2);
			if(third != Integer.MAX_VALUE) third += B[j-2]*B[j-1];
		}
		
		dp[i][j] = min(first,second,third);
		System.out.printf("dp[%d][%d]:%d\n",i,j,dp[i][j]);
		return dp[i][j];
		
	}
	
	public static int min(int a,int b,int c) {
		int result;
		result = a < b ? a : b;
		result = result < c? result : c;
		return result;
	}

}
