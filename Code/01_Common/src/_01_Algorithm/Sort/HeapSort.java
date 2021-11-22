package _01_Algorithm.Sort;

import java.util.Arrays;

/**
 * 大顶堆-->升序排列
 *
 * http://www.cnblogs.com/chengxiao/p/6129630.html
 * （1）首先要定义大顶堆：arr[0...n-1] 则 arr[i] > arr[2*i+1] 并且 arr[i] > arr[2*i+2]
 * （2）对于最开始的数组生成一个大顶堆：从最后一个非叶子节点开始调整
 * （3）对于生成的大顶堆，根节点元素是整个数组中最大的元素
 *      （i）首先将根节点元素和数组最后一个元素置换，则最后一个元素是最大的元素【有一点冒泡排序的处理味道】
 *      （ii）上面的操作会打乱大顶堆，所以需要对于arr[0...n-2]重新生成大顶堆
 * （4）堆排序中涉及到的树的概念，但是并没有显示的存储树，而是根据数组元素位置和树节点之间的对应关系调整假想中的树，有点意思
 *
 * 堆排序可以用来解决topK问题：从100W个数中找到最大的K个数
 * （1）首先对于数组前k个数建立一个小顶堆
 * （2）然后从第k个数到最后一个数，如果数比堆顶元素大，那么交换
 * （3）调整小顶堆的顶部元素
 * （4）最后得到的小顶堆就是从小到大的元素
 */
public class HeapSort {

    public static void heapSort(int[] arr){
        //0. 首先是建立一个大顶堆
        for(int i=arr.length/2-1; i >=0 ; i--){ //1.从第一个非叶子节点开始，直到顶端root节点
            adjustHeap(arr,i,arr.length);
        }

        //1. 然后不断交换元素,缩小大顶堆
        for(int j=arr.length-1;j > 0; j--){ //2. 将大顶堆第一个元素和最后一个元素替换，替换之后重新调整堆
            swap(arr,0,j);
            adjustHeap(arr,0,j); //这里只需要调整被打乱的根节点即可
        }
    }

    //3. 参数：数组本身，调整节点的下标，数组的长度
    public static void adjustHeap(int[] arr, int i, int length){ //i的含义：调整树中第i个节点【和左右子树对比】
        int temp = arr[i];
        for(int k = 2*i+1; k < length; k = 2*k+1){
            if(k+1 < length && arr[k] < arr[k+1]) //找到左右子树中最大的【反证：如果左子树<右子树，那么交换之后根节点还是小于右子树】
                k += 1;

            if(arr[k] > temp){ //对比子树和父节点
                arr[i] = arr[k];
                i = k; //注意为什么每次要改变i的值
            }else{
                break; //不需要调整，完事
            }
        }
        arr[i] = temp; //归位
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args){
        int[] arr = {9,8,7,6,5,4,3,2,1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
