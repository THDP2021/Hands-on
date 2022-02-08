package com.logic.Binary_Insertion_Sort;

public class BinaryInsertionSort {
    public static void binaryInsertionSort(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; ++i) {
            int key = nums[i];
            int insertedPosition = findPosition(nums, 0, i - 1, key);

            for (int j = i - 1; j >= insertedPosition; --j) {
                nums[j + 1] = nums[j];
            }

            nums[insertedPosition] = key;
        }
        for (int i = 0; i<length; ++i){
            System.out.println(nums[i]);
        }
    }

    public static int findPosition(int[] nums, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{10, 9, 8, 7, 4, 5, 3, 2, 1, 6};
        BinaryInsertionSort.binaryInsertionSort(nums);
    }
}



