package CoinChange;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :找零钱问题，增加备忘录
 * @create :2020-11-08
 */


public class CoinChangeByDP {
        public int coinChange(int[] money,int target){
        if ( money.length ==0){
            return -1;
        }
        int[] res = new int[target+1];
        Arrays.fill (res,target+1);
        res[0]=0;
        for ( int i =1;i<target+1;i++ ){
            for ( int moneys:money ){
                if ( moneys<=i ){
                    res[i]=Math.min (res[i],res[i-moneys]+1);
                }
            }
        }
        return res[target]<=target+1 ? res[target]:-1;
        }
        @Test
        public void test() {
            int[] money = new int[] { 1, 5, 10, 20, 50, 100 };
            int a = coinChange (money, 61);
            System.out.println (a);
        }
    }