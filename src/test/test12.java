package test;

import java.util.Scanner;

public class test12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(getresult(s));
		
	}
	
	public static String getresult(String s) {
		int index = -1;
		for(int i = s.length()-1; i >= 0; i--) {
			if(i == 0) return s;
			if(s.charAt(i-1) < s.charAt(i)) {
				index = i;
				break;
			}
		}
		char[] ca = s.toCharArray();
		for(int i = index,j = ca.length-1; i < j; i++,j--) swap(ca,i,j);
		for(int i = index; i < ca.length; i++){
			if(ca[i] > ca[index-1]) {
				swap(ca,i,index-1);
				break;
			}
		}
		return new String(ca);
	}
	
	private static void swap(char[] ca, int i, int j) {
		char temp = ca[i];
		ca[i] = ca[j];
		ca[j] = temp;
	}
}
