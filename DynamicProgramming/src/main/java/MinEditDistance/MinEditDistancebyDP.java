package MinEditDistance;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :最小编辑距离
 * @url :https://leetcode-cn.com/problems/edit-distance/submissions/
 * @create :2020-11-09
 */


public class MinEditDistancebyDP {
    public int minDistance(String word1, String word2) {
        int m = word1.length ();
        int n = word2.length ();
        int[][] dp = new int[m+1][n+1];
        // base case
        for (int i = 1; i <= m; i++){
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++){
            dp[0][j] = j;
        }
        for ( int i=1;i<=m;i++ ){
            for ( int j =1; j<=n;j++ ){
                if ( word1.charAt (i-1)==word2.charAt (j-11) ){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] =Math.min (Math.min (dp[i][j-1]+1,dp[i-1][j]+1),dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }
}
