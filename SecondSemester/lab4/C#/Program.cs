using System;

namespace lab4 {
    public class Program {
        static void Main(string[] args) {
            Line C1 = new Line(0);
            Line C2 = new Line("15");
            Line C3 = new Line(C2);

            C1 = C2 - '5' + C3;

            Console.WriteLine("The end result: " + C1.getString());
        }
    }
}
