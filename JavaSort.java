package com.cnc.cbss.foundation.user.web;

import java.util.Arrays;

/**
 * Created by zh on 2017/2/21.
 */
public class JavaSort {

    private JavaSort() {
        super();
    }

    /**
     * 1.冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param numbers 需要排序的整型数组
     */
    public static void bubbleSort(int[] numbers) {
        int temp = 0;
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1])  //交换两数位置
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 2.快速排序<br/>
     * <ul>
     * <li>从数列中挑出一个元素，称为“基准”</li>
     * <li>重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，
     * 该基准是它的最后位置。这个称为分割（partition）操作。</li>
     * <li>递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。</li>
     * </ul>
     *
     * @param numbers 带查找数组
     * @param start   开始位置
     * @param end     结束位置
     */
    public static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end)) {
                    i++;
                }

                while ((numbers[j] > base) && (j > start)) {
                    j--;
                }

                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);

            if (start < j) {
                quickSort(numbers, start, j);
            }

            if (end > i) {
                quickSort(numbers, i, end);
            }

        }

    }

    /**
     * 3.选择排序<br/>
     * <li>在未排序序列中找到最小元素，存放到排序序列的起始位置</li>
     * <li>再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。</li>
     * <li>以此类推，直到所有元素均排序完毕。</li>
     *
     * @param numbers
     */
    public static void selectSort(int[] numbers) {
        int size = numbers.length, temp;
        for (int i = 0; i < size; i++) {
            int k = i;
            for (int j = size - 1; j > i; j--) {
                if (numbers[j] < numbers[k]) k = j;
            }
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
    }

    /**
     * 4.插入排序<br/>
     * <ul>
     * <li>从第一个元素开始，该元素可以认为已经被排序</li>
     * <li>取出下一个元素，在已经排序的元素序列中从后向前扫描</li>
     * <li>如果该元素（已排序）大于新元素，将该元素移到下一位置</li>
     * <li>重复步骤3，直到找到已排序的元素小于或者等于新元素的位置</li>
     * <li>将新元素插入到该位置中</li>
     * <li>重复步骤2</li>
     * </ul>
     * 插入排序是稳定的
     * 时间复杂度：O（n^2）
     *
     * @param numbers
     */
    public static void insertSort(int[] numbers) {
        int size = numbers.length, temp, j;
        for (int i = 1; i < size; i++) {
            temp = numbers[i];
            for (j = i; j > 0 && temp < numbers[j - 1]; j--)
                numbers[j] = numbers[j - 1];
            numbers[j] = temp;
        }
    }

    /**
     * 5.希尔排序
     * 希尔排序的原理:根据需求，如果你想要结果从大到小排列，它会首先将数组进行分组，然后将较大值移到前面，较小值
     * 移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，可以说希尔排序是加强
     * 版的插入排序
     * 拿数组5, 2, 8, 9, 1, 3，4来说，数组长度为7，当increment为3时，数组分为两个序列
     * 5，2，8和9，1，3，4，第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较
     * 此例子是按照从大到小排列，所以大的会排在前面，第一次排序后数组为9, 2, 8, 5, 1, 3，4
     * 第一次后increment的值变为3/2=1,此时对数组进行插入排序，
     * 实现数组从大到小排
     * 希尔排序方法是一个不稳定的排序方法
     *
     */

    public static void shellSort(int[] data) {
        int j = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i; j >= increment; j -= increment) {
                    if (temp > data[j - increment]) { //如想从小到大排只需修改这里
                        data[j] = data[j - increment];
                    } else {
                        break;
                    }

                }
                data[j] = temp;
            }
        }
    }

    /**
     * 6.归并排序
     * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
     * 时间复杂度为O(nlogn)
     * 稳定排序方式
     *
     * @param nums 待排序数组
     * @return 输出有序数组
     */
    public static int[] sort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            sort(nums, low, mid);
            // 右边
            sort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
        return nums;
    }

    /**
     * 将数组中low到high位置的数进行排序
     *
     * @param nums 待排序数组
     * @param low  待排的开始位置
     * @param mid  待排中间位置
     * @param high 待排结束位置
     */
    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
                99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        //bubbleSort(a);
        //quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
