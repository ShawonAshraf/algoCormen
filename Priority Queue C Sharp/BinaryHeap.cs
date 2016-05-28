using System;

namespace ConsoleApplication
{
    public class BinaryHeap
    {
        private int[] _a;
        private int _length;
        private int _heapSize;

        //=====================

        public BinaryHeap() {}

        public BinaryHeap(int[] a)
        {
            _a = a;
            _length = a.Length;
            _heapSize = _length;
        }

        //======================

        public int[] A
        {
            get
            { return A; }
            set
            { value = _a; }
        }

        public int Length { get { return _length; } set { value = _length; } }
        public int HeapSize { get { return _heapSize; } set { value = _heapSize; } }

        //===============================

        public int GetRootIndex() { return 0; }
        public int GetLeftSubIndex(int i) { return ((2 * i) + 1); }
        public int GetRightSubIndex(int i) { return ((2 * i) + 2); }
        public int GetParentIndex(int i) { return (i / 2); }

        //==============================

        public void MaxHeapify(int i) {
          int leftSubIndex = GetLeftSubIndex(i);
          int rightSubIndex = GetRightSubIndex(i);
          int largestElementIndex;

          if ((leftSubIndex < _heapSize) && _a[leftSubIndex] > _a[i]) largestElementIndex = leftSubIndex;
          else largestElementIndex = i;

          if (rightSubIndex < _heapSize && _a[rightSubIndex] > _a[largestElementIndex]) largestElementIndex = rightSubIndex;

          if(largestElementIndex != i) {
              // swap
              int temp = _a[i];
              _a[i] = _a[largestElementIndex];
              _a[largestElementIndex] = temp;

              // call max heapify again
              MaxHeapify(largestElementIndex);
            }
        }

        public void BuildMaxHeap() {
          for(int i = (_length / 2) - 1; i >= 0; i--) {
              MaxHeapify(i);
            }
        }

        public void MinHeapify(int i) {
          int leftSubIndex = GetLeftSubIndex(i);
          int rightSubIndex = GetRightSubIndex(i);
          int smallestElementIndex;

          if ((leftSubIndex < _heapSize) && _a[leftSubIndex] < _a[i]) smallestElementIndex = leftSubIndex;
          else smallestElementIndex = i;

          if (rightSubIndex < _heapSize && _a[rightSubIndex] < _a[smallestElementIndex]) smallestElementIndex = rightSubIndex;

          if(smallestElementIndex != i) {
              // swap
              int temp = _a[i];
              _a[i] = _a[smallestElementIndex];
              _a[smallestElementIndex] = temp;

              // call min heapify again
              MinHeapify(smallestElementIndex);
            }
        }

        public void BuildMinHeap() {
          for(int i = (_length / 2) - 1; i >= 0; i--) {
              MinHeapify(i);
          }
        }

        public void PrintBinaryHeap()
        {
            Console.Write("Heap Data : [ ");
            foreach (var h in A)
            {
              Console.Write(h + ", ");
            }
            Console.WriteLine(" ]");
        }
    }
}
