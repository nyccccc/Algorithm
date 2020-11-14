package NonOverlappingIntervals;

import java.util.Arrays;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :
 * @url :https://leetcode-cn.com/problems/non-overlapping-intervals/
 * @create :2020-11-09
 */


public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals ==null||intervals.length ==0) {
            return 0;
        }
        //按照升序排列
        Arrays.sort (intervals,(o1,o2)->o1[1]-o2[1]);
        //将第一个值的末尾赋给end
        int end = intervals[0][1];
        int count = 1;
        for (int[] interval : intervals) {
            if(interval[0] < end){
                continue;
            }
            count++;
            end = interval[1];
        }
        return intervals.length - count;
    }
}
