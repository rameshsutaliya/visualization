import sorting.MergeSort;
import sorting.SelectionSort;
import sorting.SortBase;
import visualizer.Visualizer;

public class Driver {
    public static void main(String[] args) {
        SortBase sortingAlgo = new MergeSort();
        Visualizer algoVisualizer = new Visualizer(sortingAlgo);
        algoVisualizer.visualize();
    }
}