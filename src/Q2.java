import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int A = sc.nextInt();
        int X = sc.nextInt();
        int B = sc.nextInt();
        int Y = sc.nextInt();
 
        int[][] dp = new int[X+Y+1][K+1];
 
        for (int i = 0; i < X+Y+1; i++)
            dp[i][0] = 1;
 
        for (int i = 1; i < X+Y+1; i++) {
            for (int j = 1; j <= K; j++) {
                if (i <= X) {
                    if (j >= A) dp[i][j] = (dp[i-1][j] + dp[i-1][j-A]) % 1000000007;
                    else dp[i][j] = dp[i-1][j] % 1000000007;
                }
                else if (i <= X+Y) {
                    if (j >= B) dp[i][j] = (dp[i-1][j] + dp[i-1][j-B]) % 1000000007;
                    else dp[i][j] = dp[i-1][j] % 1000000007;
                }
            }
        }
 
        System.out.println(dp[X+Y][K]);

        for (int i = 0; i < dp.length; i++) {
        	System.out.println();
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j]+" ");
				
			}
			
		}
    }
}