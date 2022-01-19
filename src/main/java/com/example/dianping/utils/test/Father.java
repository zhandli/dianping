package com.example.dianping.utils.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zh
 * @date 2021/10/3 10:19
 */
public class Father {
    public void say() {
        synchronized (this){
            System.out.println("i am father");
        }
    }

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(6)) {
                iterator.remove();
            }
        }
        System.out.println(list.size());

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
