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
        JFrame frame = new JFrame("This is " + sortAlgo.getClass().getName() + " visualizer");
        Visualize vb = new Visualize(1000, 1000, Color.GREEN);
        frame.add(vb);
        frame.setSize(1200, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        vb.startSorting(this.sortAlgo);
    }
}
