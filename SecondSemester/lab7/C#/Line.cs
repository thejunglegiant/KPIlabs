using System;

namespace lab7 {
    public class Line {
        public delegate void myDelegate();
        public event myDelegate LineOverloadEvent;

        private int[] array;
        private int currentElem;

        public Line(int size) {
            this.currentElem = 0;
            this.array = new int[size];
        }

        public Line(int[] array) {
            this.currentElem = array.Length;
            this.array = array;
        }

        public void push(int elem) {
            if (this.currentElem >= this.array.Length) {
                LineOverloadEvent?.Invoke();
            } else {
                this.array[this.currentElem] = elem;
                this.currentElem++;
            }
        }

        public void remove() {
            this.currentElem--;
            int[] newArray = new int[this.array.Length];
            for (int i = 1; i < this.array.Length; i++)
                newArray[i - 1] = this.array[i];

            this.array = newArray;
        }

        public void printArray() {
            for (int i = 0; i < this.currentElem; i++)
                Console.Write(this.array[i] + " ");
            Console.WriteLine();
        }

        public static int[] Sort(int[] arr) {
            for (int j = 0; j < arr.Length; j++) {
                for (int k = j; k < arr.Length; k++) {
                    if (arr[j] < arr[k]) {
                        int temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                    }
                }
            }

            return arr;
        }

        public int[] getSorted() {
            return Line.Sort(this.array);
        }
    }
}