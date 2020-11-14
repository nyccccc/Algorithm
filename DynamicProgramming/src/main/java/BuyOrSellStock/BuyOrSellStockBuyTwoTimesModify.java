package BuyOrSellStock;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :买卖股票问题
 * @url :
 * @create :2020-11-10
 */


public class BuyOrSellStockBuyTwoTimesModify {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n==0) return 0;
            int dp10 =0; int dp20= 0;
            int dp11 = Integer.MIN_VALUE;
            int dp21 = Integer.MIN_VALUE;
            for ( int price:prices ){
                dp20 = Math.max (dp20,dp21+price);
                dp21 = Math.max (dp21,dp10-price);
                dp10 = Math.max (dp10,dp11+price);
                dp11 = Math.max (dp11,-price);
            }
            return dp21;
        }
    }