/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :最长回文子序列
 * @url :https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * @create :2020-11-09
 */


public class LongestRepeatArray {
    public int longestPalindromeSubseq(String s) {
        int len = s.length ();
        int[][] dp = new int[len][len];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            }
        for ( int i = len-1; i>=0 ;i-- ){
            for ( int j =i+1;j<len;j++ ){
                if ( s.charAt (i)==s.charAt (j) ){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else {
                    dp[i][j] =Math.max (dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][len-1];
    }
}
