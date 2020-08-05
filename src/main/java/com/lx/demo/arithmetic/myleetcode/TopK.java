package com.lx.demo.arithmetic.myleetcode;
import com.lx.demo.arithmetic.sort.heapsort.HeapSort;
public class TopK {
    public static void main(String[] args){
        //最小堆实现从大到小排序
        int[] arrSort = {90,3,60,6,7,2,89,100,33,5};
        MinHeap heap1 = new MinHeap(arrSort);
        for(int i = arrSort.length - 1;i > 0; i --){
            //把最小的元素移到末尾
            heap1.swap(0, i);
            //重新构造最小堆
            heap1.buildHeap(i);
        }
        //打印排序后的数组
        for(int i = 0; i < arrSort.length;i ++){
            System.out.println(arrSort[i]);
        }

        //最小堆实现topK
        int[] arrTopK = {90,44,60,6,71,2,38,13,33,5};
        int k = 3;
        //创建一个大小为k的数组
        int[] data = new int[k];
        for(int i = 0; i < k; i ++){
            data[i] = arrTopK[i];
        }
        MinHeap heap = new MinHeap(data);
        for(int i = k; i < arrTopK.length; i ++){
            //如果大于堆顶的元素则替换顶并重新构造
            if(arrTopK[i] > heap.getRoot()) heap.setRoot(arrTopK[i]);
        }
        //打印最大的k个数
        for(int i = 0; i < k; i ++){
            System.out.println(data[i]);
        }
    }

    //最小堆类
    static class MinHeap{
        private int[] data;
        public MinHeap(int[] data){
            this.data = data;
            buildHeap(data.length);
        }

        public void buildHeap(int heapSize){
            for(int i = heapSize / 2 - 1; i >= 0;i --){
                heapify(i, heapSize);
            }
        }

        public void heapify(int index,int heapSize){
            int right = right(index);

            int left = left(index);

            int min = index;

            if(right < heapSize && data[right] < data[min]) min = right;

            if(left < heapSize && data[left] < data[min]) min = left;

            if(min == index) return;

            swap(index,min);

            heapify(min,heapSize);
        }

        private int right(int index){
            //右儿子的下标
            return (index + 1) << 1;
        }

        private int left(int index){
            //左儿子的下标
            return ((index + 1) << 1) - 1;
        }

        public void swap(int index1,int index2){
            int tmp = data[index1];
            data[index1] = data[index2];
            data[index2] = tmp;
        }

        public int getRoot(){
            return data[0];
        }

        public void setRoot(int root){
            data[0] = root;
            heapify(0, data.length);
        }
    }
}