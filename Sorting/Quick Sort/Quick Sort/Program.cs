using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Quick_Sort
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = { -45, 100, 2, 89, -1, 7, 54, -3 };

            QuickSort(arr, 0, arr.Length - 1);

            Console.WriteLine("\nPress any key to exit .....");
            Console.ReadLine();
        }

        static int Partition(int[] arr, int p, int r)
        {
            int i =  p - 1;
            int x = arr[r];

            for(int j = p; j < r; j++)
            {
                if (arr[j] <= x)
                {
                    i++;

                    // swap
                    arr[j] = Swap(arr[i], arr[i] = arr[j]);
                }
            }
            arr[r] = Swap(arr[i + 1], arr[i + 1] = arr[r]);

            return i + 1;
        }

        static void QuickSort(int[] arr, int p, int r)
        {
            if(p < r)
            {
                int q = Partition(arr, p, r);
                QuickSort(arr, p, q - 1);
                QuickSort(arr, q + 1, r);
            }
            Console.ForegroundColor = ConsoleColor.Green;
            Console.Write("Call() returned  : ");

            Console.ForegroundColor = ConsoleColor.White;
            PrintArray(arr);
            
        }

        static int Swap(int x, int y)
        {
            return x;
        }

        static void PrintArray(int[] a)
        {
            foreach (var i in a)
            {
                Console.Write(i + "  ");
            }
            Console.WriteLine();
        }
    }
}
