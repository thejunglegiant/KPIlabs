using System;

namespace lab5 {
    public class Program {
        static void Main(string[] args) {
            Rectangle rect = new Rectangle(
                new double[,] {
                    {1.0, 2.0}, {4.0, 5.0}
                }
            );

            rect.getInfo();
            Console.WriteLine("Area: " + rect.getArea());
            Console.WriteLine("Perimeter: " + rect.getPerimeter());
        }
    }
}
