package test;

import java.util.*;

public class Main {
	 public static void main(String [] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = Integer.valueOf(sc.nextLine());
		 int[] array = new int[n*2+1];
		 int m = Integer.valueOf(sc.nextLine());
		 String[] s;
		 int s1,s2;
		 for(int i = 0; i < m; i++) {
			 s = sc.nextLine().split("\\D+");
			 s1 = Integer.valueOf(s[0]);
			 s2 = Integer.valueOf(s[1]);
			 if(s1 > n*2 || s1 <= 0 || s2 > n*2 || s2 <= 0) {
				 System.out.println("no");
				 return;
			 }
			 if(s1 == s2 && (s1 % 2 == 0 && s1 == (s2+1)) || (s2 % 2 == 0 && s2 == (s1+1))) {
				 System.out.println("no");
				 return;
			 }
			 if (array[s1] != 0 && array[s2] != 0 && array[s1] == array[s2]) {
				 System.out.println("no");
				 return;
			 }
			 else if(array[s1] != 0 && array[s2] != 0 && array[s1] != array[s2]) continue;
			 
			 if (array[s1] == 0 && array[s2] == 0) {
				 array[s1] = 1;
				 if(s1 % 2 == 0) array[s1-1] = 2;
				 else array[s1+1] = 2;
			 }
			 
			 if (array[s1] == 0 && array[s2] != 0) {
				 array[s1] = array[s2] == 1? 2:1;
				 if(s1 % 2 == 0) array[s1-1] = array[s2];
				 else array[s1+1] = array[2];
			 }
			 else if (array[s1] != 0 && array[s2] == 0) {
				 array[s2] = array[s1] == 1? 2:1;
				 if(s2 % 2 == 0) array[s2-1] = array[s1];
				 else array[s2+1] = array[s1];
			 }
		 }
		 System.out.println("yes");
	 }
}
