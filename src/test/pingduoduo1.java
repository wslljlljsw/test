package test;

import java.util.Scanner;

public class pingduoduo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] ca = s.toCharArray();
		char[][] ca2 = new char[s.length()/4+1][s.length()/4+1];
		
		for(int i = 0; i < s.length()/4+1; i++) {
			for(int j = 0;j < s.length()/4+1; j++) {
				if(i == 0) ca2[i][j] = ca[i+j];
				else if(i == s.length()/4) ca2[i][j] = ca[s.length()/4*3-j];
				else if(j == 0 && i!= 0) ca2[i][j] = ca[s.length()-i];
				else if(j == s.length()/4) ca2[i][j] = ca[s.length()/4+i];
				else ca2[i][j] = ' ';
			}
		}
		
		for(int i = 0; i < s.length()/4+1; i++) {
			for(int j = 0;j < s.length()/4+1; j++) {
				System.out.print(ca2[i][j]);
			}
			System.out.println();
		}		
	}
}
