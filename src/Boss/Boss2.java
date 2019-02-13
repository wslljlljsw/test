package Boss;

import java.util.Stack;

public class Boss2 {
	public static void main(String[] args) {
		System.out.println(calculate("3*13+(23+4*((3*2)))*5")? "True":"False");
	}
	
	public static boolean calculate(String s) {
		boolean num = false;
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				if(num == true) return false;
				stack.push('(');
			}
			else if(s.charAt(i) == ')') {
				if(i+1 < s.length() && (s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9')) return false;
				if(stack.size() > 0) {
					if(stack.pop() != '1') return false;
					stack.pop();
				}
				else return false;
			}
			else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				num = true;
				continue;
			}
			else {
				if(num == false) return false;
				else num = false;
				if(stack.size() > 0 && stack.peek() == '(') stack.push('1'); 
			}
		}
		if(num == false) return false;
		else return true;
	}
}
