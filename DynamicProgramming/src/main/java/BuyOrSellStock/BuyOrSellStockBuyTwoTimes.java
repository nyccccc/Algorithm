package BuyOrSellStock;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :买卖股票问题
 * @url :
 * @create :2020-11-10
 */


public class BuyOrSellStockBuyTwoTimes {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n==0) return 0;
            int[][][] dp = new int[n+1][3][2];
            for(int i=0;i<n;i++){
                for(int k = 2; k>=1;k--){
                    if(i-1==-1){
                        dp[i][k][0] = 0;
                        dp[i][k][1] = -prices[i];
                        continue;
                    }
                    dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
                }
            }
            return dp[n-1][2][0];
        }
    }