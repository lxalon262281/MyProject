package com.lx.demo.arithmetic.search;


/**
 * 前提条件：已排序的数组中查找
 * 二分查找的基本思路是：首先确定该查找区间的中间点位置： int mid = (low+upper)
 * 2；然后将待查找的值与中间点位置的值比较：若相等，则查找成功并返回此位置。
 * 若中间点位置值大于待查值，则新的查找区间是中间点位置的左边区域。若中间点位置值小于待查值，
 * 则新的查找区间是中间点位置的右边区域。下一次查找是针对新的查找区间进行的。
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array ={1,2,3,4,5,6,7,8,9};
        System.out.println(search(8,array));
    }

    public static int search(int target,int[] array) {
        int low = 0;
        int high = array.length -1;

        while (low < high) {
            int min = (low + high) / 2;
            if (array[min] > target) {
                low = min + 1;
            } else if (array[min] < target) {
                high = min - 1;
            } else {
                return min;
            }
        }

        return -1;

    }
}
