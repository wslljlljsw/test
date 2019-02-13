package test;

import java.util.*;

public class huawei2018_2_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		
		if(n <= -170) System.out.println(-1000);
		if(n > -170 && n <= 0) System.out.println(-1000+(n+170)*10);
		if(n > 0 && n <= 40) System.out.println(700+6*n);
		if(n > 40 && n <= 300) System.out.println(940+6*(n-40));
		if(n > 300 && n <= 550) System.out.println(2500+20*(n-300));
		if(n > 550) System.out.println(7500);
	}
}
