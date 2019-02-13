package test;

import java.util.*;

public class tencent2018_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = Integer.valueOf(sc.nextLine());
		String[] s = sc.nextLine().split(" ");
		int a = Integer.valueOf(s[0]);
		int x = Integer.valueOf(s[1]);
		int b = Integer.valueOf(s[2]);
		int y = Integer.valueOf(s[3]);
		
		int remain = 0;
		long count_x,count_y;
		long count = 0;
		long temp_count;
		for(int i = 0; i <= x;i++) {
			remain = k - a*i;
			if(remain < 0) break;
			if(remain%b == 0) {
				count_x = 1;
				count_y = 1;
				for(int j = 0;j < i; j++) {
					count_x = count_x * (x-j)/(j+1);
				}
				for(int j = 0;j < remain/b; j++) {
					count_y = count_y*(y-j)/(j+1);
				}
				temp_count = (count_x*count_y)%1000000007;
				count = (count + temp_count)%1000000007;
			}
		}
		System.out.println(count);
	}
}
