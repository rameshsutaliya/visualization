package sorting;

import visualizer.Visualize;

public class BubbleSort implements SortBase{
    @Override
    public void sort(Visualize base) {
        int[] array = base.getArray();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j+1]<array[j]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j]=temp;
                    base.repaint();
                    this.frameRefresh(base);
                }
            }
        }
    }
}
