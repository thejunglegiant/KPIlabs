using System;

namespace lab3 {
    class Indexer {
        private int[,] array;
        private int n;
        private int m;

        public Indexer(int[,] array, int n, int m) {
            this.array = array;
            this.n = n;
            this.m = m;
        }

        public double this[int n] {
            get {
                double sum = 0;
                for(int i = 0; i < 4; i++) {
                    sum += Math.Pow((double)(this.array[n,i]), (double)2);
                }

                return Math.Sqrt(sum);
            }
        }

        public int sumAll {
            get {
                int sum = 0;

                for(int i = 0; i < this.n; i++) {
                    for(int j = 0; j < this.m; j++) {
                        sum += this.array[i,j];
                    }
                }

                return sum;
            }
        }

        public void printArray() {
            for(int i = 0; i < this.n; i++) {
                for(int j = 0; j < this.m; j++) {
                    Console.Write(this.array[i,j] + "\t");
                }
                Console.WriteLine();
            }
        }
    }
}