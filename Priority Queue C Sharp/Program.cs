using System;

namespace ConsoleApplication
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] a = { 45, 78, -9, 67, 12, 14, 6, 0 };
            BinaryHeap bHeap = new BinaryHeap(a);

            MaxIntPQ maxPQ = new MaxIntPQ(bHeap);
            MinIntPQ minPQ = new MinIntPQ(bHeap);

            Console.WriteLine("Testing MaxPQ :::: ");
            maxPQ.BuildMaxPQ();
            maxPQ.PrintPQ();

            Console.WriteLine("\n\nTesting MinPQ :::: ");
            minPQ.BuildMinPQ();
            minPQ.PrintPQ();

            Console.ForegroundColor = ConsoleColor.Red;
            Console.WriteLine("\n\nPress any key to exit ... ... ...");
            Console.ReadLine();

        }
    }
}
