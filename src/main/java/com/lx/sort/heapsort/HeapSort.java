package com.lx.sort.heapsort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
//        int[] a = {-1, 5, 2, 6, 0, 3, 9, 1, 7, 4, 8};
        int[] a = {-1, 5, 6, 0, 3, 9, 4, 8};
        HeapSort(a, 7);
        //System.out.println(Arrays.toString(a));
    }

    /**
     * 构建大顶堆
     * @param array
     * @param length
     */
    public static void HeapSort(int[] array,int length) {
        int i;
        //首先将无序数列转换为大顶堆
        for (i = length / 2; i > 0;i--) {
            //注意由于是完全二叉树，所以我们从一半向前构造，传入父节点
            HeapAdjust(array, i, length);
        }
        System.out.println(Arrays.toString(array));

        //上面大顶堆已经构造完成，我们现在需要排序，每次将最大的元素放入最后
        //然后将剩余元素重新构造大顶堆，将最大元素放在剩余最后
        for (i = length; i >1;i--) {
            swap(array, 1, i);
            HeapAdjust(array, 1, i - 1);

            System.out.println(Arrays.toString(array));
        }
    }

    public static void HeapAdjust(int[] array,int p,int length) {
        int i,temp;
        temp = array[p];
        for (i = 2 * p; i <= length;i*=2)    //逐渐去找左右孩子结点
        {
            //找到两个孩子结点中最大的
            if (i < length && array[i] < array[i + 1]){
                i++;
            }
            //父节点和孩子最大的进行判断，调整，变为最大堆
            if (temp >= array[i]){
                break;
            }

            //将父节点数据变为最大的，将原来的数据还是放在temp中，
            array[p] = array[i];    //若是孩子结点的数据更大，我们会将数据上移，为他插入的点提供位置
            p = i;
        }
        //当我们在for循环中找到了p子树中，满足条件的点，我们就加入数据到该点p,注意：p点原来数据已经被上移动了
        //若没有找到，就是相当于对其值不变
        //插入
        array[p] = temp;
    }

    /**
     * 交换元素
     *
     * @param arr
     * @param a
     *            元素的下标
     * @param b
     *            元素的下标
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
