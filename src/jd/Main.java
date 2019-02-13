package jd;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
******************************开始写代码******************************/
		static int solve(String S, String T) {
			int count = 0;
	    	for(int i = 0; i <= S.length()-T.length();i++) {
	    		int[] s= new int[26],t = new int[26];
	            boolean issame = true;
	            for(int j = 0; j < T.length(); j++){
	                if (s[S.charAt(i+j)-'a'] != t[T.charAt(j)-'a']){
	                    issame = false;
	                    break;
	                }
	                else s[S.charAt(i+j)-'a'] = t[T.charAt(j)-'a'] = i+1;
	            }
	            if (issame) count++;
	    	}
	    	return count;
		}
//    static int solve(String S, String T) {
//    	int[] pattern_array = new int[T.length()];
//    	HashMap<Character, Integer> map = new HashMap<>();
//    	for(int i = 0; i < T.length(); i++) {
//    		if(map.containsKey(T.charAt(i))) pattern_array[i] = map.get(T.charAt(i));
//    		else {
//    			pattern_array[i] = i;
//    			map.put(T.charAt(i), i);
//    		}
//    	}
//    	int count = 0;
//    	for(int i = 0; i <= S.length()-T.length();i++) {
//    		String sub = i == S.length()-T.length()? S.substring(i):S.substring(i, i+T.length());
//    		if(compare(sub,pattern_array)) count++;
//    	}
//    	return count;
//
//    }
//    
//    public static boolean compare(String s , int[] p) {
//    	int[] s_array = new int[s.length()];
//    	HashMap<Character, Integer> map = new HashMap<>();
//    	for(int i = 0; i < s.length(); i++) {
//    		if(map.containsKey(s.charAt(i))) s_array[i] = map.get(s.charAt(i));
//    		else {
//    			s_array[i] = i;
//    			map.put(s.charAt(i), i);
//    		}
//    	}
//    	return Arrays.equals(s_array, p);
//    }
/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
            
        String _S;
        try {
            _S = in.nextLine();
        } catch (Exception e) {
            _S = null;
        }
        
        String _T;
        try {
            _T = in.nextLine();
        } catch (Exception e) {
            _T = null;
        }
  
        res = solve(_S, _T);
        System.out.println(String.valueOf(res));    

    }
}

