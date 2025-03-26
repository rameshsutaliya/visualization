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
            /**
             * There is a limitation with visualization here, if have the array.length>frameWidth in that case for a
             * particular element we will be having the zero width rectangle and resulted we will not be draw it.
             * */
            int barWidth = panelWidth / array.length;
            int maxValue = 1000;
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            for (int i = 0; i < array.length; i++) {
                int barHeight = (int) ((double) array[i] / maxValue * panelHeight);
                g.setColor(color);
                // if the barWidth==0 we will not able to draw any rectangle.
                g.fillRect(i * barWidth, panelHeight - barHeight, barWidth, barHeight);
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
                // Just to verify after sorting is done.
//                System.out.println(Arrays.toString(this.array));
                timer.stop();
            }).start();
        }

}
