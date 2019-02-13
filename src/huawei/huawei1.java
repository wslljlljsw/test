package huawei;

import java.util.Scanner;

public class huawei1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		double n = Double.valueOf(s[0]);
		double m = Double.valueOf(s[1]);
		
		double value1 = instary1(n,m);
		double value2 = instary2(n,m);
		if(value1 == value2) System.out.println(0);
		else System.out.println(value1 < value2?1:2);
	}
	
	static double instary1(double n, double m) {
		double value = n*m;
		if(n >= 3) value *= 0.7;
		if(value < 50) value += 10;
		return value;
	}
	
	static double instary2(double n, double m) {
		double value = n*m;
		if(value > 10) value -= value/10*2;
		if(value < 99) value += 6;
		return value;
	}
}
