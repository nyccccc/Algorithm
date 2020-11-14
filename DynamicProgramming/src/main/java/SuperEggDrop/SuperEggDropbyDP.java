package SuperEggDrop;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :高空扔鸡蛋
 * @url :https://leetcode-cn.com/problems/super-egg-drop/
 * @create :2020-11-09
 */


public class SuperEggDropbyDP {
    /**
     *
     * @param K 一共有K个鸡蛋
     * @param N 一共有N层楼
     * @return 返回最少丢下去的次数
     */
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N+1][K+1];
        for ( int i=0;i<=N;i++ ){
            Arrays.fill(dp[i], i);
        }
        for (int j = 0; j <= K; j++) {
            dp[0][j] = 0;
        }
        // 第 1 行：楼层为 1 的时候，0 个鸡蛋的时候，扔 0 次，1 个以及 1 个鸡蛋以上只需要扔 1 次
        dp[1][0] = 0;
        for (int j = 1; j <= K; j++) {
            dp[1][j] = 1;
        }
        // 第 0 列：鸡蛋个数为 0 的时候，不管楼层为多少，也测试不出鸡蛋的 F 值，故全为 0
        // 第 1 列：鸡蛋个数为 1 的时候，这是一种极端情况，要试出 F 值，最少次数就等于楼层高度（想想复杂度的定义）
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        // 从第 2 行，第 2 列开始填表
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                for (int k = 1; k <= i; k++) {
                    // 碎了，就需要往低层继续扔：层数少 1 ，鸡蛋也少 1
                    // 不碎，就需要往高层继续扔：层数是当前层到最高层的距离差，鸡蛋数量不少
                    // 两种情况都做了一次尝试，所以加 1
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1);
                }
            }
        }
        return dp[N][K];
    }
}
