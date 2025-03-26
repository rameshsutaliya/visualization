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
        int[] array = base.getArray();
        int mx = this.gerMax(array);
        for (int exp = 1; mx/exp > 0; exp*=10){
            countingSort(array, exp, base);
        }
    }

    private void countingSort(int[] arr, int exp, Visualize visualize) {
        int[] count = new int[10]; // for 0 to 9 digit count.
        int[] helper = new int[arr.length];

        // keeping the digit occurrance
        for (int i=0;i<arr.length;++i) count[(arr[i]/exp)%10]++;

        // calculate actual position
        for (int i = 1; i < 10; ++i) count[i]+=count[i-1];
//        System.out.println(Arrays.toString(count));


        // Generating the current digit wise sorted array.
        for (int i = arr.length-1; i >= 0; --i) {
            int idx= (arr[i]/exp)%10;
            helper[count[idx]-1]=arr[i];
            count[idx]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i]=helper[i];
            this.frameRefresh(visualize);
        }
    }

    private int gerMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) if(max<arr[i]) max = arr[i];
        return max;
    }
}
