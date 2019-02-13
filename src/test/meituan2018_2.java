package test;

import java.util.*;

public class meituan2018_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		int n = Integer.valueOf(s[0]);
		int i = Integer.valueOf(s[1]);
		int j = Integer.valueOf(s[2]);
		int p = Integer.valueOf(s[3]);
		
		int[][] gcd_value = new int[i+1][j+1];
		for(int l = 1; l <= i; l++) {
			for(int m = 1; m <= j; m++) {
				if(m <= i && l <= j && gcd_value[m][l] != 0) gcd_value[l][m] = gcd_value[m][l];
				gcd_value[l][m] = gcd(l, m);
			}
		}
		int[] A = new int[Math.min(i, j)+1];
		A[1] = p;
		for(int l = 2; l < A.length; l++) {
			A[l] = (A[l-1]+153)%p;
		}
		long result = 0;
		for(int l = 1; l <= i; l++) {
			for(int m = 1; m <= j; m++) {
				result += A[gcd_value[l][m]];
			}
		}
		System.out.println(result);
		
		
	}
	
	public static int gcd(int i,int j) {
		int k;   
        while ((k=i%j) != 0) {            
            i = j;  
            j = k;  
        }  
        return j;
	}
}
