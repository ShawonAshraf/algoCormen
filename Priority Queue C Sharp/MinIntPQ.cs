using System;

namespace ConsoleApplication
{
    public class MinIntPQ
    {
        private BinaryHeap _binHeap;

        public MinIntPQ(BinaryHeap binHeap) { _binHeap = binHeap; }
        public void BuildMinPQ() { _binHeap.BuildMaxHeap(); }
        public void PrintPQ() { _binHeap.PrintBinaryHeap(); }
    }
}
