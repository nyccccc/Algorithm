package Subsets;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :子集
 * @url :
 * @create :2020-11-15
 */


public class Subsets {
    List<List<Integer>> res = new LinkedList< List< Integer > > ();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new LinkedList< Integer > ();
        backtrack(nums,track,0);
        return res;
    }
    public void backtrack(int[] nums,List<Integer> track,int start){
        res.add(new LinkedList< Integer > (track));
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add (nums[i]);
            // 回溯
            backtrack(nums,  track,i+1);
            track.remove (track.size ()-1);
        }
}
@Test
    public void test(){
    System.out.println (subsets (new int[]{1,2,3}));
}
}
