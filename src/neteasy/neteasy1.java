package neteasy;

import java.util.*;
public class neteasy1 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String str=sc.nextLine();
	int max = 0;
	for(int i = 0; i < str.length(); i++) {
		int count = 1;
		for(int j = 1; j < str.length(); j++) {
			if(str.charAt((i+j)%str.length()) != str.charAt((i+j-1)%str.length())) {
				count++;
			}
			else break;
		}
		max = Math.max(max, count);
	}
	System.out.println(max);
}
}

