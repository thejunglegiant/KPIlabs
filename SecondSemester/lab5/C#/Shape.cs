using System;

namespace lab5 {
    public class Shape {
        public double[,] coord;

        public Shape(double[,] coord) {
            this.coord = coord;
        }

        public double getLength(double x, double y, double a, double b) {
            return Math.Sqrt(Math.Pow((a - x), 2) + Math.Pow((b - y), 2));
        }
    }
}