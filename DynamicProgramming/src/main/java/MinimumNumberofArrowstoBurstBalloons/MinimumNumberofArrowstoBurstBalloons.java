package MinimumNumberofArrowstoBurstBalloons;

import java.util.Arrays;

/**
*@program :Algorithm
*
*@description :用最少的弓箭射气球
*
*@author : YiChen Niu (yniu7@sheffield.ac.uk)
*
*@url : https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
*@create :2020-11-14
*
*@version : 0.1
*/


public class MinimumNumberofArrowstoBurstBalloons {
    public int min(int[][] Balloons){
        if(Balloons.length==0||Balloons==null){
            return 0;
        }
        if ( Balloons.length==1 ){
            return 1;
        }
        if ( Balloons.length==2 ){
            if(Balloons[0][1] >= Balloons[1][0]){
                return 1;
            }
            return 2;
        }
        Arrays.sort (Balloons,(o1,o2)->o1[1]-o2[1]);
        int[] dp = new int[Balloons.length];
        dp[0] =1;
        for ( int i =1; i<Balloons.length;i++ ){
            dp[i] =1;
            for ( int j=i-1;j>=0;j-- ){
                if(Balloons[i][0] > Balloons[j][1]) {
                    dp[i] = dp[j]+1;
                }
            }
        }
        return dp[Balloons.length-1];
    }
}
