package Combinations;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :组合：2个数，一个是0-k的范围，一个每个排列的位数，求全排列
 * @url :https://leetcode-cn.com/problems/combinations/
 * @create :2020-11-14
 */


public class Combinations {
    List< List<Integer> > res = new LinkedList< List< Integer > > ();
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList< Integer > ();
        backtrack(n,k,track);
        return res;
    }

    private void backtrack ( int n, int k, LinkedList< Integer> track ) {
        if ( track.size ()==k ){
            res.add (new LinkedList< Integer > (track));
            return;
        }
        for ( int i=1;i<=n;i++ ){
            if ( !track.contains (i) ){
                track.add (i);
                backtrack (n, k, track);
                track.removeLast ();
            }
        }
    }
}
