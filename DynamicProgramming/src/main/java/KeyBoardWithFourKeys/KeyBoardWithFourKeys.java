package KeyBoardWithFourKeys;

import org.junit.Test;

/**
*@program :Algorithm
*
*@description :本题为LeetCode中会员题目
 *键盘上有4个按键： 1：（A）屏幕上打印A 2：（Ctrl+A）全选，3.（Ctrl+C）复制选中的到缓冲区 4.（Ctrl+V）将缓冲区的内容输出到上次输出的结尾
 *  问 N次动作后，有多少个A？
*
*@author : YiChen Niu (yniu7@sheffield.ac.uk)
*
*@url : 
*@create :2020-11-14
*
*@version : 0.1
*/


public class KeyBoardWithFourKeys {
    public int Key(int n){

        int[] dp = new int[n+1];
        dp[0] =0;
        for ( int i =1; i<=n;i++ ){
            //按下A
            dp[i] = dp[i-1]+1;
            for ( int j =2;j<i;j++ ){
                    dp[i] = Math.max (dp[i],dp[j-2]*(i-j+1));
            }
        }
        return dp[n];
    }
    @Test
    public void test(){
        System.out.println (Key (9));
    }
}
