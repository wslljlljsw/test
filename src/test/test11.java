package test;

import java.util.Scanner;
/*
 * 四柱汉诺塔
 */
public class test11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n > 2?n+1 : 3];
		array[1] = 1;
		array[2] = 3;
		int min = 0;
		for(int i = 3; i <= n; i++) {
			min = Integer.MAX_VALUE;
			int temp = 0;
			for(int j = 1; j < i; j++) {
				temp = (int) (2*array[j] + Math.pow(2, i-j)-1);
				if(min > temp) min = temp;
			}
			array[i] = min;
		}
		for(int i : array) {
			System.out.println(i);
		}
	}
}


