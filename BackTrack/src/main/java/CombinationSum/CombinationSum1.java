package CombinationSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :组合总和 1：
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为
 * target的组合。candidates中的数字可以无限制重复被选取。
 * @url :https://leetcode-cn.com/problems/combination-sum/
 * @create :2020-11-14
 */

public class CombinationSum1 {
    List<List<Integer>> res = new LinkedList< List< Integer > > ();
    public List< List< Integer > > combinationSum ( int[] candidates, int target ) {
        List<Integer> track = new LinkedList< Integer > ();
        backtrack(candidates,target,track,0);
        return res;
    }

    private void backtrack ( int[] candidates, int target, List< Integer> track,int i ) {
        if ( target<0 ){
            return;
        }
        if ( target==0 ){
            res.add (new LinkedList< Integer > (track));
            return;
        }
        for ( ;i<candidates.length;i++ ){
            if ( candidates[i]<=target ){
                track.add (candidates[i]);
                backtrack (candidates,target-candidates[i],track,i);
                track.remove(track.size ()-1);
            }
        }
    }

    @Test
    public void test(){
        int[] a = new int[]{3,5,2};
        List< List< Integer > > res = combinationSum (a,8);
        for ( List<Integer> aa:res ){
            System.out.println (aa);
        }
    }
}
