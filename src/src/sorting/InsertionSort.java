package sorting;

import visualizer.Visualize;

public class InsertionSort implements SortBase{
    // assume that current array is sorted, now we need to insert the new element at it's proper place.
    @Override
    public void sort(Visualize base) {
        int[] array = base.getArray();
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int j = i-1;
            int curr = array[i];
            while(j>=0 && array[j]>curr) {
                array[j+1]=array[j--];
                this.frameRefresh(base);
            }
            array[j+1]=curr;
        }
    }

}
