using System;

namespace lab5 {
    class Rectangle : Shape {
        private double width, length;

        public Rectangle(double[,] coord) : base(coord) {
            this.width = this.getLength(
                this.coord[0,0],
                this.coord[0,1],
                this.coord[0,0],
                this.coord[1,1]
            );
            this.length = this.getLength(
                this.coord[0,0],
                this.coord[0,1],
                this.coord[1,0],
                this.coord[0,1]
            );
        }

        public double getArea() {
            return this.width * this.length;
        }

        public double getPerimeter() {
            return 2 * (this.width + this.length);
        }

        public void getInfo() {
            Console.WriteLine("Width: " + this.width + "\nLength: " + this.length);
        }
    }
}