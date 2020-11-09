package FabiExample;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :斐波那契数列的动态规划解法
 * @create :2020-11-08
 */


public class Fabi {
    public int faBi(int n){
        if ( n<1 ){
            return 0;
        }
        if ( n ==1||n==2 ){
            return  1;
        }
        int[] store = new int[n];
        store[0] =1;
        store[1] = 2;
        for(int i =2; i<n; i++){
            store[i]=store[i-1]+store[i-2];
        }
        return store[n-1];
    }
    @Test
    public void test(){
        System.out.println (faBi (4));
    }
}
