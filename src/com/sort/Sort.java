package com.sort;

import java.util.Random;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.sort
 * @Description : TODO
 * @Create on : 2021/5/13 20:05
 **/
public interface Sort {

    default Comparable[] prpareData() {
        Random random = new Random(System.currentTimeMillis());
        Integer[] prepareSortData = new Integer[10];
        for (int i = 0; i < 10; i++) {
            prepareSortData[i] = random.nextInt(30);
        }
        return prepareSortData;
    }

    void sort(Comparable[] arr);

}
