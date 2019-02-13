package test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class test9 {
	public static void main(String[] args) throws InterruptedException {
		t t1 = new t();
		t t2 = new t();
		t.s = "111";
		System.out.println(I.s);
		HashMap<Integer, Integer> map = new HashMap<>();
		Hashtable<Integer, Integer> table = new Hashtable<>();
		LinkedList<Integer> linklist = new LinkedList<>();
		System.out.println(Integer.bitCount(99999));
		System.out.println(Integer.MAX_VALUE);
		linklist.add(1);
		table.put(1, 1);
		map.put(1, 1);
		map.put(2, 1);
		for(int i : map.keySet()) {
			map.put(i,i+2);
		}
		BlockingQueue<Integer> bq = new LinkedBlockingQueue<>(2);
		bq.put(1);
		bq.put(2);
		bq.take();
		bq.put(3);
		Object o;
		
		//t.tt tt1 = t1.new tt();
		System.out.println(t.tt.inner);
	
	}
}

class t implements I{
	static String s = "111";
	class tt{
		static final int inner = 1;
	}
}

interface I{
	String s = "";
}