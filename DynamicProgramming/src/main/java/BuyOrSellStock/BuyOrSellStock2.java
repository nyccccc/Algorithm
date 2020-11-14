package BuyOrSellStock;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :买卖股票问题
 * @url :
 * @create :2020-11-10
 */


public class BuyOrSellStock2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if ( n ==0 ) return n;
        int dp0=0;
        int dp1= Integer.MIN_VALUE;
        int tmp;
        for ( int i :prices ){
            tmp=dp0;
            dp0 = Math.max (dp0,dp1+i);
            dp1 = Math.max (dp1,tmp-i);
        }
        return dp0;
    }
}
