package com.lx.demo.arithmetic;

/**
 * 动态规划：剪绳子
 * 给一根长度为n的绳子，请把绳子剪成m段(m,n都是整数且1)，每段绳子的长度相乘最大乘积是多少？
 * 如绳子长度为8，当分别为2，3，3时，此时最大乘积18
 */
public class DynamicPlan {
    public static void main(String[] args) {
        System.out.println(maxProductAfterCuttingSolution(10));
    }

    public static int maxProductAfterCuttingSolution(int target) {
        if (target < 2)
            return 0;
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;

        int[] products = new int[target + 1];

        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max;
        for (int i = 4; i <= target; i++) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                    products[i] = product;
                }
            }
        }
        return products[target];
    }
}
