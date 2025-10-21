package com.ptphong.lesson02;

import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component // Báo cho Spring biết đây là 1 Bean (đối tượng)
public class BubbleSortAlgorithm implements SortAlgorithm {

    @Override
    public int[] sort(int[] arr) {
        System.out.println("Đang sắp xếp bằng BubbleSort...");

        // Đây là code logic bubble sort từ tài liệu của bạn
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped, the array is already sorted
            if (!swapped) {
                break;
            }
        }
        return arr;
    }
}