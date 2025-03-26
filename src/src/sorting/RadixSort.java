package sorting;

import visualizer.Visualize;

public class RadixSort implements SortBase{
    /** Radix algorithm basically used for the integers or similar property data structures.
     * It takes advantage of the fact that integers have a finite number of bits.
     * In Radix sort, Iterate through each digit of the number, and grouping numbers by each digit.
     *
     * Comparison sorting algorithms takes on average O(n.log(n)) and they can't be better than this, but in Radix sort
     * we get the average time complexity as: O(kn), where n=size, and k=passes of sorting algo.
     */
    @Override
    public void sort(Visualize base) {

    }
}
