package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class toutiao2017_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" |\t");
		long x = Long.valueOf(s[0]);
		long k = Long.valueOf(s[1]);
		String result = "";
		while(k > 0) {
			while(true) {
				if(x%2 == 0) break;
				x = x >> 1;
				result = "0"+result;
			}
			if(k%2 == 0) {
				result = "0"+result;
			}
			else {
				result = "1"+result;
			}
			x = x >> 1;
			k = k >> 1;
		}
		long result_B = 0;
		for(int i = 0;i < result.length();i++) {
			if(result.charAt(i) == '0') {
				result_B = result_B << 1;
			}
			else if(result.charAt(i) == '1') {
				result_B = result_B << 1;
				result_B++;
			}
		}
		
		System.out.println(result_B);
//		System.out.println(Long.toBinaryString(1073741802l));
//		System.out.println(Long.toBinaryString(1073741823l));
//		System.out.println(Long.toBinaryString(144115187002114069l));
	}
}
