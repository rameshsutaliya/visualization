package sorting;

import visualizer.Visualize;

public class SelectionSort implements SortBase{
    /**
     * Find the smallest element of the array and place at start, now continue with next index, find min, place at start.
     * */
    @Override
    public void sort(Visualize base) {
        int[] array = base.getArray();
        int n=array.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (array[j]<array[min]) min=j;
            }
            int mv = array[min];
            while(min>i) {
                array[min]=array[min-1];
                --min;
                this.frameRefresh(base);
            }
            array[i]=mv;
        }
    }
}
