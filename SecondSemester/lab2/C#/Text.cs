using System;
using static lab2.Line;

namespace lab2 {
    class Text {
        private Line[] text;

        public Text(Line[] text) {
            this.text = text;
        }

        public void outputText() {
            for (int i = 0;i < text.Length; i++) {
                text[i].outputString();
                Console.WriteLine();
            }
        }

        public void addLine(Line line) {
            Array.Resize<Line>(ref text, text.Length + 1);
            text[text.Length - 1] = line;
        }

        public void removeLine(int pos) {
            for (int i = pos-1; i < text.Length - 1; i++) {
                text[i] = text[i + 1];
            }

            Array.Resize(ref text, text.Length - 1);
        }

        public void clearText() {
            Array.Resize(ref text, 0);
        }

        public Line findBiggest() {
            int max = 0;
            int maxLen = text[0].getLength();
            for (int i = 0; i < text.Length; i++) {
                if (maxLen < text[i].getLength()) {
                    maxLen = text[i].getLength();
                    max = i;
                }
            }

            return text[max];
        }

        public float getPercentage(char obj) {
            float times = 0, total = 0;
            for (int i = 0; i < text.Length; i++) {
                times += (float)text[i].findElement(obj);
                total += (float)text[i].getLength();
            }

            return (times / total);
        }

        public int getLength() {
            int total = 0;
            for (int i = 0; i < text.Length; i++) {
                total += text[i].getLength();
            }

            return total;
        }
    }
}
