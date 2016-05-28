using System;

namespace ConsoleApplication
{
  public class MaxIntPQ
  {
      private BinaryHeap _binHeap;

      public MaxIntPQ(BinaryHeap binHeap){ _binHeap = binHeap; }
      public void BuildMaxPQ() { _binHeap.BuildMaxHeap(); }
      public void PrintPQ() { _binHeap.PrintBinaryHeap(); }

    }
}
