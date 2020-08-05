package com.lx.demo.arithmetic.myleetcode;

public class 两个有序数组合并后的中位数 {
    public static void main(String[] args) {
        int[] num1 = {1,2,3};
        int[] num2 = {4,5,6};
        System.out.println(middleNumberOfTwoArr(num1,num2));
    }

    public static int middleNumberOfTwoArr(int[] arr1,int[] arr2){

        int start1= 0;
        int start2= 0;
        int end1 = arr1.length-1;
        int end2 = arr2.length-1;

        int midIndex1;
        int midIndex2;

        while(start1<end1 || start2<end2){
            midIndex1 = (start1 + end1)/2;
            midIndex2 = (start2 + end2)/2;
            if(arr1[midIndex1] == arr2[midIndex2]){
                return arr1[midIndex1];
            }

            if (arr1[midIndex1] < arr2[midIndex2]){
                if(((end1 - start1) % 2 == 0) && ((end2 - start2) % 2 == 0)){
                    start1 = midIndex1;
                    end2 = midIndex2;
                } else {
                    start1 = midIndex1+1;
                    end2 = midIndex2;
                }
            } else {
                if(((end1-start1) % 2 == 0) && ((end2 - start2) % 2 == 0)){
                    start2 = midIndex2;
                    end1 = midIndex1;
                }else {
                    start2 = midIndex2 + 1;
                    end1 = midIndex1;
                }
            }
        }
        return (arr1[start1]<arr2[start2]? arr1[start1]:arr2[start2]);
    }
}
