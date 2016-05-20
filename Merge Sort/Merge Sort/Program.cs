using System;

namespace Merge_Sort
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array1 = {2, 4, 5, 7, 1, 2, 3, 6};
            int[] array2 = {1, -1, 5, 100, 89, 2, 90, 110, -100};

            MergeSort s1 = new MergeSort(array1);
            MergeSort s2 = new MergeSort(array2);

            Console.ForegroundColor = ConsoleColor.Cyan;
            Console.WriteLine("s1 :::::: ");
            Console.WriteLine("Before sorting : " + s1.ToString());
            s1.Sort();
            Console.WriteLine("After Sorting : " + s1.ToString());

            Console.ForegroundColor = ConsoleColor.Red;
            Console.WriteLine("\n\n=================\n\n");

            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("s2 :::::: ");
            Console.WriteLine("Before sorting : " + s2.ToString());
            s2.Sort();
            Console.WriteLine("After Sorting : " + s2.ToString());


            Console.WriteLine("\n\n");
            Console.ForegroundColor = ConsoleColor.White;
            Console.WriteLine("Press any key to exit .........");
            Console.ReadLine();
        }
    }
}
