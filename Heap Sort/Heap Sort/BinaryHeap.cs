using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Heap_Sort
{
    class BinaryHeap
    {
        private int[] _a;
        private int _length;

        public BinaryHeap()
        {
        }

        public BinaryHeap(int[] a)
        {
            _a = a;
            _length = a.Length;
        }

        //===================
        public int GetRoot()
        {
            return _a[0];
        }

        public int GetLeftElement(int i)
        {
            return _a[(2 * i) - 1];
        }

        public int GetRightElement(int i)
        {
            return _a[2*i];
        }

        public int GetParent(int i)
        {
            return _a[i/2];
        }

        //=============================
        public void MaxHeapify(int i)
        {
            
        }

        public void MinHeapify(int i)
        {
            
        }

        public void HeapSortAscending()
        {
            
        }

        public void HeapSortDescending()
        {
            
        }

    }
}
