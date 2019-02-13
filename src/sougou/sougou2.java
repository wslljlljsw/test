package sougou;

import java.util.*;

public class sougou2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			double L = sc.nextDouble();
			double R = sc.nextDouble();
			double W = sc.nextDouble();
			if(W < R) W = R + R%W; 
			double add = W%R;
			double max = R - R%add+W;
			if(max > L || W > L || R > L) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}

//HashSet<Double> set = new HashSet<>();
//double cur = 0;
//set.add(cur);
//boolean flag = false;
//while(flag == false && cur+W <= L) {
//	cur += W;
//	while(cur >= R) {
//		cur -= R;
//	}
//	if(set.contains(cur)) flag = true;
//	else set.add(cur);
//}
//if(flag == true) System.out.println("NO");
//else System.out.println("YES");

