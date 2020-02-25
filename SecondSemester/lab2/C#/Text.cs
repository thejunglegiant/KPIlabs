using System;
using static lab2.Line;

namespace lab2 {
    class Text {
        private int n;
        private Line[] text;

        public Text(int n, Line[] text) {
            this.n = n;
            this.text = text;
        }

        public void outputText() {
            for (int i = 0;i < n; i++) {
                text[i].outputString();
                Console.WriteLine();
            }
        }

        public void addLine(Line line) {
            text[n++] = line;
        }

        public void removeLine(int pos) {
            for (int i = pos-1; i < n; i++) {
                text[i] = text[i + 1];
            }
            n--;
        }

        public void clearText() {
            for (int i = 0; i < n; i++) {
                text[i] = new Line();
            }
            n = 0;
        }

        public Line findBiggest() {
            int max = 0;
            int maxLen = text[0].getLength();
            for (int i = 0; i < n; i++) {
                if (maxLen < text[i].getLength()) {
                    maxLen = text[i].getLength();
                    max = i;
                }
            }

            return text[max];
        }

        public float getPercentage(char obj) {
            float times = 0, total = 0;
            for (int i = 0; i < n; i++) {
                times += text[i].findElement(obj);
                total += text[i].getLength();
            }

            return (times / total);
        }

        public int getLength() {
            int total = 0;
            for (int i = 0; i < n; i++) {
                total += text[i].getLength();
            }

            return total;
        }
    }
}
