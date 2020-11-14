package LengthOfLIS;

import java.util.Arrays;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :最长增长子序列 LeetCode No 300
 * @create :2020-11-09
 */


public class LengthOfLIS {
    public int lengthOfLIS(int[] nums){
        if(nums.length==0){
            return 0;
        }
        if ( nums.length==1 ){
            return 1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill (dp,1);
        for ( int i=0;i<nums.length;i++ ){
            for ( int j =0; j<i;j++ ){
                if ( nums[i]>nums[j] ){
                    dp[i]= Math.max (dp[i],dp[j]+1);
                }
            }
        }
        int res =0;
        for ( int i: dp){
            res= Math.max (res,i);
        }
        return res;
    }
}
