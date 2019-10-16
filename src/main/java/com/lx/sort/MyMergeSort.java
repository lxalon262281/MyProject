package com.lx.sort;

/**
 * 数组归并排序
 */
public class MyMergeSort {
    public static void main(String[] args) {
        int[] array={2,4,7,5,8,1,3,6};
//        int[] array={5,4,7,9,3,8,2,1};
        printArray(array);

        devide(array,0,array.length-1);

        System.out.println("排序后:");
        printArray(array);
    }
    /*分解数据*/
    public static void devide(int[] array,int left,int right){
        //{5,4,7,9,3,8,2,1};
        printArray(array);
        if(left<right){
            /*寻找到中间下标*/
            int mid=(right+left)/2;
            /*从中间下标隔断，将前后两段分别分解*/
            devide(array,left,mid);
            /*继续分割第二段*/
            devide(array,mid+1,right);
            /*分割完了，调用归并*/
            merge(array,left,mid,mid+1,right);
//            merge(array,left,mid,right);
        }
    }
    /*归并，包含排序*/
    public static void merge(int[] array,int leftStart,int leftEnd,int rightStart,int rightEnd){
        /*新建临时数组，存放该次归并后的数据*/
        int[] temp= new int[array.length];
        /*记录归并的左组和右组开始结束下标*/
        int ls=leftStart,le=leftEnd, rs=rightStart,re=rightEnd;
        /*记录临时数组的存放位置*/
        int index=ls;
        /*第一次比较归并，左组合右组中较小的入temp*/
        while(ls<=le&&rs<=re){
            if(array[ls]<=array[rs]){
                temp[index]=array[ls];
                index++;ls++;
            } else {
                temp[index]=array[rs];
                index++;rs++;
            }
        }
        /*第二次选择归并，将array中剩余的未加入temp的数加入到temp中*/
        while(ls<=le){
            temp[index]=array[ls];
            ls++;index++;
        }
        while(rs<=re){
            temp[index]=array[rs];
            rs++;index++;
        }

        /*temp是经过调整后的array，此时一次归并完毕，返回数据进行下一次归并*/
        while(leftStart<=rightEnd){
            array[leftStart]=temp[leftStart];
            leftStart+=1;
        }
        /*打印本次归并结果*/
        printArray(array);
    }
    public static void printArray(int[] array){
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+"  ");
        System.out.println();
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while(p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while(p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while(p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for(i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }

        /*打印本次归并结果*/
        printArray(arr);
    }
}
