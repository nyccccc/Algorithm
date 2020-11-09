package CoinChange;

import org.junit.Test;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :找零钱问题-暴力递归破解:
 *              取能够取到的最小的值
 * @create :2020-11-08
 */

public class CoinChangeByForceByRemember {
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] money,int target){
        if ( money.length==0 ) {
            return -1;
        }
        coinChangeMethod(money,target,0);
        return res = res<Integer.MAX_VALUE ?res:-1;
    }

    private void coinChangeMethod ( int[] money, int target, int i ) {
        if(target <0){
            return;
        }
        if ( target==0 ){
            res= Math.min (res,i);
        }
        for ( int moneys:money ){
            coinChangeMethod (money,target-moneys,i+1);
        }
    }

    @Test
    public void test() {
        int[] money = new int[] { 1, 5, 10, 20, 50, 100 };
        int a = coinChange (money, 61);
        System.out.println (a);
    }
}
