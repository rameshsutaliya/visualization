import sorting.SortBase;
import sorting.RadixSort;
import visualizer.Visualizer;

public class Driver {
    public static void main(String[] args) {
        SortBase sortingAlgo = new RadixSort();
        Visualizer algoVisualizer = new Visualizer(sortingAlgo);
        algoVisualizer.visualize();
    }
}