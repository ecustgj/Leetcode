package 动态规划;

import java.util.Arrays;
import java.util.Scanner;

public class minCostClimbingStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] cost=new int[]{1,100,1,1,1,90,1,1,80,1};
        int[] dp=new int[n];
        dp[0]=cost[0];
        dp[1]=cost[1];

        for(int i=2;i<n;i++){
            dp[i]=Math.min(dp[i-2]+cost[i],dp[i-1]+cost[i]);

        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Math.min(dp[n-2],dp[n-1]));

    }
}
