package CombinationSum;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :组合总和 1：
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为
 * target的组合。candidates中的数字可以使用一次
 * @url :https://leetcode-cn.com/problems/combination-sum-ii/
 * @create :2020-11-14
 */

public class CombinationSum2 {
    List< List<Integer> > res = new LinkedList< List< Integer > > ();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList< Integer > ();
        boolean[] isVisited = new boolean[candidates.length];
        for ( boolean i:isVisited ){
            i=false;
        }
        backtrack(candidates,target,track,0,isVisited);

        return res;
    }

    private void backtrack ( int[] candidates, int target, LinkedList< Integer> track ,int i,boolean[] isVisted) {
        if ( target<0 ){
            return;
        }
        if ( target==0 ){
            res.add (new LinkedList< Integer > (track));

            return;
        }
        for ( ; i<candidates.length;i++ ){
            if ( ! isVisted[i] &&target>=candidates[i]){
                track.add (candidates[i]);
                isVisted[i]=true;
                backtrack (candidates,target-candidates[i],track,i,isVisted);
                isVisted[i]=false;
                track.removeLast ();
            }
        }
    }

    @Test
    public void test(){
        int[] a = new int[]{10,1,2,7,6,1,5};
        List< List< Integer > > res = combinationSum2 (a,8);
        System.out.println (res);
        System.out.println ("[[1, 1, 6], [1, 2, 5], [1, 7],[2, 6]]");
    }
}
