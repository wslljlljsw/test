package test;

import java.util.*;

public class zhaohang2018_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = Integer.valueOf(s);
		ArrayList<String> list = new ArrayList<>();
		getresult("", 0, 0, n, 1,list);
		
		for(int i = 0; i < list.size()-1; i++) {
			System.out.print(list.get(i)+",");
		}
		System.out.print(list.get(list.size()-1));
	}
	
	public static void getresult(String s, int left,int right,int n,int flag,ArrayList<String> list) {
		String str = s; 
		if(left == n){
			for(int i = 0; i < n-right; i++) {
				str = str +")";
			}
//			System.out.print(str+",");
			list.add(str);
			return;
		}
		if(flag == 0) {
			for(int i = 1; i <= left-right; i++) {
				String ss = str;
				for(int j = 0; j < i; j++) {
					ss = ss + ")";
				}
				getresult(ss, left, right+i, n, 1,list);
			}
		}
		if(flag == 1) {
			for(int i = n-left; i > 0; i--) {
				String ss = str;
				for(int j = 0; j < i; j++) {
					ss = ss + "(";
				}
				getresult(ss, left+i, right, n, 0,list);
			}
		}
	}
}
