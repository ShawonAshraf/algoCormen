import java.util.Arrays;

/**
 * Created by shawon on 5/24/16.
 */
public class BinaryHeap {
    private int[] a;
    private int length;
    private int heapSize;

    public BinaryHeap() {}
    public BinaryHeap(int[] a) {
        this.a = a;
        length = a.length;
        heapSize = length;
    }

    //=======================

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    //================
    public int getRootIndex() { return 0; }
    public int getLeftSubIndex(int i) { return ((2 * i) + 1); }
    public int getRightSubIndex(int i) { return ((2 * i) + 2); }
    public int getParentIndex(int i) { return (i / 2); }

    //=============================

    public void maxHeapify(int i) {
        int leftSubIndex = getLeftSubIndex(i);
        int rightSubIndex = getRightSubIndex(i);
        int largestElementIndex;

        if ((leftSubIndex < heapSize) && a[leftSubIndex] > a[i]) largestElementIndex = leftSubIndex;
        else largestElementIndex = i;

        if (rightSubIndex < heapSize && a[rightSubIndex] > a[largestElementIndex]) largestElementIndex = rightSubIndex;

        if(largestElementIndex != i) {
            // swap
            int temp = a[i];
            a[i] = a[largestElementIndex];
            a[largestElementIndex] = temp;

            // call max heapify again
            maxHeapify(largestElementIndex);
        }
    }

    public void buildMaxHeap() {
        for(int i = (length / 2) - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void minHeapify(int i) {
        int leftSubIndex = getLeftSubIndex(i);
        int rightSubIndex = getRightSubIndex(i);
        int smallestElementIndex;

        if ((leftSubIndex < heapSize) && a[leftSubIndex] < a[i]) smallestElementIndex = leftSubIndex;
        else smallestElementIndex = i;

        if (rightSubIndex < heapSize && a[rightSubIndex] < a[smallestElementIndex]) smallestElementIndex = rightSubIndex;

        if(smallestElementIndex != i) {
            // swap
            int temp = a[i];
            a[i] = a[smallestElementIndex];
            a[smallestElementIndex] = temp;

            // call min heapify again
            minHeapify(smallestElementIndex);
        }
    }

    public void buildMinHeap() {
        for(int i = (length / 2) - 1; i >= 0; i--) {
            minHeapify(i);
        }
    }

    //========================
    public void heapSortAscending() {
        buildMaxHeap();

        for(int i = length - 1; i >= 1; i--) {
            // swap
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapSize--;

            // call maxHeapify
            maxHeapify(0);
        }
    }

    public void heapSortDescending() {
        buildMinHeap();

        for(int i = length - 1; i >= 1; i--) {
            // swap
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapSize--;

            // call minHeapify
            minHeapify(0);
        }
    }

    //==================

    public void printBinaryHeap() {
        System.out.println("Binary Heap contains : " + Arrays.toString(a));
    }

}
