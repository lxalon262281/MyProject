package com.lx.demo.arithmetic;

/**
 * 等概率输出题
 * 概率p输出1，概率1-p输出0，等概率输出0和1
 */
public class SameProbability {
    public int getZeroOrOne() {
        return 0;
    }


    public int getZeroOrOneSameProbability() {
        int i = getZeroOrOne();
        int j = getZeroOrOne();

        int result;
        while (true) {
            if (i == 0 && j == 1) {
                result = 0;
                break;
            } else if (i == 1 && j == 0) {
                result = 1;
                break;
            } else
                continue;
        }
        return result;
    }
}
