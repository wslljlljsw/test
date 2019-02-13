package test;

import java.util.*;
public class test6 {
	public static void main(String[] args) {
		Set<Myclass> set = new HashSet<>();
		set.add(new Myclass(5));
		set.add(new Myclass(2));
		set.add(new Myclass(6));
		System.out.println(set.size());
	}
	
}

class Myclass{
	Integer i;
	public Myclass(Integer y) {
		i = y;
	}
	public boolean equals(Myclass c) {
		return false;
	}
	public boolean equals(Object o) {
		return true;
	}
	public int hashCode() {
		return 32;
	}
}