using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Merge_Sort
{
    class MergeSort
    {
        private int[] _a;
        private int _s; // size of the array
        private int _dividingIndex;

        public MergeSort()
        {
            _a = null;
            _s = 0;
            _dividingIndex = 0;
        }

        public MergeSort(int[] a)
        {
            _a = a;
            _s = a.Length;
            _dividingIndex = (int)Math.Floor((decimal)_s/2);
        }

        public void Sort()
        {
            
        }


        public void Merge()
        {
            
        }


    }
}
