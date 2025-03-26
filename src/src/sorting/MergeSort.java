package sorting;

import visualizer.Visualize;

public class MergeSort implements SortBase {
    // Basically divide and conquer.
    @Override
    public void sort(Visualize base) {
        int[] array = base.getArray();
        int n = array.length;
        mergesort(array, new int[n], 0, n-1, base);
    }

    private void mergesort(int[] arr, int[] helper, int left, int right, Visualize v) {
        if (left < right) {
            int mid = left + (right - left)/2;
            mergesort(arr, helper, left, mid,v);
            mergesort(arr, helper, mid + 1, right,v);
            merge(arr, helper, left, mid, right,v);
        }
    }

    private void merge(int[] arr, int[] help, int left, int mid, int right, Visualize visualize) {
        // Coping both half of the array
        for (int i=left;i<=right;++i) help[i]=arr[i];
        int larr = left, rarr=mid+1, curr = left;
        while(larr<=mid && rarr<=right) {
            if (help[larr]<=help[rarr]) arr[curr]=help[larr++];
            else arr[curr]=help[rarr++];
            this.frameRefresh(visualize);
            ++curr;
        }
        int temp = mid-larr;
        // Only left side array require the copy as right side is already there in array.
        for (int i = 0; i <= temp; i++) {
            arr[curr+i]=help[larr+i];
            this.frameRefresh(visualize);
        }
    }

}
