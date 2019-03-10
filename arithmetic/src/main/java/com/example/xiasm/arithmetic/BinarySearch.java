package com.example.xiasm.arithmetic;

/**
 * 二分查找也称折半查找（Binary Search），它是一种效率较高的查找方法。
 * 但是，折半查找要求线性表必须采用顺序存储结构，而且表中元素按关键字有序排列。
 */
public class BinarySearch {

    public static int binSearch(int[] src, int value, int left, int right) {
        int mid = (right - left) / 2 + left;
        if (src[mid] == value) {
            return mid;
        }
        if ((right - left) == 1) {
            if (value == src[left]) {
                return left;
            } else if (value == src[right]) {
                return right;
            } else {
                return -1;
            }
        }
        if (left >= right) {
            return -1;
        } else if (value > src[mid]) {
            return binSearch(src, value, mid, right);
        } else if (value < src[mid]) {
            return binSearch(src, value, left, mid);
        }
        return -1;
    }


    public static int binarySearch(int[] src, int value, int left, int right) {
        int result = -1;
        int mid = (right + left) >> 1;

        if (mid == left || mid == right || value == src[mid]) {
            if (value <= src[left] && value <= src[right]) {
                return left;
            } else if (value <= src[right] && value >= src[left]) {
                return right;
            } else {
                return right + 1;
            }
        }

        if (value > src[mid]) {
            result = binarySearch(src, value, mid + 1, right);
        }
        if (value < src[mid]) {
            result = binarySearch(src, value, left, mid - 1);
        }
        return result;
    }
}
