package test;

import java.util.*;

public class weiruan_cn_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" |,|\t");
		int n = Integer.valueOf(s[0]);
		char[] nc = new char[n];
		for(int i = 0; i < n;i++) {
			nc[i] = s[s.length-1].charAt(i);
		}
		
		int cur = 0;
		int pre = 0;
		int cur_length = 0;
		int best = 0;
		int best_length = 0;
		while(cur < n) {
			if(nc[cur] == 'c') {
				pre = cur;
				while((cur+2 < n && nc[cur+2] == 'c') || (cur+1 < n && nc[cur+1] == 'c')) {
					if(nc[cur+2] == 'c') cur = cur+2;
					else if(nc[cur+1] == 'c') cur = cur+1;
					else break;
				}
				cur_length = cur - pre + 1 + (pre >= 2? 2:pre) + ((n - cur) >= 2? 2: (n - cur));
				if(best_length < cur_length) {
					best = pre - (pre >= 2? 2:pre);
					best_length = cur_length;
				}
			}
			cur++;
		}
		
		String result = "";
		for(int i = 0; i < n; i++) {
			if(i >= best && i <= best+best_length-1) {
				result = result + "I";
			}
			else {
				result = result + "U";
			}
		}
		
		System.out.println(result);
	}
}
