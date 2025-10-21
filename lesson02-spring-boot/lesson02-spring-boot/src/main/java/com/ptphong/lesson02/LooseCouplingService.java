package com.ptphong.lesson02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class LooseCouplingService {

    // Không còn 'new' ở đây nữa!
    // Lớp này chỉ phụ thuộc vào Interface, không phụ thuộc vào implementation cụ thể
    private SortAlgorithm sortAlgorithm;

    // Sử dụng Constructor Injection (cách tốt nhất)
    // Spring sẽ tự động tìm 1 Bean (như BubbleSortAlgorithm) và "tiêm" vào đây
    @Autowired
    public LooseCouplingService(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    // Phương thức kinh doanh không cần biết nó đang dùng thuật toán nào
    public void complexBusinessSort(int[] arr) {
        int[] sortedArr = sortAlgorithm.sort(arr);
        System.out.println("Kết quả sau khi sắp xếp:");
        Arrays.stream(sortedArr).forEach(System.out::println);
    }
}