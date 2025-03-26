package visualizer;

import sorting.SortBase;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Visualize extends JPanel {

        private int[] array;
        private int delay;
        private Color color;
        private long startTime;
        private JLabel timerLabel;

        public Visualize(int arraySize, int delay, Color color) {
            array = new int[arraySize];
            Random random = new Random();
            for (int i = 0; i < arraySize; ++i) this.array[i] = random.nextInt(800);
            this.delay = delay;
            this.color = color;
            setupUI();
        }

        public Visualize(int[] arr, int delay, Color color) {
            array = arr;
            this.delay = delay;
            this.color = color;
            setupUI();
        }

        private void setupUI() {
            setLayout(new BorderLayout());
            timerLabel = new JLabel("Time: 0ms");
            timerLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
            timerLabel.setForeground(Color.YELLOW);
            timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(timerLabel, BorderLayout.NORTH);
        }

        @Override
        protected void paintComponent(Graphics g) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            int barWidth = panelWidth / array.length;
            int maxValue = 1000;
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            for (int i = 0; i < array.length; i++) {
                int barHeight = (int) ((double) array[i] / maxValue * panelHeight);
                g.setColor(color);
                g.fillRect(i * barWidth, panelHeight - barHeight, barWidth - 1, barHeight);
            }
        }

        public int[] getArray() {
            return this.array;
        }

        public int getDelay() {
            return this.delay;
        }

        public void startSorting(SortBase algorithm) {
            startTime = System.currentTimeMillis();
            timerLabel.setText("Time: 0ms");

            Timer timer = new Timer(100, e -> {
                long elapsedTime = System.currentTimeMillis() - startTime;
                timerLabel.setText("Time: " + elapsedTime + "ms");
            });
            timer.start();
            new Thread(() -> {
                algorithm.sort(this);
                timer.stop();
            }).start();
        }

}
