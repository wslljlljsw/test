package test;
/*
 有 n 个字符串，每个字符串都是由 A-J 的大写字符构成。现在你将每个字符映射为一个 0-9 的数字，不同字符映射为不同的数字。这样每个字符串就可以看做一个整数，唯一的要求是这些整数必须是正整数且它们的字符串不能有前导零。现在问你怎样映射字符才能使得这些字符串表示的整数之和最大？


输入描述:
每组测试用例仅包含一组数据，每组数据第一行为一个正整数 n ， 接下来有 n 行，每行一个长度不超过 12 且仅包含大写字母 A-J 的字符串。 n 不大于 50，且至少存在一个字符不是任何字符串的首字母。



输出描述:
输出一个数，表示最大和是多少。


输入例子1:
2
ABC
BCA

输出例子1:
1875
 */

import java.util.Scanner;

public class toutiao2017_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = Integer.valueOf(s);
		
		long[] a = new long[10]; //A-J
		int[] firstchar = new int[10];
		for (int i = 0; i < n; i++) {
			s = sc.nextLine();
			firstchar[s.charAt(0)-'A']++;
			for(int j = 0; j < s.length(); j++) {
				a[s.charAt(j)-'A'] += Math.pow(10, s.length()-j-1);
			}
		}
//		for (int i = 0; i < 10; i++) {
//			System.out.println(a[i]);
//		}
//		for (int i = 0; i < 10; i++) {
//			System.out.println(firstchar[i]);
//		}
		
		int cannot_zero = 0;
		for (int i = 0; i < firstchar.length; i++) {
			if(firstchar[i] > 0)
				cannot_zero++;
		}
//		System.out.println("________________"+cannot_zero);
		long sum = 0;
		for(int i = 10; i > 1; i--) {
			if(cannot_zero+1 == i) {
				for(int j = 0; j < 10; j++) {
					if(firstchar[j] == 0 && a[j] > 0) {
						a[j] = -2;
						cannot_zero = -2;
						break;
					}
				}
			}
			int cur_max = 0;
			for (int j = 1; j < 10; j++) {
				if(a[j] > a[cur_max])
					cur_max = j;
			}
			sum += a[cur_max]*(i-1);
			a[cur_max] = -2;
			if(firstchar[cur_max] > 0) cannot_zero --;
//			System.out.println((char)(cur_max+'A'));
		}
		System.out.println(sum);
	}
}
