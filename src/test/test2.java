package test;

import java.util.*;

public class test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pow = Integer.valueOf(sc.nextLine());
		if(pow == 0) {
			System.out.println(1);
			return;
		}
		int count = 0;
		for(int i = 1; i <= Math.sqrt(pow); i++) {
			double result = Math.sqrt((pow-i*i));
			if(result - Math.round(result) == 0) count++;
		}
		
		System.out.println(count*4);
	}
}
