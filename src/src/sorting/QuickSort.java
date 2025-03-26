package sorting;

import visualizer.Visualize;

public class QuickSort implements SortBase {
    // this is also a divide and conquer approach.
    @Override
    public void sort(Visualize base) {
        int[] array = base.getArray();
        int n = array.length;
        quickSort(array, 0, n - 1, base);
    }

    private void quickSort(int[] arr, int left, int right, Visualize v) {
        int idx = partition(arr, left, right, v);
        if (idx-1 > left) quickSort(arr, left, idx - 1, v);
        if (right > idx) quickSort(arr, idx, right, v);
    }

    private int partition(int[] arr, int left, int right, Visualize v) {
        int pivot = arr[left + (right - left) / 2];
        while (left <= right) {
            while (pivot > arr[left]) ++left;
            while (pivot < arr[right]) --right;
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                ++left;
                --right;
                this.frameRefresh(v);
            }
        }
        return left;
    }
}
