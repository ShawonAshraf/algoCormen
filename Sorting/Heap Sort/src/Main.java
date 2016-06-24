public class Main {

    public static void main(String[] args) {
        int[] a = {5, 13, 2, 25, 7, 17, 20, 8, 4};
        int[] b = {1, 2, 3, 4, 7, 8, 9, 10, 14, 16};


        BinaryHeap bh = new BinaryHeap(a);

        System.out.println("Before ::: ");
        bh.printBinaryHeap();
        System.out.println();

        //bh.heapSort();
        //bh.heapSortAscending();
        System.out.println("After ::: ");
        //bh.printBinaryHeap();
        System.out.println();
        bh.heapSortDescending();
        bh.printBinaryHeap();
    }
}
