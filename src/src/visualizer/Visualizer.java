package visualizer;

import sorting.SortBase;

import javax.swing.*;
import java.awt.*;

public class Visualizer {
    SortBase sortAlgo;

    public Visualizer(SortBase sorting) {
        this.sortAlgo = sorting;
    }

    public void visualize() {
        JFrame frame = new JFrame("This is " + sortAlgo.getClass().getSimpleName() + " visualizer");
        Visualize vb = new Visualize(1200, 1000000, Color.GREEN);
        frame.add(vb);
        frame.setSize(1200, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        vb.startSorting(this.sortAlgo);
    }
}
