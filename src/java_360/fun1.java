package java_360;

import java.util.Scanner;

public class fun1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		int left = 0,right = 0,up = 0,down = 0;
		for(int i = 0; i < n; i++) {
			String[] s = sc.nextLine().split(" ");
			int x = Integer.valueOf(s[0]);
			int y = Integer.valueOf(s[1]);
			if(i == 0) {
				left = x;
				right = x;
				up = y;
				down = y;
			}
			else {
				left = Math.min(left, x);
				right = Math.max(right, x);
				up = Math.max(up, y);
				down = Math.min(down, y);
			}
		}
		long max = Math.max(right-left, up - down);
		System.out.println(max*max);
		
	}
}
