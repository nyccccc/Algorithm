/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :拿石头
 * @url :https://leetcode-cn.com/problems/stone-game/
 * @create :2020-11-09
 */


public class Stone {
    class Solution {
        public boolean stoneGame(int[] piles) {
            int length = piles.length;
            int[][] dp = new int[length][length];
            for (int i = 0; i < length; i++) {
                dp[i][i] = piles[i];
            }
            for (int i = length - 2; i >= 0; i--) {
                for (int j = i + 1; j < length; j++) {
                    dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
                }
            }
            return dp[0][length - 1] > 0;
        }
    }
}
