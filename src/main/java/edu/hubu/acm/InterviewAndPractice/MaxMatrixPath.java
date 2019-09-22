package edu.hubu.acm.InterviewAndPractice;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName MaxMatrixPath
 * @Description TODO
 * @createTime 2019年09月12日 20:56:00
 */
import java.util.Scanner;

public class MaxMatrixPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int[][] nums = new int[M][N];
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }
            System.out.println(getMinPathSum(nums));
        }
        sc.close();
    }

    public static int getMinPathSum(int[][] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int M = nums.length;
        int N = nums[0].length;
        int dp[][] = new int[M][N];
        for(int j = 0; j < N; j++) {
            for(int i = 0; i < M; i++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = nums[i][j];
                    continue;
                }
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + nums[i][j];
                    continue;
                }
                if(i == 0) {
                    dp[i][j] = dp[i][j-1] + nums[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + nums[i][j];
            }
        }
        return dp[M-1][N-1];
    }
}

