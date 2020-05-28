using System;

namespace lab8 {
    internal class Node {
        public int Value { get; set; }
        public Node Next { get; set; }

        public Node() {
            this.Value = 0;
            this.Next = null;
        }

        public Node(int val) {
            this.Value = val;
            this.Next = null;
        }
    }
}