package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class zhenxin {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int q = in.nextInt();
			int[] x = new int[n > 2? n:2];
			int[] y = new int[n > 2? n:2];
			int[] z = new int[q > 2? q:2];
			int[] a = new int[3];
			int[] b = new int[3];
			int[] c = new int[3];
			int[] m = new int[3];
			int[] l = new int[n];
			int[] r = new int[n];
			int[] k = new int[q];
			read(in,x,y,z,a,b,c,m);
			xyz(x, y, z, a, b, c, m);
			lrk(x, y, z, l, r, k);
			System.out.println("Case #"+i+": "+getresult(l, r, k));
		}
	}
	
	private static void read(Scanner in, int[] x, int[] y,int[] z,
			int[] a, int[] b, int[] c,int[] m) {
		x[0] = in.nextInt();
		x[1] = in.nextInt();
		a[0] = in.nextInt();
		b[0] = in.nextInt();
		c[0] = in.nextInt();
		m[0] = in.nextInt();
		y[0] = in.nextInt();
		y[1] = in.nextInt();
		a[1] = in.nextInt();
		b[1] = in.nextInt();
		c[1] = in.nextInt();
		m[1] = in.nextInt();
		z[0] = in.nextInt();
		z[1] = in.nextInt();
		a[2] = in.nextInt();
		b[2] = in.nextInt();
		c[2] = in.nextInt();
		m[2] = in.nextInt();
	}
	private static void xyz(int[] x, int[] y,int[] z,
			int[] a, int[] b, int[] c,int[] m) {
		for(int i = 2; i < x.length; i++) {
			x[i] = (a[0]*x[i-1]+b[0]*x[i-2]+c[0])%m[0];
			y[i] = (a[1]*y[i-1]+b[1]*y[i-2]+c[1])%m[1];
		}
		for(int i = 2; i < z.length; i++) {
			z[i] = (a[2]*z[i-1]+b[2]*z[i-2]+c[2])%m[2];
		}
	}
	private static void lrk(int[] x, int[] y,int[] z,
			int[] l, int[] r, int[] k) {
		for(int i = 0; i < l.length; i++) {
			l[i] = Math.min(x[i], y[i])+1;
			r[i] = Math.max(x[i], y[i])+1;
		}
		for(int i = 0; i < k.length; i++) {
			k[i] = z[i]+1;
		}
	}
	private static int getresult(int[] l, int[] r, int[] k) {
		int sum = 0;
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < l.length; i++) {
			for(int j = l[i]; j <= r[i]; j++) {
				list.add(j);
			}
		}
		Collections.sort(list);
		int len = list.size();
		for(int i = 0; i < k.length; i++) {
			if(k[i] > len) continue;
			sum += (i+1)*list.get(len-k[i]);
		}
		return sum;
	}
}

