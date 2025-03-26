package sorting;

import visualizer.Visualize;

import java.time.Duration;
import java.util.Arrays;

public interface SortBase {

    default void frameRefresh(Visualize visualize) {
        visualize.repaint();
        try {
            Thread.sleep(Duration.ofNanos(visualize.getDelay()));
        } catch (InterruptedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    void sort(Visualize base);
}
