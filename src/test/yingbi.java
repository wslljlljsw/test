package test;

import java.util.Scanner;

public class yingbi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		long n = Integer.valueOf(s);
		int[] a = new int[61];
		for(int i = a.length-1; i >=0; i--) {
			if(n >= Math.pow(2, i)) {
				n = n-(long)Math.pow(2, i);
				a[i]++;
			}
		}
		int result = chaifen(a);
		System.out.println(result);
	}
	
	public static int chaifen(int[] a) {
		int result = 0;
		int[] aa = a;
		for(int i = a.length-1; i > 0; i--) {
			if(aa[i] > 0 && aa[i-1] == 0) {
				aa[i]--;
				aa[i-1] = 2;
				result = result + chaifen(aa);
				aa[i]++;
				aa[i-1] = 0;
			}
		}
		return result+1;
		
	}

}
