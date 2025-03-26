import sorting.MergeSort;
import sorting.QuickSort;
import sorting.SelectionSort;
import sorting.SortBase;
import visualizer.Visualizer;

public class Driver {
    public static void main(String[] args) {
        SortBase sortingAlgo = new QuickSort();
        Visualizer algoVisualizer = new Visualizer(sortingAlgo);
        algoVisualizer.visualize();
    }
}