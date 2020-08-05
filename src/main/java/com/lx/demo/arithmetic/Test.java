package com.lx.demo.arithmetic;

public class Test {
    static int count = 0;
    public static void main(String[] args) {

        String num1 = "12349";
        String num2 = "74525";
        //twoNumAdd(num1,num2);
        //test();
        int[] arr = {1,2,3,4};
        test1(arr,0);
        System.out.println("count : " + count);
    }

    public static void rearrenge() {
        int[] arr = {1,3,2,4,10,11,45,20,6,9};
        int low = 0;
        int high = arr.length - 1;
        int i = 0;
        while (low < high) {
            i = low;
            while (low < high && arr[i] % 2 == 1) {
                i++;
                low = i;
            }
            int index = i;
            i = high;

            while (low < high && arr[i] % 2 == 0) {
                i--;
                high = i;
            }
            swap(arr,index,high);
            if (low == high) {
                break;
            }
        }
        for (int j = 0; j < arr.length;j ++) {
            System.out.print(arr[j] + " ");
        }
    }

    public static void swap(int[] arr,int low,int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    public static void twoNumAdd(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        StringBuffer res = new StringBuffer();
        int carry = 0;
        int temp = 0;


        while (len1 > 0 || len2 > 0 || carry > 0) {
            temp = carry;
            if (len1 > 0) {
                len1--;
                temp = temp + num1.charAt(len1) - '0';
            }

            if (len2 > 0) {
                len2--;
                temp = temp + num2.charAt(len1) - '0';
            }
            carry = temp / 10;

            res.append(temp % 10);
        }
        System.out.println(res.reverse().toString());

    }

    public static void test() {
        int num = 12345635;
        int n = 0;
        int temp = 0;
        int result = 0;
        while (num > 0) {
            temp = num % 10;
            result = result + temp;
            n = n * 10 + temp;
            num = num / 10;
        }

        System.out.println(result % 10);

    }


    private static void test1(int[] arr , int n) {
        int length = arr.length;
        if(n >= length-1) {//当n定位到最后一个数时，即到递归出口
            for(int i:arr) {
                System.out.print(i);
            }
            count ++;
            System.out.println();
        } else {
            for(int i = n;i < length;i++) {//将length-n个数分别放在第n个位置，(length-n)对于上文分析中的m
                swap(arr,n,i);//以交换位置的方式实现
                test1(arr,n+1);//对剩下的length-n-1个数全排列
                swap(arr,n,i);//恢复原来的顺序，进行下一次交换
            }
        }
    }
}
