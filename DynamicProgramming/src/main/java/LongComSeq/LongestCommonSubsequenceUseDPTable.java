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
        char[] t1 = text1.toCharArray ();
        char[] t2 = text2.toCharArray ();
        int[][] dp = new int[t1.length+1][t2.length+1];
        for ( int i=1; i<= t1.length;i++ ){
            for ( int j =1; j<=t2.length;j++ ){
                if ( t1[i-1]==t2[j-1] ){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j]= Math.max (dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[text1.length ()][text2.length ()];
    }
}
