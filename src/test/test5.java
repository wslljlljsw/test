package test;

public class test5 {
	public static void main(String[] args) {
		float a = 1.00000001f;
		float b = 1.00000006f;
//		double a = 1.01;
//		double b = 1.01;
		
		String aa = String.valueOf(a);
		String bb = String.valueOf(b);
		System.out.println(a == b);
		System.out.println(a < b);
		System.out.println(aa);
		System.out.println(bb);
	}
}
