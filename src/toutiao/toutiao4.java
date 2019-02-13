package toutiao;
import java.util.Arrays;
import java.util.Scanner;

public class toutiao4 {
	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 int n=Integer.valueOf(sc.nextLine());
		 String[] s = sc.nextLine().split(" ");
		 int[] a = new int[n];
		 for (int i = 0; i < s.length; i++) {
			a[i] = Integer.valueOf(s[i]);
		}
		 s = sc.nextLine().split(" ");
		 int[] b = new int[n];
		 for (int i = 0; i < s.length; i++) {
			b[i] = Integer.valueOf(s[i]);
		}
		 
		 int count=0;
		 int first=0,second=0;
		 for(int i=0;i<n;i++){
			  first=a[i];
			  second=b[i];
			 for(int j=i;j<n;j++){
					 first=Math.max(first, a[j]);
					 second=Math.min(second, b[j]);
					 if(second>first) count++;	
					 else break;
			 }
		 }
		 System.out.println(count);
	}
}