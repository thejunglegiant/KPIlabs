using System;

namespace lab8 {
    public class Program {
        private static void Main(string[] args) {
            LinkedList list = new LinkedList();
            Random rand = new Random();

            for (int i = 1; i < 10; i++)
                list.push(rand.Next(100));

            list.printList();
            Console.WriteLine("Amount of numbers which are multiples of five: "
                + list.findAllMultiplesOfFive());
            list.deleteAllAfterMax();
            list.printList();
            list.pop();
            list.printList();
        }
    }
}
