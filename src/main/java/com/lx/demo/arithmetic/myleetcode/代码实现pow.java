package com.lx.demo.arithmetic.myleetcode;

public class 代码实现pow {
    public static void main(String[] args) {
        System.out.println(myPower(2, 2));
        System.out.println(myPower(2, 4));
        System.out.println(myPower(3, 1));
        System.out.println(myPower(3, 0));
    }

    public static int myPower(int x, int y) {
        if (x == 0) {
            return 0;
        }

        int result = 1;
        for (int i = 0; i < y; i++) {
            result = result * x;
        }

        return result;
    }

    private static double power(double base, int exponent) {
        // 因为除了 0 以外，任何数值的 0 次方都为 1，所以我们默认为 1.0；
        // 0 的 0 次方，在数学书是没有意义的，为了贴切，我们也默认为 1.0
        double result = 1.0;
        // 处理负数次方情况
        boolean isNegetive = false;
        if (exponent < 0) {
            isNegetive = true;
            exponent = - exponent;
        }
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        if (isNegetive)
            return 1 / result;
        return result;
    }
}
