using System;

namespace lab7 {
    public class Program {
        public static void Main(string[] args) {
            int[] arr = {1, 43, 6, 324, 2, 8, 90};
            Line line = new Line(arr);
            line.LineOverloadEvent += LineOverload;
            line.push(99);
            line.remove();
            line.push(99);
            line.push(99);
        }

        private static void LineOverload() {
            Console.WriteLine("Line has been overloaded!");
        }
    }
}
