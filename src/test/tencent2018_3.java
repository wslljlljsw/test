package test;

import java.util.*;

import javax.swing.event.ListSelectionEvent;

public class tencent2018_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		int n = Integer.valueOf(s[0]);
		int m = Integer.valueOf(s[1]);
		List<Machine> ma = new ArrayList<Machine>();
		List<Machine> work = new ArrayList<Machine>();
		for(int i = 0; i < n; i++) {
			s = sc.nextLine().split(" ");
			Machine machine = new Machine();
			machine.xi = Integer.valueOf(s[0]);
			machine.yi = Integer.valueOf(s[1]);
			machine.all = machine.xi * 200 + machine.yi * 3;
			ma.add(machine);
		}
		for(int i = 0; i < m; i++) {
			s = sc.nextLine().split(" ");
			Machine machine = new Machine();
			machine.xi = Integer.valueOf(s[0]);
			machine.yi = Integer.valueOf(s[1]);
			machine.all = machine.xi * 200 + machine.yi * 3;
			work.add(machine);
		}
		
		ma.sort(new Comparator<Machine>() {
			@Override
			public int compare(Machine o1, Machine o2) {
				return o1.all - o2.all;
			}
		});
		work.sort(new Comparator<Machine>() {
			@Override
			public int compare(Machine o1, Machine o2) {
				return o1.all - o2.all;
			}
		});
		
		Machine single_work;
		Machine single_machine;
		int works = 0;
		int value = 0;
		for(int i = work.size()-1; i >= 0; i--) {
			single_work = work.get(i);
			for(int j = 0; j < ma.size(); j++) {
				single_machine = ma.get(j);
				if(single_machine.xi >= single_work.xi && single_machine.yi >= single_work.yi) {
					works++;
					value = value + single_work.all;
					ma.remove(j);
					break;
				}
			}
		}
		
		System.out.println(works+" "+value);
	}
}

class Machine{
	int xi;
	int yi;
	int all;
}

