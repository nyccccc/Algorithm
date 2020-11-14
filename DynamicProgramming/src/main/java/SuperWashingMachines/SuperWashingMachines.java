package SuperWashingMachines;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :
 * @url : https://leetcode-cn.com/problems/super-washing-machines/
 * @create :2020-11-09
 */


public class SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        int res =0;
        int num = machines.length;
        int all =0;
        for ( int i: machines ){
            all +=i;
        }
        if ( all%num!=0 ){
            return -1;
        }
        int avr = all/num;
        int cnt = 0;
        for (int m : machines) {
            cnt = cnt+m-avr;
            res = Math.max(Math.max(res, Math.abs(cnt)), m - avr);
        }
        return res;
//        int res =-1;
//        int num = machines.length;
//        int[] m = machines;
//        int all =0;
//        for ( int i: machines ){
//            all +=i;
//        }
//        if ( all%num!=0 ){
//            return res;
//        }
//        int avr = all/num;
//        for ( int i:machines ){
//            if ( i<avr ){
//                res+=(avr-i);
//            }
//        }
//        return res;
    }
}
