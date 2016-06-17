using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Quick_Sort
{
    class QuickSort<T> where T : IComparable
    {
        // private prop

        private T[] _dataArray;
        private int _len;
        private int _startIndex;
        private int _endIndex;

        // public prop

        public T[] DataArray { get { return _dataArray; } set { _dataArray = value; } }
        public int Len { get { return _len; } }
        public int StartIndex { get { return _startIndex; } }
        public int EndIndex { get { return _endIndex; } }


        // default constructor
        public QuickSort()
        {
            _dataArray = null;
            _len = _startIndex = _endIndex = 0;
        }

        // working constructor
        public QuickSort(T[] dataArray)
        {
            _dataArray = dataArray;
            _len = _dataArray.Length;
            _startIndex = 0;
            _endIndex = _len - 1;
        }

        // partition first!

       

       // print
        public void printData()
        {
            foreach (var item in _dataArray)
            {
                Console.Write(item + "  ");
            }
            Console.WriteLine();
        }
    }
}
