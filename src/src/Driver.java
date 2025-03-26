import sorting.BubbleSort;
import sorting.SortBase;
import visualizer.Visualizer;

public class Driver {
    public static void main(String[] args) {
        SortBase sortingAlgo = new BubbleSort();
        Visualizer algoVisualizer = new Visualizer(sortingAlgo);
        algoVisualizer.visualize();
    }
}