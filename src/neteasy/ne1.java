package neteasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ne1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] fl = sc.nextLine().split(" ");
		int k = Integer.valueOf(fl[1]);
		
		String[] sl = sc.nextLine().split(" ");
		int[] tower = new int[sl.length];
		for(int i = 0; i < tower.length; i++) {
			tower[i] = Integer.valueOf(sl[i]);
		}
		int[] max_array = new int[tower.length];
		int[] min_array = new int[tower.length];
		int count = 0;
		while(count < k) {
			int min = getmin(tower);
			int max = getmax(tower);
			if(tower[max] - tower[min] > 1) {
				max_array[max]++;
				min_array[min]++;
				tower[max]--;
				tower[min]++;
				count++;
			}
			else break;
		}
		
		int d = tower[getmax(tower)] - tower[getmin(tower)];
		System.out.println(d + " " +count);
		for(int i = 0,j = 0; i < tower.length;) {
			while(i < tower.length) {
				if(max_array[i] > 0) {
					max_array[i]--;
					break;
				}
				else i++;
			}
			while(j < tower.length) {
				if(min_array[j] > 0) {
					min_array[j]--;
					break;
				}
				else j++;
			}
			if(i < tower.length) System.out.println((i+1)+" "+(j+1));
		}
	}
	
	public static int getmin(int[] tower) {
		int min = 10001;
		int index = 0;
		for(int i = 0; i < tower.length; i++) {
			if(tower[i] < min) {
				min = tower[i];
				index = i;
			}
		}
		return index;
	}
	
	public static int getmax(int[] tower) {
		int max = 0;
		int index = 0;
		for(int i = 0; i < tower.length; i++) {
			if(tower[i] > max) {
				max = tower[i];
				index = i;
			}
		}
		return index;
	}
}
