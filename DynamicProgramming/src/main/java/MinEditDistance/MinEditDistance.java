package MinEditDistance;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :最小编辑距离
 * @url :https://leetcode-cn.com/problems/edit-distance/submissions/
 * @create :2020-11-09
 */


public class MinEditDistance {
    public int minDistance(String word1, String word2) {
        int res =0;
        char[] chars1 =word1.toCharArray ();
        char[] chars2 = word2.toCharArray ();
        res = dp(chars1,chars2,chars1.length-1,chars2.length-1);
        return res;
    }
    private int dp ( char[] chars1, char[] chars2, int i, int j ) {
        if ( i==-1 ) return j+1;
        if ( j==-1 ) return i+1;
        if(chars1[i]==chars2[j]){
            return dp (chars1,chars2,i-1,j-1);
        }else {
            return Math.min ( Math.min (dp (chars1,chars2,i,j-1)+1,dp (chars1,chars2,i-1,j)+1)
                    ,dp (chars1,chars2,i-1,j-1)+1);
        }
    }
}
