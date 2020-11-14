package SuperEggDrop;

import java.util.Arrays;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :高空扔鸡蛋
 * @url :https://leetcode-cn.com/problems/super-egg-drop/
 * @create :2020-11-09
 */


public class SuperEggDropbyDPaddBinarySearch {
    public int superEggDrop(int K, int N) {
        // m 最多不会超过 N 次（线性扫描）
        int[][] dp = new int[K + 1][N + 1];
        // base case:
        // dp[0][..] = 0
        // dp[..][0] = 0
        // Java 默认初始化数组都为 0
        /*
        等于
        for (int m = 1; dp[K][m] < N; m++)
            for (int k = 1; k <= K; k++)
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
         */
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++){
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
            }
        }
        return m;
    }
}
