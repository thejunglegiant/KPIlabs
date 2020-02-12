using System;
using static lab1.Functions;

namespace lab1 {
    class Program {
        static void Main(string[] args) {
            // Test sets
            int[] incrementTest = {63, -18, 92};
            int[,] compareTest = new int[,] {{11,11}, {84,-2}, {61,107}};

            // Increment function test
            Console.WriteLine(Increment(incrementTest[0]));
            Console.WriteLine(Increment(incrementTest[1]));
            Console.WriteLine(Increment(incrementTest[2]) + "\n");

            // Equality function test
            Console.WriteLine(CompareBinaries(compareTest[0,0], compareTest[0,1])
                ? "Numbers are equal" : "Numbers are not equal");
            Console.WriteLine(CompareBinaries(compareTest[1,0], compareTest[1,1])
                ? "Numbers are equal" : "Numbers are not equal");
            Console.WriteLine(CompareBinaries(compareTest[2,0], compareTest[2,1])
                ? "Numbers are equal" : "Numbers are not equal");
        }
    }
}