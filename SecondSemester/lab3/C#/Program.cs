using System;

namespace lab3 {
    class Program
    {
        static void Main(string[] args)
        {
            int n = 4;
            int m = 4;
            Indexer indexer = new Indexer(createArray(n, m), n, m);
            indexer.printArray();
            Console.WriteLine("\nRMS of all elements of the row: " + indexer[2]);
            Console.WriteLine("\nSum of all elements: " + indexer.sumAll);
        }

        static int[,] createArray(int n = 4, int m = 4) {
            Random rand = new Random();
            int[,] arr = new int[n,m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    arr[i,j] = (int)(rand.NextDouble() * 10);
                }
            }

            return arr;
        }
    }
}
