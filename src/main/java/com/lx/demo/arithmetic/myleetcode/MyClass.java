package com.lx.demo.arithmetic.myleetcode;

import java.util.Arrays;

public class MyClass {

    public static void main(String[] args) {
        int m[] = {3, 55, 2, 7, 8, 5, 43, 98, 1, 66, 35, 46, 234, 65};
        int n[] = new int[5];
        System.arraycopy(m, 0, n, 0, n.length);

        // 1. 建立堆
        // 由于是要找到最大的数,我们则需要建立一个最小堆
        for (int i = n.length / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }

        for (int i = n.length; i < m.length; i++) {
            // 每次只要比较最小堆顶部的数值
            if (n[0] < m[i]) {
                // 如果比顶部的数值大，则替换顶部数值，然后重新调整堆
                n[0] = m[i];
                heapify(n, 0);
                System.out.println("adjust " + m[i] + " -> " + Arrays.toString(n));
            }
        }

        System.out.println(Arrays.toString(n));
    }

    /**
     * 堆调整
     */
    private static void heapify(int n[], int i) {
        // 2. 记住左子树和右子树的计算方式
        int left = 2 * i + 1;
        int right = left + 1;
        int root = n[i];

        // 3. 判断左子树是否存在，判断右子树是否存在，比较两者大小，和根的大小比较
        // 4. 如果左边和右边都是正常的，那就直接break循环即可
        while (left < n.length) {
            if (right < n.length && n[right] < n[left] && n[right] < root) {
                n[i] = n[right];
                i = right;
            } else if (n[left] < root) {
                n[i] = n[left];
                i = left;
            } else {
                break;
            }
            n[i] = root;
            left = 2 * i + 1;
            right = left + 1;
        }

    }
}
