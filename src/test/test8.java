package test;

import java.util.*;

import leetcode.TreeNode;

public class test8 {
	public static void main(String[] args) {
		BaiChen baichen = new BaiChen();
		System.out.println(baichen.count());
		StringBuilder sb = new StringBuilder();
	}
}

class BaiChen {
	int count = 0;
	public int count() {
		count = 0;
		char[] ca = new char[] {'A','B','C','D','E'};
		chuanqiu('A',ca,0,"A");
		return count;
		
	}
	
	public void chuanqiu(char cur, char[] ca, int time,String result) {
		if(time == 5) { 
			if(cur == 'A') {
				System.out.println(result);
				count++;
			}
			return;
		}
		for(int i = 0; i < ca.length; i++) {
			if(cur == ca[i]) continue;
			if(cur == 'A' && ca[i] == 'B') continue;
			if(cur == 'B' && ca[i] == 'A') continue;
			if(cur == 'E' && ca[i] == 'C') continue;
			if(cur == 'C' && ca[i] != 'D') continue;
			chuanqiu(ca[i],ca,time+1,result+ca[i]);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
