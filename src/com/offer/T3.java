package com.offer;

import java.util.HashSet;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.offer
 * @Description : TODO
 * @Create on : 2021/5/16 21:02
 **/
public class T3 {

    public int findRepeatNumber(int[] nums) {
        HashSet set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if( !set.contains(nums[i])) {
                set.add(nums[i]);
                continue;
            }
            return nums[i];
        }
        return -1;
    }
}
