using System;

namespace lab8 {
    public class LinkedList {
        private int size;
        private Node root;

        public LinkedList() {
            this.size = 0;
            this.root = new Node();
        }

        public void push(int x) {
            Node currentNode = root;

            while (true) {
                if (currentNode.Next == null) {
                    currentNode.Next = new Node(x);
                    this.size += 1;
                    break;
                }

                currentNode = currentNode.Next;
            }
        }

        public void pop() {
            Node currentNode = root;

            while (true) {
                if (currentNode.Next.Next == null) {
                    currentNode.Next = null;
                    break;
                }

                currentNode = currentNode.Next;
            }
        }

        public int findAllMultiplesOfFive() {
            int counter = 0;
            Node currentNode = root.Next;

            while (true) {
                if (currentNode.Value % 5 == 0) {
                    counter++;
                }
                if (currentNode.Next == null) {
                    break;
                }

                currentNode = currentNode.Next;
            }

            return counter;
        }

        private Node findMaxNode() {
            Node currentNode = root;
            int max = currentNode.Value;
            Node maxNode = currentNode;

            for (int i = 0; i < this.size; i++) {
                if (max < currentNode.Next.Value) {
                    max = currentNode.Next.Value;
                    maxNode = currentNode.Next;
                }

                currentNode = currentNode.Next;
            }

            return maxNode;
        }

        public void deleteAllAfterMax() {
            Node maxNode = this.findMaxNode();
            maxNode.Next = null;
        }

        public void printList() {
            Node currentNode = root;

            while (true) {
                Console.Write(currentNode.Value + " ");
                if (currentNode.Next == null)
                    break;

                currentNode = currentNode.Next;
            }
            Console.WriteLine();
        }
    }
}