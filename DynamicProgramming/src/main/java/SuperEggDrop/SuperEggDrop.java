package SuperEggDrop;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :高空扔鸡蛋
 * @url :https://leetcode-cn.com/problems/super-egg-drop/
 * @create :2020-11-09
 */


public class SuperEggDrop {
    public int superEggDrop(int K, int N) {
        if ( K==1 ){
            return N;
        }
        if ( N==0 ){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for ( int i = 1; i <= N; i++ ){
            res = Math.min (res,Math.max (superEggDrop (K,i-1),superEggDrop (K-1,N-i))+1);
        }
        return res;
    }
}
