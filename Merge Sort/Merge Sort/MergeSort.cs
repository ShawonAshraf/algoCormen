using System;

namespace Merge_Sort
{
    class MergeSort
    {
        private int[] _a;
        private int _s; // size of the array

        public MergeSort()
        {
            _a = null;
            _s = 0;
        }

        public MergeSort(int[] a)
        {
            _a = a;
            _s = a.Length;
        }

        public void Sort()
        {
            _sort(0, _s - 1);
        }

        public override string ToString()
        {
            string x = "";
            foreach (var a in _a) x += a + " ";
            
            return x;
        }


        private void _sort(int startIndex, int endIndex)
        {
            if (startIndex < endIndex)
            {
                int q = (int) Math.Floor((decimal) ((startIndex + endIndex)/2.0));
                _sort(startIndex, q);
                _sort(q + 1, endIndex);
                _merge(startIndex, q, endIndex);
            }
        }


        private void _merge(int startIndex, int divideIndex, int endIndex)
        {
            int leftSubArrayRange = divideIndex - startIndex + 1;
            int rightSubArrayRange = endIndex - divideIndex;

            int[] leftSubArray = new int[leftSubArrayRange + 1];
            int[] rightSubArray = new int[rightSubArrayRange + 1];

            // insert sentinels
            leftSubArray[leftSubArrayRange] = 1000000;
            rightSubArray[rightSubArrayRange] = 1000000;

            // populate left subarray
            for (int i = 0; i < leftSubArrayRange; i++)
            {
                leftSubArray[i] = _a[i];
            }

            // right sub array
            for (int i = rightSubArrayRange; i < _s; i++)
            {
                rightSubArray[i] = _a[i];
            }

            for (int i = 0, j = 0, k = 0; k < endIndex; k++)
            {
                if (leftSubArray[i] <= rightSubArray[j])
                {
                    _a[k] = leftSubArray[i];
                    i++;
                }
                else
                {
                    _a[k] = rightSubArray[j];
                    j++;
                }
            }
        }
    }
}
