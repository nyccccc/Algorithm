package LongComSeq;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :最长公共子序列
 * @url :https://leetcode-cn.com/problems/longest-common-subsequence/
 * @create :2020-11-09
 */
public class LongestCommonSubsequenceUseRecursion {
    public int longestCommonSubsequence(String text1, String text2) {
        int res =0;
        char[] chars1 = text1.toCharArray ();
        char[] chars2 = text2.toCharArray ();
        return dp (chars1.length-1,chars2.length-1,chars1,chars2);
    }
    public int dp(int i,int j, char[] chars1,char[] chars2){
        if ( i==-1||j==-1 ){
            return 0;
        }
        if ( chars1[i] ==chars2[j] ){
            return dp (i-1, j-1, chars1, chars2)+1;
        }else {
            return Math.max (dp (i-1,j,chars1,chars2),dp (i,j-1,chars1,chars2));
        }
    }
}
