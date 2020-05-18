using System;

namespace lab8 {
    public class LinkedList {
        private int size;
        private int[] _list;

        public LinkedList() {
            this.size = 1;
            this._list = new int[size];
        }

        public void push(int x) {
            int[] tmp = new int[++this.size];
            tmp[1] = x;

            for (int i = 1; i < this.size - 1; i++)
                tmp[i + 1] = this._list[i];
            
            this._list = tmp;
        }

        public void pop() {
            Array.Resize(ref this._list, --this.size);
        }

        public int findAllMultiplesOfFive() {
            int counter = 0;

            for (int i = 1; i < this.size; i++)
                if (this._list[i] % 5 == 0)
                    counter++;

            return counter;
        }

        private int findIndexOfMax() {
            int max = this._list[0];
            int index = 0;

            for (int i = 0; i < this.size; i++) {
                if (max < this._list[i]) {
                    max = this._list[i];
                    index = i;
                }
            }

            return index;
        }

        public void deleteAllAfterMax() {
            this.size = this.findIndexOfMax() + 1;
            int[] tmp = new int[this.size];

            for (int i = 0; i < this.size; i++) {
                tmp[i] = this._list[i];
            }

            this._list = tmp;
        }

        public void printList() {
            foreach (int item in this._list)
                Console.Write(item + " ");
            Console.WriteLine();
        }
    }
}