package LengthOfLIS;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :最长增长子序列，使用二分查找法 其思路是使用扑克牌的方法
 * @url :https://leetcode-cn.com/problems/longest-increasing-subsequence/submissions/
 * @create :2020-11-09
 */


public class LengthOfLISbyQuick {
  public int lengthOfLIS(int[] nums){
      int[] dp = new int[nums.length];
      int res =0;
      for ( int i: nums ){
          int poker = i;
          int left =0;
          int right =res;
          while ( left<right ){
              int mid =(left+right)/2;
              if ( dp[mid]>poker ){
                  right=mid;
              }
              else if ( dp[mid]<poker ){
                  left=mid+1;
              }
              else {
                  right=mid;
              }
          if ( left==mid ){
              res++;
          }
            dp[left]=res;
            }
        }
      return res;
    }
}
