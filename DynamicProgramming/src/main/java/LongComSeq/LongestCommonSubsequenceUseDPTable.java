package LongComSeq;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :最长公共子序列
 * @url :https://leetcode-cn.com/problems/longest-common-subsequence/
 * @create :2020-11-09
 */
public class LongestCommonSubsequenceUseDPTable {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray ();
        char[] c2 = text2.toCharArray ();
       int[][] dp = new int[c1.length+1][c2.length+1];
       for ( int i=1;i<c1.length+1;i++ ){
           for ( int j = 1; j< c2.length+1;j++ ){
               if ( c1[i-1]==c2[j-1] ){
                   dp[i][j] = 1 + dp[i-1][j-1];
               }else {
                   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
               }
           }
       }
        return dp[-1][-1];
    }
}
