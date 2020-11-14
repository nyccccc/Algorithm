package BuyOrSellStock;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :买卖股票问题
 * @url :
 * @create :2020-11-10
 */


public class BuyOrSellStock1Modify {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if ( len==0 ){
            return 0;
        }
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
}
