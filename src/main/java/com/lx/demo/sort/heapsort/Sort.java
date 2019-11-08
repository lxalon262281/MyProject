package com.lx.demo.sort.heapsort;

public class Sort {
    public static void main(String[] args) {
        int[] nums = {16,7,3,20,17,8};
        headSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 堆排序
     */
    public static void headSort(int[] list) {
        //构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = (list.length) / 2 - 1; i >= 0; i--) {
            headAdjust(list, list.length, i);
        }
        //排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = list.length - 1; i >= 1; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            headAdjust(list, i, 0);
        }
    }

    private static void headAdjust(int[] list, int len, int i) {
        int k = i, temp = list[i], index = 2 * k + 1;
        while (index < len) {
            if (index + 1 < len) {
                if (list[index] < list[index + 1]) {
                    index = index + 1;
                }
            }
            if (list[index] > temp) {
                list[k] = list[index];
                k = index;
                index = 2 * k + 1;
            } else {
                break;
            }
        }
        list[k] = temp;
    }






    public static void sort(int[] array,int length) {

        for (int i = (array.length / 2) -1; i > 0; i--) {
            headAdjust2(array,length,i);
        }

    }
    public static void headAdjust2(int[] array,int p,int length) {
        int key = p,temp = array[p],index = 2 * p +1;
        while (index < length) {
            if (index + 1 < length) {//左右孩子节点做比较
                if (array[index] < array[index + 1]) {
                    index = index +1;
                }
            }

            if (array[index] < temp) {//判断孩子节点
                array[key] = array[index];//交换
                key = index;
                index = 2 * key + 1;//判断子树的孩子节点
            } else {
                break;
            }
        }
        array[key] = temp;

    }

}