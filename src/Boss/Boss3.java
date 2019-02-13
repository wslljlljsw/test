package Boss;

import java.util.ArrayList;

public class Boss3 {
	public static void main(String[] args) {
		System.out.println(bean("1000","1,4,7,8"));
		System.out.println(bean("6666","1,4,7,8,9"));
		System.out.println(bean("5690","1,4,7,8,9"));
	}
	
	public static StringBuilder bean(String buy, String s_cannot) {
		ArrayList<Character> cannot = new ArrayList<>();
		String[] a_cannot = s_cannot.split(",");
		for(String i : a_cannot) cannot.add(i.charAt(0));
		ArrayList<Character> can = new ArrayList<>();
		for(int i = 1; i <= 9; i++) if(!cannot.contains((char)(i+'0'))) can.add((char)(i+'0'));
		
		boolean over = false;
		StringBuilder value = new StringBuilder("");
		for(int i = 0; i < buy.length(); i++) {
			for(int j = 0; j < can.size(); j++) {
				if(over == true) {
					value.append(can.get(0));break;
				}
				else if(can.get(j) == buy.charAt(i)) {
					value.append(can.get(j));break;
				}
				else if(can.get(j) > buy.charAt(i)) {
					value.append(can.get(j));over = true; break;
				}
			}
			if(value.length() != i+1) break;
		}
//		System.out.println(value);
		if(over == true) return value;
//		System.out.println("over is false");
		boolean replace = false;		
		for(int i = value.length()-1; i >= 0 ; i--) {
			for(int j = 0; j < can.size(); j++) {
				if(can.get(j) > value.charAt(i)) {
					value.setCharAt(i, can.get(j));
					replace = true;
				}
			}
			if(replace == true) break;
			value.deleteCharAt(i);
		}
		
		if(replace == true) {
			for(int i = value.length(); i < buy.length(); i++) value.append(can.get(0));
		}
		else {
			value = new StringBuilder("");
			for(int i = 0; i <buy.length()+1; i++)  value.append(can.get(0));
		}
		
		return value;
	}
}
