package test;

import java.util.*;

public class jingdong2018_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		int n = Integer.valueOf(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			stack.push('(');
			if(s.equals("()") ){
				System.out.println("No");
				stack.clear();
				continue;
			}
			boolean flag = true;
			for(int j = 0; j < s.length() ; j++) {
				if(s.charAt(j) == '(') stack.push('(');
				if(s.charAt(j) == ')' && !stack.isEmpty()) stack.pop();
				else if(s.charAt(j) == ')' && stack.isEmpty()) {
					System.out.println("No");
					stack.clear();
					flag = false;
					break;
				}
			}
			if(flag == true && stack.size() == 1) {
				System.out.println("Yes");
				stack.clear();
			}
			else if(flag == true && stack.size() != 1){
				System.out.println("No");
				stack.clear();
			}
		}
	}
}
