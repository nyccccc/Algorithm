package Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :全排列
 * @url :https://leetcode-cn.com/problems/permutations/
 * @create :2020-11-14
 */


public class permutations {
    List<List<Integer>> res = new LinkedList< List< Integer > > ();
    public List< List<Integer> > permute( int[] nums) {
        //记录的路径
        LinkedList<Integer> track = new LinkedList<Integer>();
        backtrack(nums, track);
        return res;
    }
    public void backtrack(int[] nums,LinkedList<Integer> track){
        //触发结束条件
        if ( track.size ()==nums.length ){
            res.add (new LinkedList< Integer > (track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(track.contains (nums[i])){
                continue;
            }else {
                track.add (nums[i]);
                backtrack (nums,track);
                track.removeLast ();
            }
        }
    }
}
