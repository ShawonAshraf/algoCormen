using System;

namespace Merge_Sort
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = {2, 4, 5, 7, 1, 2, 3, 6};
            MergeSort mergeSort = new MergeSort(array);
            Console.WriteLine("Before sorting : " + mergeSort.ToString());
            Console.WriteLine("\n==========\n\n");

            mergeSort.Sort();
            Console.WriteLine("After Sorting   : " + mergeSort.ToString());

            Console.WriteLine();
            Console.WriteLine("Press any key to exit .........");
            Console.ReadLine();
        }
    }
}
