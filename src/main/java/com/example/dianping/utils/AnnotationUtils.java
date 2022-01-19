package com.example.dianping.utils;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zh
 * @date 2021/8/2 14:30
 */
public class AnnotationUtils {

    public static void quickSort(int[] arr, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }
        int pivotIdx = partion(arr, startIdx, endIdx);
        quickSort(arr, startIdx, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, endIdx);
    }

    public static int partion(int[] arr, int startIdx, int endIdx) {
        int pivot = arr[startIdx];
        int left = startIdx;
        int right = endIdx;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }

            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right) {
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
            }
        }
        arr[startIdx] = arr[left];
        arr[left] = pivot;

        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,3,5,12,6,29,8,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
